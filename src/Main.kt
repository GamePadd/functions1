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

private fun genBaseTable () : MutableMap<String, MutableMap<String,String>> {
    val alphabet = "АБВГДЕЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
    var table : MutableMap<String, MutableMap<String,String>> = mutableMapOf()
    var counter : Int = 1
    for (i in 0..alphabet.count()-1) {
        var rowKey = alphabet[i].toString()
        var rowMap: MutableMap<String, String> = mutableMapOf()
        for (j in 0..alphabet.count()-1) {
            var colKey = alphabet[j].toString()
            rowMap[colKey] = counter.toString().padStart(3,'0')
            counter+=1
        }
        table[rowKey] = rowMap
        //print(rowMap)
    }

    return table
}

fun main() {
    // Задача 1

    /*
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
    */

    //Задача 2. Биграммный шифр Порты
    var baseTable : MutableMap<String, MutableMap<String,String>> = genBaseTable()

    print("Введите исходное сообщение: ")
    var inpt = readln().uppercase()
    print("Напишите вспомогательный символ: ")
    var helpChar = readln().uppercase()
    print("Использовать типовую таблицу или генерировать случайную? (0 - Типовая, 1 - Случайная): ")
    var type = readln().toInt()

    var result : String = ""
    for (i in 0..inpt.count()-1 step 2) {
        var rowChar = inpt[i].toString()
        var colChar = " "

        if (i < inpt.count()-1) {colChar = inpt[i+1].toString()}
        else {colChar = helpChar}

        if (rowChar == " ") {rowChar = helpChar}
        if (colChar == " ") {colChar = helpChar}

        if(type == 0) {result += baseTable[rowChar]!![colChar]}
        result += " "
        //print("$rowChar$colChar ")
    }
    println("Зашифрованное сообщение: $result")
}