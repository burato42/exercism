class Robot(direction: Bearing.Value, position: Tuple2[Int, Int])  {
    var dir = direction
    var pos = position

    def turnRight: Robot = {
        dir match {
            case Bearing.North => dir = Bearing.East
            case Bearing.East => dir = Bearing.South
            case Bearing.South => dir = Bearing.West
            case Bearing.West => dir = Bearing.North
        }
        this
    }

    def turnLeft: Robot = {
        dir match {
            case Bearing.North => dir = Bearing.West
            case Bearing.East => dir = Bearing.North
            case Bearing.South => dir = Bearing.East
            case Bearing.West => dir = Bearing.South
        }
        this
    }

    def advance: Robot = {
        dir match {
            case Bearing.North => pos = (pos._1, pos._2 + 1)
            case Bearing.East => pos = (pos._1 + 1, pos._2)
            case Bearing.South => pos = (pos._1, pos._2 - 1)
            case Bearing.West => pos = (pos._1 - 1, pos._2)
        }
        this
    }

    def simulate(str: String): Robot = {
        str.map(symbol => {
            symbol match {
                case 'R' => turnRight
                case 'L' => turnLeft
                case 'A' => advance
            }
        })
        this
    }

    def coordinates: (Int, Int) = pos

    def bearing: Bearing.Value = dir

}


object Robot {
    val robot = new Robot(Bearing.North, (0, 0))
    def apply(direction: Bearing.Value, position: Tuple2[Int, Int]): Robot = {
        robot.dir = direction
        robot.pos = position
        robot
    }
}

