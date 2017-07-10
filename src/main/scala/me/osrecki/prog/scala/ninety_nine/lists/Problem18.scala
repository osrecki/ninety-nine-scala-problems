package me.osrecki.prog.scala.ninety_nine.lists

/**
 * ==Problem==
 * Extract a slice from a list.
 * Given two indices, I and K, the slice is the list containing the elements
 * from and including the Ith element up to but not including the Kth element
 * of the original list. Start counting the elements with 0.
 *
 * ==Example==
 * {{{
 * scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 * res0: List[Symbol] = List('d, 'e, 'f, 'g)
 * }}}
 */
object Problem18 {
  def sliceBuiltIn[A](i: Int, k: Int, list: Seq[A]): Seq[A] = list.slice(i, k)

  //noinspection DropTakeToSlice
  def sliceFunctional[A](i: Int, k: Int, list: Seq[A]): Seq[A] = list.drop(i).take(k - Math.max(i, 0))

  def sliceRecursive[A](i: Int, k: Int, list: Seq[A]): Seq[A] = {
    def innerRecursion(j: Int, list: Seq[A], sliced: Seq[A]): Seq[A] =
      (j, list) match {
        case (_, Nil)                    => sliced.reverse
        case (_, _) if j >= k            => sliced.reverse
        case (_, head +: tail) if j >= i => innerRecursion(j + 1, tail, head +: sliced)
        case (_, _ +: tail)              => innerRecursion(j + 1, tail, sliced)
      }

    innerRecursion(0, list, Seq.empty[A])
  }
}
