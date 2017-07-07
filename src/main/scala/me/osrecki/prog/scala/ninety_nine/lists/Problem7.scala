package me.osrecki.prog.scala.ninety_nine.lists

/**
 * Flatten a nested list structure.
 *
 *  ==Example==
 *  {{{
 *  scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
 *  res0: List[Any] = List(1, 1, 2, 3, 5, 8)
 *  }}}
 */
object Problem7 {
  def flatten(list: Seq[Any]): Seq[Any] = list flatMap {
    case elemList: Seq[_] => flatten(elemList)
    case elem             => Seq(elem)
  }
}
