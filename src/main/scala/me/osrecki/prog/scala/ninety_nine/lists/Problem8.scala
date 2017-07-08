package me.osrecki.prog.scala.ninety_nine.lists

import scala.annotation.tailrec

/**
 * ==Problem==
 * Eliminate consecutive duplicates of list elements.
 * If a list contains repeated elements they should be replaced with a single
 * copy of the element. The order of the elements should not be changed.
 *
 * ==Example==
 * {{{
 * scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
 * }}}
 */
object Problem8 {
  def compressFold[A](list: Seq[A]): Seq[A] =
    list.foldRight(Seq.empty[A]) { (elem, compressed) =>
      if (compressed.isEmpty || compressed.head != elem) elem +: compressed
      else compressed
    }

  def compressRecursive[A](list: Seq[A]): Seq[A] = {
    @tailrec
    def innerRecursion(list: Seq[A], compressed: Seq[A]): Seq[A] = list match {
      case head +: tail => innerRecursion(tail.dropWhile(_ == head), head +: compressed)
      case _            => compressed.reverse
    }

    innerRecursion(list, Seq.empty[A])
  }
}
