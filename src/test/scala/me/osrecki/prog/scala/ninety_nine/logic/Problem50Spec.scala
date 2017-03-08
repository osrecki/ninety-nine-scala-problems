package me.osrecki.prog.scala.ninety_nine.logic

import org.scalatest.{FlatSpec, Matchers}
import scala.collection.immutable.Seq
import Problem50.huffman

class Problem50Spec extends FlatSpec with Matchers {
  it should "create Huffman codes for a sequence of symbols and their frequencies" in {
    val seq = Seq(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))
    val codes = Seq(("a", "0"), ("b", "101"), ("c", "100"), ("d", "111"), ("e", "1101"), ("f", "1100"))

    huffman(seq) should contain theSameElementsAs codes
  }
}
