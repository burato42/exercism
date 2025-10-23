package tournament

import (
	"errors"
	"fmt"
	"io"
	"sort"
	"strings"
)

type Record struct {
	matchesPlayed, wins, drawns, loses, points int
}

type Table map[string]Record

func Tally(reader io.Reader, writer io.Writer) error {
	table := make(Table)
	content, err := io.ReadAll(reader)
	if err != nil {
		return err
	}
	text := string(content)
	gameResults := strings.Split(text, "\n")
	for _, line := range gameResults {
		if strings.HasPrefix(line, "#") || line == "" {
			continue
		}
		cols := strings.Split(line, ";")
		if len(cols) != 3 {
			return errors.New("wrong record")
		}
		home := strings.TrimSpace(cols[0])
		away := strings.TrimSpace(cols[1])
		result := strings.TrimSpace(cols[2])

		switch result {
		case "win":
			r := table[home]
			r.matchesPlayed++
			r.wins++
			r.points += 3
			table[home] = r

			r = table[away]
			r.matchesPlayed++
			r.loses++
			table[away] = r
		case "draw":
			r := table[home]
			r.matchesPlayed++
			r.drawns++
			r.points += 1
			table[home] = r

			r = table[away]
			r.matchesPlayed++
			r.drawns++
			r.points += 1
			table[away] = r
		case "loss":
			r := table[home]
			r.matchesPlayed++
			r.loses++
			table[home] = r

			r = table[away]
			r.matchesPlayed++
			r.wins++
			r.points += 3
			table[away] = r
		default:
			return errors.New("wrong result parameter")
		}
	}

	teams := make([]string, 0, len(table))
	for team := range table {
		teams = append(teams, team)
	}

	sort.Slice(teams, func(i, j int) bool {
		if table[teams[i]].points == table[teams[j]].points {
			return teams[i] < teams[j]
		}
		return table[teams[i]].points > table[teams[j]].points
	})

	writer.Write([]byte("Team                           | MP |  W |  D |  L |  P\n"))
	for _, team := range teams {
		record := table[team]
		fmt.Fprintf(writer, "%-31s| %2d | %2d | %2d | %2d | %2d\n", team, record.matchesPlayed, record.wins, record.drawns, record.loses, record.points)
	}

	return nil
}
