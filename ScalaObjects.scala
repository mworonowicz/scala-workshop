package scalaworkshop

object ScalaObjects extends App {

  //constructors

  class Car(hp: Int) {

    def this() = {
      this(150)
      println("nice car")
    }

    override def toString = s"hp $hp with ${Car.maxSpeed(hp)} max speed"
  }

  new Car()

  // companion object
  object Car {
    def apply() = new Car(100)
    def maxSpeed(hp: Int) = 2 * hp
  }

  println(Car())

  // composition with traits

  trait Engine {
    def speedup = println("speeding up")
  }

  trait Brakes {
    def braking = println("breaking")
  }

  class Ford(hp: Int) extends Car(hp) with Engine with Brakes {

    def ride = {
      println("start engine")
      speedup
      braking
      println("stop")
    }
  }

  val ford = new Ford(200)
  println(ford)
  ford.ride

}
