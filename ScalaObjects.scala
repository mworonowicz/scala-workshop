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

  // pattern matching

  sealed trait Sport

  case class Golf(holes: Int) extends Sport
  case class Darts(points: Int) extends Sport
  case class Football(score: (Int, Int)) extends Sport
  case class Volleyball(set1: (Int, Int), set2: (Int, Int), set3: (Int, Int), set4: Option[(Int, Int)] = None, set5: Option[(Int, Int)] = None) extends Sport

  def showScores(score: Sport) = score match {
    case Golf(s) => println(s"$s holes")
    case Darts(p) if p > 0 => println(s"$p points")
    case Football(s) => println(s"${s._1} goals to ${s._2}")
    case v: Volleyball => {

      def showSetScore(n: Int, set: (Int, Int)) = println(s"${n}st set ${set._1}:${set._2}")
      showSetScore(1, v.set1)
      showSetScore(2, v.set2)
      showSetScore(3, v.set3)
      v.set4.map(showSetScore(4, _))
      v.set5.map(showSetScore(5, _)).getOrElse(println("no tie break"))

    }
    case _ => println("wrong score")
  }

  showScores(Golf(2))
  showScores(Darts(3))
  showScores(Darts(-3))
  showScores(Football(3, 2))

  val volleyballScore = Volleyball((25, 23), (23, 25), (25, 20), Some((25, 19)))
  showScores(volleyballScore)
  showScores(volleyballScore.copy(set5 = Some(15, 13)))

  //linearization

  trait Fruit {
    override def toString = "Fruit"
  }

  trait Mango extends Fruit {
    println("add Mango")
    override def toString = super.toString + " with Mango"
  }

  trait Orange extends Fruit {
    println("add Orange")
    override def toString = super.toString + " with Orange"
  }

  trait Apple extends Fruit {
    println("add Apple")
    override def toString = super.toString + " with Apple"
  }

  class Salad extends Fruit {
    println("Let's do a salad")
    override def toString = super.toString + " Salad"
  }

  class FruitSalad extends Salad with Apple with Mango with Orange {
    println("Fruit salad is done")
    override def toString = super.toString + " is awesome"
  }

  println(new FruitSalad())
}
