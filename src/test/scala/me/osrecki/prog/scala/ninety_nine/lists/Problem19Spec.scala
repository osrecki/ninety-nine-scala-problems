package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{ FlatSpec, Matchers }
import Problem19._

class Problem19Spec extends FlatSpec with Matchers {
  val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

  it should "rotate a list three spaces counterclockwise" in {
    val rotated = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

    rotate(3, list) shouldBe rotated
  }

  it should "rotate a list two spaces clockwise" in {
    val rotated = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)

    rotate(-2, list) shouldBe rotated
  }
}
