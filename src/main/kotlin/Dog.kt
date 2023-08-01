class Dog (val name: String, val age: Int) {

    fun copy(name: String = this.name, age: Int = this.age): Dog {
        return Dog(name, age)
    }

}