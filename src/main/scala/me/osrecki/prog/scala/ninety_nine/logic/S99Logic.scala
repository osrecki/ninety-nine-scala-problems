package me.osrecki.prog.scala.ninety_nine.logic

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
