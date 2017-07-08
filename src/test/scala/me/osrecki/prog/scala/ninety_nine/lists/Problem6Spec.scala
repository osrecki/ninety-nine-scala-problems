package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem6._

class Problem6Spec extends FlatSpec with Matchers {
  it should "return true for List(1, 2, 3, 2, 1)" in {
    val list = List(1, 2, 3, 2, 1)

    isPalindrome(list) shouldBe true
    isPalindromeRecursive(list) shouldBe true
  }

  it should "return true for List(1, 2, 1)" in {
    val list = List(1, 2, 1)

    isPalindrome(list) shouldBe true
    isPalindromeRecursive(list) shouldBe true
  }

  it should "return true for List(1, 1)" in {
    val list = List(1, 1)

    isPalindrome(list) shouldBe true
    isPalindromeRecursive(list) shouldBe true
  }

  it should "return true for a singleton list" in {
    val singleton = List(1)

    isPalindrome(singleton) shouldBe true
    isPalindromeRecursive(singleton) shouldBe true
  }

  it should "return true for an empty list" in {
    isPalindrome(Nil) shouldBe true
    isPalindromeRecursive(Nil) shouldBe true
  }

  it should "return false for List(1, 2)" in {
    val list = 1 to 2

    isPalindrome(list) shouldBe false
    isPalindromeRecursive(list) shouldBe false
  }

  it should "return false for List(1, 1, 2)" in {
    val list = Seq(1, 1, 2)

    isPalindrome(list) shouldBe false
    isPalindromeRecursive(list) shouldBe false
  }

  it should "return false for List(1, 2, 3, 4, 5)" in {
    val list = 1 to 5

    isPalindrome(list) shouldBe false
    isPalindromeRecursive(list) shouldBe false
  }
}
