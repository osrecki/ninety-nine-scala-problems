package me.osrecki.prog.scala.ninety_nine.lists

/**
 * ==Problem==
 * Generate the combinations of K distinct objects chosen from the N elements
 * of a list.
 *
 * ==Example==
 * {{{
 * scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
 * res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...
 * }}}
 */
object Problem26 {
  def sublists[A](list: Seq[A]): Seq[Seq[A]] = list match {
    case _ +: tail => list +: sublists(tail)
    case _         => Seq.empty[Seq[A]]
  }

  def combinations[A](k: Int, list: Seq[A]): Seq[Seq[A]] = {
    if (k == 0) Seq(Seq.empty[A])
    else {
      sublists(list).flatMap { sublist =>
        combinations(k - 1, sublist.tail).map(sublist.head +: _)
      }
    }
  }

  /**
   * Generates all combinations of k elements within the list of size
   * n in form of indices of the list in increasing order.
   *
   * ==Idea==
   * Idea is to have a vector of size k keeping indices of elements in
   * increasing order. First sequence is [n - k - 1, ..., n - 2, n - 1].
   * The last sequence is [0, 1, ..., k - 1].
   *
   * In each iteration algorithm looks for the closest element to the
   * start of the vector that can be decremented (i.e. greater than its
   * index in the vector). This item is decremented and all the items
   * from this element towards the beginning of the vector are filled
   * with the values in decreasing order.
   *
   * ==Example==
   * k = 3, n = 5
   * [2, 3, 4] -> [1, 3, 4] -> [0, 3, 4] -> (0 done, decrement 3 and refill to the left)
   * [1, 2, 4] -> [0, 2, 4] -> (0 done, decrement 2 and refill)
   * [0, 1, 4] -> (0 done, 1 done, decrement 4 and refill)
   * [1, 2, 3] -> [0, 2, 3] -> (0 done, decrement 2 and refill)
   * [0, 1, 3] -> (0 done, 1 done, decrement 3 and refill)
   * [0, 1, 2] -> (0 done, 1, done, 2 done, end)
   */
  def combinationsOfIndices(k: Int, n: Int): Seq[Vector[Int]] = {
    def indicesRec(current: Vector[Int], combinations: Seq[Vector[Int]]): Seq[Vector[Int]] = {
      val index = current.zipWithIndex.find { case (elem, i) => elem > i }.map(_._2)

      index match {
        case None => combinations
        case Some(i) =>
          val (left, right) = current.splitAt(i + 1)

          val newLeft = Vector.range(current(i) - left.size, current(i))
          val newCurrent = newLeft ++ right

          indicesRec(newCurrent, newCurrent +: combinations)
      }
    }

    val current = Vector.range(n - k, n)
    indicesRec(current, Seq(current))
  }

  def combinations2[A](k: Int, list: Seq[A]): Seq[Seq[A]] = {
    if (k > list.size) {
      Seq.empty[Seq[A]]
    } else {
      val vector = list.to[Vector]
      combinationsOfIndices(k, list.size).map { indices => indices.map(i => vector(i)) }
    }
  }
}
