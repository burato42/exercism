class Robot(letters: Int = 2, digits: Int = 3) {
    private def randomStringFromCharList(length: Int, chars: Seq[Char]): String = {
        val sb = new StringBuilder
        for (i <- 1 to length) {
            val randomNum = util.Random.nextInt(chars.length)
            sb.append(chars(randomNum))
        }
        sb.toString
    }
    
    var name = newName()


    def newName(): String = {
        var cand = ""
        while (cand == "" || RobotName.uniqueNames.contains(cand)) {
            cand = randomStringFromCharList(letters, ('A' to 'Z')).concat(randomStringFromCharList(digits, ('0' to '9')))
        }
        RobotName.uniqueNames.add(cand)
        cand
    }

    def reset(): Unit = {
        name = newName()
    }
    
}