package me.osrecki.prog.scala.ninety_nine.logic

class S99Boolean(val p: Boolean) {
  import S99Boolean._

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

  def not(p: Boolean): Boolean = if(p) false else true
}
