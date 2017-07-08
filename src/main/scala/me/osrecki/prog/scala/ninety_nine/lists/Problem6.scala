package me.osrecki.prog.scala.ninety_nine.lists

import scala.annotation.tailrec

/**
 * ==Problem==
 * Find out whether a list is a palindrome.
 *
 * ==Example==
 * {{{
 * scala> isPalindrome(List(1, 2, 3, 2, 1))
 * res0: Boolean = true
 * }}}
 */
object Problem6 {
  def isPalindrome[A](list: Seq[A]): Boolean = list == list.reverse

  @tailrec
  def isPalindromeRecursive[A](list: Seq[A]): Boolean = list match {
    case head +: middle :+ last => head == last && isPalindromeRecursive(middle)
    case _                      => true
  }
}
