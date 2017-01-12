package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem18._

class Problem18Spec extends FlatSpec with Matchers {
  val list    = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

  it should "extract an empty slice from a list" in {
    sliceBuiltIn(3, 3, list)    shouldBe Nil
    sliceFunctional(3, 3, list) shouldBe Nil
    sliceRecursive(3, 3, list)  shouldBe Nil
  }

  it should "extract a one-element slice from a list" in {
    val sliced = List('d)

    sliceBuiltIn(3, 4, list)    shouldBe sliced
    sliceFunctional(3, 4, list) shouldBe sliced
    sliceRecursive(3, 4, list)  shouldBe sliced
  }

  it should "extract a slice from 3 until 7 from a list" in {
    val sliced = List('d, 'e, 'f, 'g)

    sliceBuiltIn(3, 7, list)    shouldBe sliced
    sliceFunctional(3, 7, list) shouldBe sliced
    sliceRecursive(3, 7, list)  shouldBe sliced
  }

  it should "extract a whole list" in {
    sliceBuiltIn(-2, 100, list)    shouldBe list
    sliceFunctional(-2, 100, list) shouldBe list
    sliceRecursive(-2, 100, list)  shouldBe list
  }

  it should "work with a negative start index" in {
    val sliced = List('a, 'b, 'c)

    sliceBuiltIn(-10, 3, list)    shouldBe sliced
    sliceFunctional(-10, 3, list) shouldBe sliced
    sliceRecursive(-10, 3, list)  shouldBe sliced
  }

  it should "work with an arbitrarily large end index" in {
    val sliced = List('h, 'i, 'j, 'k)

    sliceBuiltIn(7, 100, list)    shouldBe sliced
    sliceFunctional(7, 100, list) shouldBe sliced
    sliceRecursive(7, 100, list)  shouldBe sliced
  }
}
