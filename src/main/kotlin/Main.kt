fun main() {
    // data классы

    val student1 = Student("Иван", "Иванов", "123")
    val student2 = Student("Иван", "Иванов", "123")

    println(student1)
    println(student2) // мы пока не переопределяли метод toString, поэтому здесь вызвалась стандартная его реализация класса Any

    println(student1.hashCode())
    println(student2.hashCode())

    println(student1 == student2) // отличие от java: == - сравнение объектов(equals), сравнение ссылок - ===
    println(student1 === student2)

    // добавим к определению класса Student слово data - новое понятие, введенное в kotlin
    // уаля! автоматически переопределился метод toString() и теперь он выводит информацию о полях объекта
    // переопределился метод hashCode() и теперь он зависит от полей объекта
    // также переопределился equals() и теперь он зависит от полей класса
    // с ссылками все понятно и логично - ссылки разные

    // но это не единственное отличие, также изменился деструктор
    val (name1, lastName1, id1) = student1 // () - деструктор/деструктивный оператор - из полей объекта делает набор переменных
    println("$name1 $lastName1 $id1")
    val (name2, _, id2) = student2 // если какая-то переменная не нужна - используем _ вместо нее

    /* заметим, что если мы вызываем деструктор не для data класса, мы самостоятельно должны переопределить методы
    * operator fun component1() = name
    * operator fun component2() = lastName
    * operator fun component3() = id
    * в data классе они переопределены автоматически */

    // также у data классов переопределен метод copy
    val student3 =
        student1.copy() // теперь student3 имеет такие же значения полей как student1, но ссылаются они на разные объекты
    val student4 = student3.copy(id = "321") // нам необязательно копировать объект полностью, можно изменить значения полей

    // задание: реализовать метод copy() самостоятельно
    val dog1 = Dog("Bobik", 10)
    val dog2 = dog1.copy(age = 3)
    println(dog1 == dog2)

    // домашнее задание - самостоятельная реализация data класса

    val address = Address("Москва", "Зеленая", 13)
    val addressCopy = address.copy()

    println(address)
    println(addressCopy)

    println(address.hashCode())
    println(addressCopy.hashCode())

    println(address == addressCopy)
    val (city, street, numberOfHouse) = address

    println("$city, $street, $numberOfHouse")
}