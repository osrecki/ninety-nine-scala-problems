package me.osrecki.prog.scala.ninety_nine.lists

/**
  *  Rotate a list N places to the left.
  *
  * ==Example==
  * {{{
  * scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  * res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
  *
  * scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  * res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
  * }}}
  */
object Problem19 {
  def rotate[A](n: Int, list: Seq[A]): Seq[A] = {
    if(list.isEmpty) Nil
    else {
      val m = n % list.size
      val o = if (m < 0) m + list.size else m

      (list drop o) ++: (list take o)
    }
  }
}
