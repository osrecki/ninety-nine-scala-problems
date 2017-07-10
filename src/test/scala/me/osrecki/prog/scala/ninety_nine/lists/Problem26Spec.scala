package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FunSpec, Matchers}
import Problem26._

class Problem26Spec extends FunSpec with Matchers {
  val list = Seq('a, 'b, 'c, 'd, 'e)
  val combinationsOfThree = Seq(
    Seq('c, 'd, 'e), Seq('b, 'd, 'e), Seq('a, 'd, 'e), Seq('b, 'c, 'e), Seq('a, 'c, 'e),
    Seq('a, 'b, 'e), Seq('b, 'c, 'd), Seq('a, 'c, 'd), Seq('a, 'b, 'd), Seq('a, 'b, 'c)
  )

  describe("combinations") {
    it("should generate empty list if k greater than list size") {
      combinations(7, list) shouldBe empty
    }

    it("should generate combinations of one element") {
      combinations(1, list) shouldBe list.map(Seq(_))
    }

    it("should generate the combinations of k distinct elements") {
      val combs = combinations(3, list)

      combs should have size 10
      combs should contain theSameElementsAs combinationsOfThree
    }
  }

  describe("combinations2") {
    it("should generate empty list if k greater than list size") {
      combinations2(7, list) shouldBe empty
    }

    it("should generate combinations of one element") {
      combinations2(1, list) shouldBe list.map(Seq(_))
    }

    it("should generate the combinations of k distinct elements") {
      val combs = combinations2(3, list)

      combs should have size 10
      combs should contain theSameElementsAs combinationsOfThree
    }
  }
}
