package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{ FlatSpec, Matchers }
import Problem3._

class Problem3Spec extends FlatSpec with Matchers {
  val list = List(10, 4, 88, -12, 55)

  it should "return the first element of a non-empty list" in {
    nthBuiltIn(0, list) shouldBe 10
    nthRecursive(0, list) shouldBe 10
  }

  it should "return the last element of a non-empty list" in {
    nthBuiltIn(4, list) shouldBe 55
    nthRecursive(4, list) shouldBe 55
  }

  it should "return the 3rd (zero-indexed) element of a list with at least 4 elements" in {
    nthBuiltIn(3, list) shouldBe -12
    nthRecursive(3, list) shouldBe -12
  }

  it should "throw an IndexOutOfBoundsException for a K less than zero" in {

    an[IndexOutOfBoundsException] should be thrownBy nthBuiltIn(-1, list)
    an[IndexOutOfBoundsException] should be thrownBy nthRecursive(-1, list)
  }

  it should "throw an IndexOutOfBoundsException for a K (zero-indexed) greater than list size" in {
    an[IndexOutOfBoundsException] should be thrownBy nthBuiltIn(5, list)
    an[IndexOutOfBoundsException] should be thrownBy nthRecursive(5, list)
  }
}
