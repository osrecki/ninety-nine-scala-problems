package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem17._

class Problem17Spec extends FlatSpec with Matchers {
  it should "split a list in two parts" in {
    val list = 1 to 10

    val split1 = (Nil, 1 to 10)
    splitBuiltIn(0, list) shouldBe split1
    splitFunctional(0, list) shouldBe split1
    splitRecursive(0, list) shouldBe split1

    val split2 = (1 to 3, 4 to 10)
    splitBuiltIn(3, list) shouldBe split2
    splitFunctional(3, list) shouldBe split2
    splitRecursive(3, list) shouldBe split2

    val split3 = (1 to 10, Nil)
    splitBuiltIn(10, list) shouldBe split3
    splitFunctional(10, list) shouldBe split3
    splitRecursive(10, list) shouldBe split3
  }
}
