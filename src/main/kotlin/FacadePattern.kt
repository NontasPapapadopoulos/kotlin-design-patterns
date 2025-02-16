package org.example

/*

The Facade design pattern provides a simplified interface to a set of interfaces in a subsystem, making it easier to use.
It involves creating a class that represents a higher-level, unified interface that makes it easier for clients to interact with a subsystem.
This can help simplify the usage of complex systems by providing a single entry point.

*/

class CPU {
    fun processData() {
        println("Processing data...")
    }
}

class Memory {
    fun load() {
        println("Loading data into memory...")
    }
}

class HardDrive {
    fun readData() {
        println("Reading data from hard drive...")
    }
}

// Facade class
class ComputerFacade(
    private val cpu: CPU,
    private val memory: Memory,
    private val hardDrive: HardDrive
) {
    fun start() {
        println("ComputerFacade starting...")
        cpu.processData()
        memory.load()
        hardDrive.readData()
        println("ComputerFacade started successfully.")
    }
}

// Client code
fun main() {
    // Create subsystem components
    val cpu = CPU()
    val memory = Memory()
    val hardDrive = HardDrive()

    // Create facade and pass subsystem components to it
    val computerFacade = ComputerFacade(cpu, memory, hardDrive)

    // Client interacts with the subsystem through the facade
    computerFacade.start()
}
