class Robot(letters: Int = 2, digits: Int = 3) {
    private def randomStringFromCharList(length: Int, chars: Seq[Char]): String = {
        val sb = new StringBuilder
        for (i <- 1 to length) {
            val randomNum = util.Random.nextInt(chars.length)
            sb.append(chars(randomNum))
        }
        sb.toString
    }
    
    var name = ""
    while (name == "" || RobotName.uniqueNames.contains(name)) {
        name = randomStringFromCharList(letters, ('A' to 'Z')).concat(randomStringFromCharList(digits, ('0' to '9')))
    }
    RobotName.uniqueNames.add(name)

    def reset(): Unit = {
        name = randomStringFromCharList(letters, ('A' to 'Z')).concat(randomStringFromCharList(digits, ('0' to '9')))
        while (name == "" || RobotName.uniqueNames.contains(name)) {
            name = randomStringFromCharList(letters, ('A' to 'Z')).concat(randomStringFromCharList(digits, ('0' to '9')))
        }
        RobotName.uniqueNames.add(name)
        // println(RobotName.uniqueNames)
    }
    
}