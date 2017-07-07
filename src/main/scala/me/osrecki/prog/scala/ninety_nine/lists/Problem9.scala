package me.osrecki.prog.scala.ninety_nine.lists

/**
 * Pack consecutive duplicates of list elements into sub-lists.
 *  If a list contains repeated elements they should be placed in separate
 *  sub-lists.
 *
 *  ==Example==
 *  {{{
 *  scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 *  res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c),
 *   List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 *  }}}
 */
object Problem9 {
  def packFold[A](list: Seq[A]): Seq[Seq[A]] = {
    list.foldRight(Seq.empty[Seq[A]]) { (elem, packed) =>
      if (packed.isEmpty || packed.head.head != elem) Seq(elem) +: packed
      else (elem +: packed.head) +: packed.tail
    }
  }

  def packRecursive[A](list: Seq[A]): Seq[Seq[A]] = {
    def innerRecursion(list: Seq[A], packed: Seq[Seq[A]]): Seq[Seq[A]] =
      list match {
        case head +: _ =>
          val (grouped, rest) = list.span(_ == head)
          innerRecursion(rest, grouped +: packed)
        case _ =>
          packed.reverse
      }

    innerRecursion(list, Seq.empty[Seq[A]])
  }
}
