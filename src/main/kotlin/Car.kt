import kotlin.math.floor

class Car private constructor (
    override val speed: Int
) : Transport {
    companion object {
        fun build() : Car {
            val minSpeed = SegmentSpeed.Car.minSpeed
            val maxSpeed = SegmentSpeed.Car.maxSpeed

            print("Введите максимальную скороть в отрезке от $minSpeed до $maxSpeed: ")

            var input : Double = readln().toDoubleOrNull() ?: -1.0
            var speed = if (floor(input) == input) input.toInt() else -1
            while (speed < minSpeed || speed > maxSpeed) {
                println("Это неподходящая скорость для машины")
                print("Введите максимальную скороть в отрезке от $minSpeed до $maxSpeed: ")
                input = readln().toDoubleOrNull() ?: -1.0
                speed = if (floor(input) == input) input.toInt() else -1
            }
            return Car(speed)
        }
    }

    override fun move(): String {
        return ("Я еду со скоростью $speed км/ч!")
    }
}