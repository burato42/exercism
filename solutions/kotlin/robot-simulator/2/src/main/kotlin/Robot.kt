class Robot(var gridPosition: GridPosition = GridPosition(0, 0),
            var orientation: Orientation = Orientation.NORTH) {

    private val orientationCount = Orientation.values().size


    fun simulate(instructions: String) {
        for (command in instructions) {
            when(command) {
                'L' -> turnLeft()
                'R' -> turnRight()
                'A' -> advance()
            }
        }
    }

    private fun turnLeft() {
        orientation = Orientation.values()[(orientation.ordinal - 1 + orientationCount) % orientationCount]
    }

    private fun turnRight() {
        orientation = Orientation.values()[(orientation.ordinal + 1) % orientationCount]
    }

    private fun advance() {
        gridPosition = when(orientation) {
            Orientation.NORTH -> GridPosition(gridPosition.x, gridPosition.y + 1)
            Orientation.EAST -> GridPosition(gridPosition.x + 1, gridPosition.y)
            Orientation.SOUTH -> GridPosition(gridPosition.x, gridPosition.y - 1)
            Orientation.WEST -> GridPosition(gridPosition.x - 1, gridPosition.y)
        }
    }

}
