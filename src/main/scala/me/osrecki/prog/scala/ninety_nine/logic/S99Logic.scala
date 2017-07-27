package me.osrecki.prog.scala.ninety_nine.logic

/**
 * ==Problem==
 * Define functions and, or, nand, nor, xor, impl, and equ (for logical equivalence)
 * which return true or false according to the result of their respective operations;
 * e.g. and(A, B) is true if and only if both A and B are true.
 *
 * ==Example==
 * {{{
 * scala> and(true, true)
 * res0: Boolean = true
 * scala> xor(true. true)
 * res1: Boolean = false
 * }}}
 *
 * A logical expression in two variables can then be written as an function of two variables,
 * e.g: (a: Boolean, b: Boolean) => and(or(a, b), nand(a, b))
 *
 * Now, write a function called table2 which prints the truth table of a given logical expression
 * in two variables.
 *
 * ==Example==
 * {{{
 * scala> table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
 * A     B     result
 * true  true  true
 * true  false true
 * false true  false
 * false false false
 * }}}
 */
object S99Logic {
  def not(p: Boolean): Boolean = p match {
    case true => false
    case _    => true
  }

  def and(p: Boolean, q: Boolean): Boolean = (p, q) match {
    case (true, true) => true
    case _            => false
  }

  def or(p: Boolean, q: Boolean): Boolean = (p, q) match {
    case (false, false) => false
    case _              => true
  }

  def nand(p: Boolean, q: Boolean): Boolean = not(and(p, q))

  def nor(p: Boolean, q: Boolean): Boolean = not(or(p, q))

  def equ(p: Boolean, q: Boolean): Boolean = or(and(p, q), and(not(p), not(q)))

  def xor(p: Boolean, q: Boolean): Boolean = not(equ(p, q))

  def impl(p: Boolean, q: Boolean): Boolean = or(not(p), q)

  def table2(f: (Boolean, Boolean) => Boolean): Unit = {
    println("P     Q     Result")

    for {
      p <- List(true, false)
      q <- List(true, false)
    } {
      printf("%-5s %-5s %-5s\n", p, q, f(p, q))
    }
  }
}
