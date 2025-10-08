import kotlin.random.Random

//Функции задачи 1

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

//Функции задачи 2

private fun baseTable () : MutableMap<String, MutableMap<String,Int>> {
    val alphabet = "АБВГДЕЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
    var table : MutableMap<String, MutableMap<String,Int>> = mutableMapOf()
    var counter : Int = 1
    for (i in 0..alphabet.count()-1) {
        var rowKey = alphabet[i].toString()
        var rowMap: MutableMap<String, Int> = mutableMapOf()
        for (j in 0..alphabet.count()-1) {
            var colKey = alphabet[j].toString()
            rowMap[colKey] = counter
            counter+=1
        }
        table[rowKey] = rowMap
        //print(rowMap)
    }

    return table
}

fun main() {
    // Задача 1

    var playResult : Int = -1
    do {
        print("Ваш выбор (1 - Камень, 2 - Ножницы, 3 - Бумага): ")
        var userChoice: Int = readln().toInt()
        if (userChoice > 3 || userChoice < 1) {playResult = -1; println("Неправильный выбор!"); continue}
        var botChoice: Int = (1 until 3).random()
        println("Ваш выбор: ${numToString(userChoice)}")
        println("Выбор компьютера: ${numToString(botChoice)}")
        playResult = getWinner(userChoice, botChoice)
    } while (playResult == 2 || playResult == -1)

    //Задача 2. Биграммный шифр Порты

    //baseTable()
}