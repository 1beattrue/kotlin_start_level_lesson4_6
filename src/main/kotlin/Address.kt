// домашнее задание
class Address (val city: String, val street: String, val numberOfHouse: Int) {

    override fun toString(): String {
        return "Address(city='$city', street='$street', numberOfHouse=$numberOfHouse)"
    }

    override fun hashCode(): Int {
        var result = city.hashCode()
        result = 31 * result + street.hashCode()
        result = 31 * result + numberOfHouse
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        if (city != other.city) return false
        if (street != other.street) return false
        return numberOfHouse == other.numberOfHouse
    }

    operator fun component1() = city
    operator fun component2() = street
    operator fun component3() = numberOfHouse

    fun copy(city: String = this.city, street: String = this.street, numberOfHouse: Int = this.numberOfHouse): Address {
        return Address(city, street, numberOfHouse)
    }
}