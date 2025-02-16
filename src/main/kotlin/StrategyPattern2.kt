package org.example

// Define the strategy interface
interface PaymentStrategy {
    fun pay(amount: Double)
}

// Concrete implementation of a payment strategy: Credit Card
class CreditCardPaymentStrategy(private val cardNumber: String,
                                private val expiryDate: String,
                                private val cvv: String)
    : PaymentStrategy {
    override fun pay(amount: Double) {
        // Logic for credit card payment
        println("Paid $amount using credit card $cardNumber")
    }
}

// Concrete implementation of a payment strategy: PayPal
class PayPalPaymentStrategy(private val email: String) : PaymentStrategy {
    override fun pay(amount: Double) {
        // Logic for PayPal payment
        println("Paid $amount using PayPal with email $email")
    }
}

// Context class that uses the strategy
class ShoppingCart(private val paymentStrategy: PaymentStrategy) {
    fun checkout(amount: Double) {
        paymentStrategy.pay(amount)
    }
}

fun main() {
    // Client code
    val creditCardStrategy = CreditCardPaymentStrategy("1234-5678-9012-3456", "12/24", "123")
    val payPalStrategy = PayPalPaymentStrategy("john.doe@example.com")

    val shoppingCart1 = ShoppingCart(creditCardStrategy)
    val shoppingCart2 = ShoppingCart(payPalStrategy)

    shoppingCart1.checkout(100.0)
    shoppingCart2.checkout(50.0)
}