package com.example.quizappsoccerplayers

object Constants {

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "¿Quién es el jugador?",
            R.drawable.messi,
            "Messi",
            "James",
            "Xavi",
            1
        )

        questionsList.add(que1)

        val que2 = Question(
            2,
            "¿Quién es el jugador?",
            R.drawable.halaand,
            "Maradona",
            "Iniesta",
            "Halaand",
            3
        )

        questionsList.add(que2)

        val que3 = Question(
            3,
            "¿Quién es el jugador?",
            R.drawable.kante,
            "Ter Stegen",
            "Kanté",
            "Ospina",
            2
        )

        questionsList.add(que3)

        val que4 = Question(
            4,
            "¿Quién es el jugador?",
            R.drawable.bicho,
            "El bicho/comandante",
            "Falcao",
            "Neymar",
            3
        )

        questionsList.add(que4)

        val que5 = Question(
            5,
            "¿Quién es el jugador?",
            R.drawable.courtois,
            "Manuel Neuer",
            "Courtois",
            "Oblack",
            2
        )

        questionsList.add(que5)

        val que6 = Question(
            6,
            "¿Quién es el jugador?",
            R.drawable.debruyne,
            "De Bruyne",
            "Sergio Busquéts",
            "Diego Godín",
            1
        )

        questionsList.add(que6)

        val que7 = Question(
            7,
            "¿Quién es el jugador?",
            R.drawable.mbape,
            "Pedri",
            "Luís Suarez",
            "Mbappé",
            3
        )

        questionsList.add(que7)

        val que8 = Question(
            8,
            "¿Quién es el jugador?",
            R.drawable.neymar,
            "Neymar Jr",
            "Sterling",
            "Coutinho",
            1
        )

        questionsList.add(que8)

        val que9 = Question(
            9,
            "¿Quién es el jugador?",
            R.drawable.son,
            "Kim Young",
            "Son",
            "Lee Yeoung",
            2
        )

        questionsList.add(que9)

        val que10 = Question(
            10,
            "¿Quién es el jugador?",
            R.drawable.dimaria,
            "Ángel Di Maria",
            "De Paul",
            "Valderrama",
            1
        )

        questionsList.add(que10)


        return questionsList
    }
}