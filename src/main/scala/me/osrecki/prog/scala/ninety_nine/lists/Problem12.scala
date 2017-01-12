package me.osrecki.prog.scala.ninety_nine.lists

/**
  * Decode a run-length encoded list.
  * Given a run-length code list generated as specified in problem P10, construct
  * its uncompressed version.
  *
  * ==Example==
  * {{{
  * scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  * res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  * }}}
  */
object Problem12 {
  def decode[A](list: Seq[(Int, A)]): Seq[A] =
    list.flatMap { case(size, elem) => List.fill(size)(elem) }
}
