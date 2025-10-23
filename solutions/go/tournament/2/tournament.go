package tournament

import (
	"errors"
	"fmt"
	"io"
	"sort"
	"strings"
)

const (
	WinPoints  = 3
	DrawPoints = 1
	HeaderLine = "Team                           | MP |  W |  D |  L |  P\n"
)

type Record struct {
	matchesPlayed, wins, drawns, loses, points int
}

type Table map[string]Record

func updateTeamResult(table Table, team string, resultType string) {
	r := table[team]
	r.matchesPlayed++

	switch resultType {
	case "win":
		r.wins++
		r.points += WinPoints
	case "draw":
		r.drawns++
		r.points += DrawPoints
	case "loss":
		r.loses++
	}

	table[team] = r
}

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
			updateTeamResult(table, home, "win")
			updateTeamResult(table, away, "loss")
		case "draw":
			updateTeamResult(table, home, "draw")
			updateTeamResult(table, away, "draw")
		case "loss":
			updateTeamResult(table, home, "loss")
			updateTeamResult(table, away, "win")
		default:
			return errors.New("non-existing result")
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

	writer.Write([]byte(HeaderLine))
	for _, team := range teams {
		record := table[team]
		fmt.Fprintf(writer, "%-31s| %2d | %2d | %2d | %2d | %2d\n",
			team, record.matchesPlayed, record.wins, record.drawns, record.loses, record.points)
	}

	return nil
}
