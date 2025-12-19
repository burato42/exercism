case class Robot(direction: Bearing.Value, position: Tuple2[Int, Int])  {
    var dir = direction
    var pos = position

    def turnRight: Robot = {
        dir match {
            case Bearing.North => dir = Bearing.East
            case Bearing.East => dir = Bearing.South
            case Bearing.South => dir = Bearing.West
            case Bearing.West => dir = Bearing.North
        }
        Robot(dir, pos)
    }

    def turnLeft: Robot = {
        dir match {
            case Bearing.North => dir = Bearing.West
            case Bearing.East => dir = Bearing.North
            case Bearing.South => dir = Bearing.East
            case Bearing.West => dir = Bearing.South
        }
        Robot(dir, pos)
    }

    def advance: Robot = {
        dir match {
            case Bearing.North => pos = (pos._1, pos._2 + 1)
            case Bearing.East => pos = (pos._1 + 1, pos._2)
            case Bearing.South => pos = (pos._1, pos._2 - 1)
            case Bearing.West => pos = (pos._1 - 1, pos._2)
        }
        Robot(dir, pos)
    }

    def simulate(str: String): Robot = {
        str.map(symbol => {
            symbol match {
                case 'R' => turnRight
                case 'L' => turnLeft
                case 'A' => advance
            }
        })
        Robot(dir, pos)
    }

    def coordinates: (Int, Int) = pos

    def bearing: Bearing.Value = dir

}