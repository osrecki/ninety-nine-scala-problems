package me.osrecki.prog.scala.ninety_nine.logic

import scala.language.implicitConversions

import S99Boolean._

/**
 * ==Problem==
 * Continue problem P46 by redefining and, or, etc as operators (i.e. make them
 * methods of a new class with an implicit conversion from Boolean). not will
 * have to be left as an object method.
 *
 * ==Example==
 * {{{
 * scala> table2((a: Boolean, b: Boolean) => a and (a or not(b)))
 * A     B     result
 * true  true  true
 * true  false true
 * false true  false
 * false false false
 * }}}
 */
class S99Boolean(val p: Boolean) {
  def and(q: Boolean): Boolean = (p, q) match {
    case (true, true) => true
    case _            => false
  }

  def or(q: Boolean): Boolean = (p, q) match {
    case (false, false) => false
    case _              => true
  }

  def nand(q: Boolean): Boolean = not(p and q)
  def nor(q: Boolean): Boolean = not(p or q)
  def equ(q: Boolean): Boolean = (p and q) or (not(p) and not(q))
  def xor(q: Boolean): Boolean = not(p equ q)
  def impl(q: Boolean): Boolean = not(p) or q
}

object S99Boolean {
  implicit def booleanToS99Boolean(b: Boolean): S99Boolean = new S99Boolean(b)

  def not(p: Boolean): Boolean = if (p) false else true

  /**
   * ==Problem==
   * An n-bit Gray code is a sequence of n-bit strings constructed according
   * to certain rules. Find out the construction rules and write a function
   * to generate Gray codes.
   *
   * ==Example==
   * {{{
   * scala> gray(3)
   * res0 List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)
   * }}}
   */
  def gray(n: Int): Seq[String] =
    if (n == 0) Seq("")
    else {
      val lower = gray(n - 1)
      lower.map("0" + _) ++: lower.reverse.map("1" + _)
    }

  /**
   * ==Problem==
   * See if you can use memoization to make the function more efficient.
   */
  private val grayCodes = collection.mutable.Map(0 -> Seq(""))
  def grayMemoization(n: Int): Seq[String] = {
    if (!grayCodes.contains(n)) {
      val lower = grayMemoization(n - 1)
      grayCodes(n) = lower.map("0" + _) ++: lower.reverse.map("1" + _)
    }

    grayCodes(n)
  }
}
