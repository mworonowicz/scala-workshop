package scalaworkshop

object ScalaGeneric extends App {

  val list = MyList(1, 2, 3)

  println(0 :: list)

  println(list.head)

  println(list.length)

}
abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def length: Int
  def ::[B >: A](item: B): MyList[B] = MyListImpl(item, this)
}

case class MyListImpl[A](head: A, tail: MyList[A]) extends MyList[A] {
  def isEmpty = false
  def length: Int = 1 + tail.length
  override def toString: String = head + " " + tail
}

object MyListNil extends MyList[Nothing] {
  def head: Nothing = throw new Exception("head of empty list")
  def tail: MyList[Nothing] = throw new Exception("tail of empty list")
  def isEmpty = true
  def length = 0
  override def toString = ""
}

object MyList {
  def apply[A](items: A*): MyList[A] = {

    def append(list: MyList[A], items: List[A]): MyList[A] = {
      items match {
        case Nil => list
        case head :: xs => append(head :: list, xs)
      }
    }
    append(MyListNil, items.toList.reverse)
  }
}