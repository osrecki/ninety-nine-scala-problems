package me.osrecki.prog.scala.ninety_nine.lists

import scala.reflect.ClassTag

import Problem23.randomSelect

/**
 * Generate a random permutation of the elements of a list.
 *
 *  ==Example==
 *  {{{
 *  scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
 *  res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
 *  }}}
 */
object Problem25 {
  def randomPermute[A](list: Seq[A], seed: Long): Seq[A] = randomSelect(list.size, list, seed)

  def randomPermuteArray[A: ClassTag](list: Seq[A], seed: Long): Seq[A] = {
    val random = new util.Random(seed)
    val array = list.toArray
    for (i <- array.length - 1 to 1 by -1) {
      val index = random.nextInt(i + 1)

      val elem = array(index)
      array(index) = array(i)
      array(i) = elem
    }

    array.toList
  }
}
