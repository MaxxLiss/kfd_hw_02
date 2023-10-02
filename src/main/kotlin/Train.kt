import kotlin.math.floor

class Train private constructor(
    override val speed: Int
) : Transport {
    companion object {
        fun build() : Train {
            val minSpeed = SegmentSpeed.Train.minSpeed
            val maxSpeed = SegmentSpeed.Train.maxSpeed

            print("Введите максимальную скороть в отрезке от $minSpeed до $maxSpeed: ")

            var input : Double = readln().toDoubleOrNull() ?: -1.0
            var speed = if (floor(input) == input) input.toInt() else -1
            while (speed < minSpeed || speed > maxSpeed) {
                println("Это неподходящая скорость для поезда")
                print("Введите максимальную скороть в отрезке от $minSpeed до $maxSpeed: ")
                input = readln().toDoubleOrNull() ?: -1.0
                speed = if (floor(input) == input) input.toInt() else -1
            }
            return Train(speed)
        }
    }

    override fun move(): String {
        return "Я еду со скоростью $speed км/ч!"
    }
}