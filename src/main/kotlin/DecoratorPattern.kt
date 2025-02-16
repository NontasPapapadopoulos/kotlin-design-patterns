package org.example

// Component interface
interface Car {
    fun drive()
}

// Concrete component
class BasicCar : Car {
    override fun drive() {
        println("Move from A to B")
    }
}

// Extension function for Car interface
fun Car.decorate(initialize: () -> Unit): Car {
    return object : Car {
        override fun drive() {
            initialize()
            this@decorate.drive()
        }
    }
}

fun main() {
    // Create a basic car
    val myBasicCar: Car = BasicCar()

    // Decorate it to make it an offroad car
    val offroadCar: Car = myBasicCar.decorate {
        println("Configure offroad driving mode")
    }

    // Drive the offroad car
    offroadCar.drive()
}