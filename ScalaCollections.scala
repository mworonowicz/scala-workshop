package scalaworkshop

object ScalaCollections extends App {

  val list = List(2, 3, 4)

  var concat = (1 +: list :+ 5) ++ (6 :: 7 :: Nil)

  concat :+= 8
  println(concat)

  concat match {
    case head :: tail =>
      println(s"head is $head")
      tail match {
        case xs :+ x => println(s"last is $x")
      }
    case Nil => println("empty list")

  }

  // higher order functions

  println(concat.filter(_ % 2 == 0).map(_ * 2).mkString(","))

  println(concat.map(p => if (p % 3 == 0) Some(p) else None))
  println(concat.map(p => if (p % 3 == 0) Some(p) else None).flatten)

  println(concat.flatMap(p => if (p % 3 == 0) Some(p) else None))

  println(concat.map(p => if (p % 3 == 0) Some(p) else None).map(_.fold("nope")(p => s"There is $p")))

  //for comprehensions

  val l1 = for {
    p1 <- concat if p1 % 2 == 0
    p2 = p1 * 2
  } yield p2

  println(l1)

  val l2 = for {
    p1 <- concat
    p2 = if (p1 % 3 == 0) Some(p1) else None
    p3 <- p2
  } yield p3

  println(l2)

  val l3 = for {
    i <- 1 to 10
    j <- 0 until 10
    v = i * j
  } yield v

  println(l3)

  //  maps

  val m1 = Map((1, "one"), (2, "two"), (3 -> "three")) + (4 -> "four")

  println(m1(1))
  println(m1.get(5))
  println(m1.getOrElse(5, "nothing"))

  println(m1.mapValues(_ + "!") - (1, 3))

}

