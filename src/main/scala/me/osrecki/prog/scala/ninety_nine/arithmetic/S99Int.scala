package me.osrecki.prog.scala.ninety_nine.arithmetic

import me.osrecki.prog.scala.ninety_nine.lists.Problem10.encode

class S99Int(val number: Int) {
  import S99Int._

  /**
    * Determine whether a given integer number is prime.
    *
    * ==Example==
    * {{{
    * scala> 7.isPrime
    * res0: Boolean = true
    * }}}
    */
  def isPrime: Boolean = {
    (number > 1) && primes.takeWhile(_ <= Math.sqrt(number)).forall(number % _ != 0)
  }

  /**
    * Determine whether two positive integer numbers are coprime.
    * Two numbers are coprime if their greatest common divisor equals 1.
    *
    * ==Example==
    * {{{
    * scala> 35.isCoprimeTo(64)
    * res0: Boolean = true
    * }}}
    */
  def isComprimeTo(other: Int): Boolean = gcd(number, other) == 1

  /**
    * Calculate Euler's totient function phi(m).
    * Euler's so-called totient function phi(m) is defined as the number of
    * positive integers r (1 <= r <= m) that are coprime to m.
    *
    * ==Example==
    * {{{
    * scala> 10.totient
    * res0: Int = 4
    * }}}
    */
  def totient: Int = (1 to number).count(number isComprimeTo _)

  /**
    * Determine the prime factors of a given positive integer.
    * Construct a flat list containing the prime factors in ascending order.
    *
    * ==Example==
    * {{{
    * scala> 315.primeFactors
    * res0: List[Int] = List(3, 3, 5, 7)
    * }}}
    */
  def primeFactors: Seq[Int] = {
    def primeFactorsRec(n: Int, candidates: Seq[Int]): Seq[Int] = {
      if (n < 2) Seq.empty[Int]
      else if (n.isPrime) Seq(n)
      else if (n % candidates.head == 0) candidates.head +: primeFactorsRec(n / candidates.head, candidates)
      else primeFactorsRec(n, candidates.tail)
    }

    primeFactorsRec(number, primes)
  }

  /**
    * Determine the prime factors of a given positive integer (2).
    * Construct a list containing the prime factors and their multiplicity.
    *
    * ==Example==
    * {{{
    * scala> 315.primeFactorMultiplicity
    * res0: Map[Int,Int] = Map(3 -> 2, 5 -> 1, 7 -> 1)
    * }}}
    */
  def primeFactorsMultiplicity: Map[Int, Int] =
    encode(number.primeFactors).map(_.swap).toMap
}

object S99Int {
  implicit def intToS99Int(i: Int): S99Int = new S99Int(i)

  private val primes = 2 #:: Stream.from(3, 2).filter(_.isPrime)

  /**
    * Determine the greatest common divisor of two positive integer numbers.
    * Use Euclid's algorithm.
    *
    * ==Example==
    * {{{
    * scala> gcd(36, 63)
    * res0: Int = 9
    * }}}
    */
  def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)

  /**
    * A list of prime numbers.
    * Given a range of integers by its lower and upper limit, construct a list
    * of all prime numbers in that range.
    *
    * ==Example==
    * {{{
    * scala> listPrimesInRange(7 to 31)
    * res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)
    * }}}
    */
  def listPrimesInRange(range: Range): Seq[Int] =
    primes.dropWhile(_ < range.start).takeWhile(_ <= range.end)
}
