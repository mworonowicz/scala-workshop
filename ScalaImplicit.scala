package scalaworkshop

object ScalaImplicit extends App {

  // implicit conversion function
  implicit def stringToDSL(value: String): DSL = new DSL(value)

  "Application" should "works" in {
    println("is it working?")
  }

  import MyImplicits._

  println(2 power 2)

}

class DSL(value: String) {
  def should(v1: String) = this
  def in(block: => Unit) = {
    println("checking")
    block
    println("success")
  }
}

// implicit class
object MyImplicits {

  implicit class Power(value: Int) {
    def power(v1: Int) = math.pow(value, v1)
  }

}

