package me.osrecki.prog.scala.ninety_nine.arithmetic

import scala.language.implicitConversions

import me.osrecki.prog.scala.ninety_nine.lists.Problem10.encode
import S99Int._

class S99Int(val number: Int) {
  /**
   * Determine whether a given integer number is prime.
   *
   *  ==Example==
   *  {{{
   *  scala> 7.isPrime
   *  res0: Boolean = true
   *  }}}
   */
  def isPrime: Boolean = {
    (number > 1) && primes.takeWhile(_ <= Math.sqrt(number)).forall(number % _ != 0)
  }

  /**
   * Determine whether two positive integer numbers are coprime.
   *  Two numbers are coprime if their greatest common divisor equals 1.
   *
   *  ==Example==
   *  {{{
   *  scala> 35.isCoprimeTo(64)
   *  res0: Boolean = true
   *  }}}
   */
  def isComprimeTo(other: Int): Boolean = gcd(number, other) == 1

  /**
   * Calculate Euler's totient function phi(m).
   *  Euler's so-called totient function phi(m) is defined as the number of
   *  positive integers r (1 <= r <= m) that are coprime to m.
   *
   *  ==Example==
   *  {{{
   *  scala> 10.totient
   *  res0: Int = 4
   *  }}}
   */
  def totient: Int = (1 to number).count(isComprimeTo)

  /**
   * Determine the prime factors of a given positive integer.
   *  Construct a flat list containing the prime factors in ascending order.
   *
   *  ==Example==
   *  {{{
   *  scala> 315.primeFactors
   *  res0: List[Int] = List(3, 3, 5, 7)
   *  }}}
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
   *  Construct a list containing the prime factors and their multiplicity.
   *
   *  ==Example==
   *  {{{
   *  scala> 315.primeFactorMultiplicity
   *  res0: Map[Int,Int] = Map(3 -> 2, 5 -> 1, 7 -> 1)
   *  }}}
   */
  def primeFactorsMultiplicity: Map[Int, Int] =
    encode(primeFactors).map(_.swap).toMap

  /**
   * Calculate Euler's totient function phi(m) (improved).
   *  See problem P34 for the definition of Euler's totient function. If the
   *  list of the prime factors of a number m is known in the form of problem
   *  P36 then the function phi(m>) can be efficiently calculated as follows:
   *  Let ([p1, m1], [p2, m2], [p3, m3], ...) be the list of prime factors
   *  (and their multiplicities) of a given number m. Then phi(m) can be
   *  calculated with the following formula:
   *
   *  phi(m) = (p1-1)*p1**(m1-1) * (p2-1)*p2**(m2-1) * (p3-1)*p3**(m3-1) * ...
   *
   *  Note that a**b stands for the b-th power of a.
   */
  def totientImproved: Int =
    primeFactorsMultiplicity.map { case (p, m) => (p - 1) * Math.pow(p, m - 1) }.product.toInt

  /**
   * Goldbach's conjecture says that every positive even number greater than 2
   *  is the sum of two prime numbers.  E.g. 28 = 5 + 23.  It is one of the
   *  most famous facts in number theory that has not been proved to be correct
   *  in the general case.  It has been numerically confirmed up to very large
   *  numbers (much larger than Scala's Int can represent).  Write a function
   *  to find the two prime numbers that sum up to a given even integer.
   *
   *  ==Example==
   *  {{{
   *  scala> 28.goldbach
   *  res0: (Int, Int) = (5,23)
   *  }}}
   */
  def goldbach: (Int, Int) = {
    primes.takeWhile(_ < number).find(p => (number - p).isPrime) match {
      case Some(p) => (p, number - p)
      case None    => throw new IllegalArgumentException
    }
  }
}

object S99Int {
  implicit def intToS99Int(i: Int): S99Int = new S99Int(i)

  val primes: Stream[Int] = 2 #:: Stream.from(3, 2).filter(_.isPrime)

  /**
   * Determine the greatest common divisor of two positive integer numbers.
   *  Use Euclid's algorithm.
   *
   *  ==Example==
   *  {{{
   *  scala> gcd(36, 63)
   *  res0: Int = 9
   *  }}}
   */
  def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)

  /**
   * A list of prime numbers.
   *  Given a range of integers by its lower and upper limit, construct a list
   *  of all prime numbers in that range.
   *
   *  ==Example==
   *  {{{
   *  scala> listPrimesInRange(7 to 31)
   *  res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)
   *  }}}
   */
  def listPrimesInRange(range: Range): Seq[Int] =
    primes.dropWhile(_ < range.start).takeWhile(_ <= range.end)

  /**
   * Given a range of integers by its lower and upper limit, print a list of
   *  all even numbers and their Goldbach composition.
   *
   *  ==Example==
   *  {{{
   *  scala> printGoldbachList(9 to 20)
   *  10 = 3 + 7
   *  12 = 5 + 7
   *  14 = 3 + 11
   *  16 = 3 + 13
   *  18 = 5 + 13
   *  20 = 3 + 17
   *  }}}
   */
  def printGoldbachList(range: Range): Unit = {
    printGoldbachListLimited(range, 0)
  }

  def printGoldbachListLimited(range: Range, threshold: Int): Unit = {
    range.filter(number => number > 2 && number % 2 == 0)
      .map(number => (number, number.goldbach))
      .filter(_._2._1 >= threshold)
      .foreach {
        case (number, (p1, p2)) => println(s"$number = $p1 + $p2")
      }
  }
}
