import kotlin.random.Random

// 1 - Победа, 0 - Проигрыш, 2 - Ничья
private fun getWinner(user : Int, bot : Int) : Int {
    if (user == 1 && bot == 2) { println("Вы победили!"); return 1}
    else if (user == 2 && bot == 3) { println("Вы победили!"); return 1}
    else if (user == 3 && bot == 1) { println("Вы победили!"); return 1}
    else if (user == bot) { println("Ничья, переиграйте снова"); return 2}
    else { println("Вы проиграли!"); return 0 }
}

private fun numToString(num: Int) : String {
    if (num == 1) {return "Камень"}
    else if (num == 2) {return "Ножницы"}
    else if (num == 3) {return "Бумага"}
    else {return "Неверный выбор!"}
}

fun main() {
    // Задача 1.
    do {
        print("Ваш выбор (1 - Камень, 2 - Ножницы, 3 - Бумага): ")
        var userChoice: Int = readln().toInt()
        var botChoice: Int = (1 until 3).random()
        println("Ваш выбор: ${numToString(userChoice)}")
        println("Выбор компьютера: ${numToString(botChoice)}")
        var playResult = getWinner(userChoice, botChoice)
    } while (playResult == 2)
}