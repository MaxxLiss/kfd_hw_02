import kotlin.math.floor

class Plane private constructor(
    override val speed: Int
) : Transport {
    companion object {
        fun build() : Plane {
            val minSpeed = SegmentSpeed.Plane.minSpeed
            val maxSpeed = SegmentSpeed.Plane.maxSpeed

            print("Введите максимальную скороть в отрезке от $minSpeed до $maxSpeed: ")

            var input : Double = readln().toDoubleOrNull() ?: -1.0
            var speed = if (floor(input) == input) input.toInt() else -1
            while (speed < minSpeed || speed > maxSpeed) {
                println("Это неподходящая скорость для самолёта")
                print("Введите максимальную скороть в отрезке от $minSpeed до $maxSpeed: ")
                input = readln().toDoubleOrNull() ?: -1.0
                speed = if (floor(input) == input) input.toInt() else -1
            }
            return Plane(speed)
        }
    }

    override fun move() : String {
        return "Я лечу со скоростью $speed км/ч!"
    }
}