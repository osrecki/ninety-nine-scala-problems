package me.osrecki.prog.scala.ninety_nine.arithmetic

class S99Int(val number: Int) {
  import S99Int._

  /**
    * Determine whether a given integer number is prime.
    * ==Example==
    * {{{
    * scala> 7.isPrime
    * res0: Boolean = true
    * }}}
    */
  def isPrime: Boolean = {
    (number > 1) && primes.takeWhile(_ <= Math.sqrt(number)).forall(number % _ != 0)
  }
}

object S99Int {
  implicit def intToS99Int(i: Int): S99Int = new S99Int(i)

  private val primes = 2 #:: Stream.from(3, 2).filter(_.isPrime)

  /**
    * Determine the greatest common divisor of two positive integer numbers.
    * Use Euclid's algorithm.
    * {{{
    * scala> gcd(36, 63)
    * res0: Int = 9
    * }}}
    */
  def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
}
