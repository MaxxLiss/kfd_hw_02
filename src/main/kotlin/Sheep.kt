import kotlin.math.floor

class Sheep private constructor(
    override val speed: Int
) : Transport{
    companion object {
        fun build() : Sheep {
            val minSpeed = SegmentSpeed.Sheep.minSpeed
            val maxSpeed = SegmentSpeed.Sheep.maxSpeed

            print("Введите максимальную скороть в отрезке от $minSpeed до $maxSpeed: ")

            var input : Double = readln().toDoubleOrNull() ?: -1.0
            var speed = if (floor(input) == input) input.toInt() else -1
            while (speed < minSpeed || speed > maxSpeed) {
                println("Это неподходящая скорость для корабля")
                print("Введите максимальную скороть в отрезке от $minSpeed до $maxSpeed: ")
                input = readln().toDoubleOrNull() ?: -1.0
                speed = if (floor(input) == input) input.toInt() else -1
            }
            return Sheep(speed)
        }
    }

    override fun move(): String {
        return "Я плыву со скоростью $speed км/ч!"
    }
}