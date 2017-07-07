package me.osrecki.prog.scala.ninety_nine.logic

import scala.collection.immutable.Queue
import scala.collection.immutable.Seq

/**
 * Huffman code.
 *  We suppose a set of symbols with their frequencies, given as a list of (S, F)
 *  Tuples. E.g. (("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)).
 *  Our objective is to construct a list of (S, C) Tuples, where C is the Huffman
 *  code word for the symbol S.
 *
 *  ==Example==
 *  {{{
 *  scala> huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
 *  res0: List[String, String] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))
 *  }}}
 */
object Problem50 {
  private abstract sealed class Node[E] {
    val freq: Int
    def toCode: Seq[(E, String)] = toCodePrefixed("")
    def toCodePrefixed(prefix: String): Seq[(E, String)]
  }

  private final case class InternalNode[E](left: Node[E], right: Node[E]) extends Node[E] {
    val freq: Int = left.freq + right.freq

    def toCodePrefixed(prefix: String): Seq[(E, String)] = {
      left.toCodePrefixed(s"${prefix}0") ++: right.toCodePrefixed(s"${prefix}1")
    }
  }

  private final case class LeafNode[E](element: E, freq: Int) extends Node[E] {
    def toCodePrefixed(prefix: String): Seq[(E, String)] = Seq((element, prefix))
  }

  def huffman[E](seq: Seq[(E, Int)]): Seq[(E, String)] = {
    def dequeueLeastFrequent(q1: Queue[Node[E]], q2: Queue[Node[E]]) = {
      if (q1.isEmpty || q2.nonEmpty && q2.head.freq < q1.head.freq) (q2.head, q1, q2.dequeue._2)
      else (q1.head, q1.dequeue._2, q2)
    }

    def huffmanRecursive(q1: Queue[Node[E]], q2: Queue[Node[E]]): Seq[(E, String)] = {
      if (q1.size + q2.size == 1) {
        (if (q1.isEmpty) q2.head else q1.head).toCode
      } else {
        val (n1, q1_1, q2_1) = dequeueLeastFrequent(q1, q2)
        val (n2, q1_2, q2_2) = dequeueLeastFrequent(q1_1, q2_1)

        huffmanRecursive(q1_2, q2_2.enqueue(InternalNode(n1, n2)))
      }
    }

    val leafNodes = seq.sortWith(_._2 < _._2).map { case (element, freq) => LeafNode(element, freq) }
    huffmanRecursive(Queue.empty.enqueue(leafNodes), Queue.empty[Node[E]])
  }
}
