package org.example

/*
* The Observer design pattern is a behavioral design pattern where an object, known as the subject, maintains a list of its dependents, known as observers, that are notified of any state changes.
* This pattern is often used to implement distributed event handling systems.
*
* */




// Define an interface for the observer
interface Observer {
    fun update(value: Int)
}

// Define a concrete observer that implements the Observer interface
class ValueObserver(private val name: String) : Observer {
    override fun update(value: Int) {
        println("$name received value: $value")
    }
}

// Define a subject that emits values and notifies observers
class ValueSubject {
    private val observers = mutableListOf<Observer>()

    fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    private val observable: Flow<Int> = flow {
        while (true) {
            emit(Random.nextInt(0..1000))
            delay(100)
        }
    }

    fun startObserving() {
        val observerJob = coroutineScope.launch {
            observable.collect { value ->
                notifyObservers(value)
            }
        }
    }

    private fun notifyObservers(value: Int) {
        for (observer in observers) {
            observer.update(value)
        }
    }
}