import kotlin.math.floor

fun main() {
    println("Какой транспорт выберете сегодня?")
    val arr = arrayOf(Plane::class, Car::class, Sheep::class, Train::class)
    for (i in arr.indices) {
        println("$i: ${arr[i].simpleName}")
    }

    var input : Double = readln().toDoubleOrNull() ?: -1.0
    var classID = if (floor(input) == input) input.toInt() else -1
    while (classID < 0 || classID > 3) {
        println("Вы ввели некорректное значение!")
        for (i in arr.indices) {
            println("$i: ${arr[i].simpleName}")
        }
        input = readln().toDoubleOrNull() ?: -1.0
        classID = if (floor(input) == input) input.toInt() else -1
    }

    println("Вы выбрали ${arr[classID].simpleName}")
    val transport = when (classID) {
        0 -> Plane.build()
        1 -> Car.build()
        2 -> Sheep.build()
        3 -> Train.build()
        else -> Plane.build()
    }

    println("Пора в путь!")
    println(transport.move())
}