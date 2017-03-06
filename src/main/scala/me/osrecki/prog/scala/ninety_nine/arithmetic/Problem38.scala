package me.osrecki.prog.scala.ninety_nine.arithmetic

import S99Int._

/**
  * Compare the two methods of calculating Euler's totient function.
  * Use the solutions of problems P34 and P37 to compare the algorithms. Try to
  * calculate phi(10090) as an example.
  */
object Problem38 {
  val iterationsCount = 100

  def time[R](label: String)(block: => R): R = {
    val start = System.nanoTime()
    val result = block
    val end = System.nanoTime()

    println(s"$label: ${end - start} ns.")
    result
  }

  def test(number: Int): Unit = {
    time("Preload prime numbers") {
      primes.takeWhile(_ < Math.sqrt(number)).force
    }

    time("totient(number)") {
      number.totient
    }

    time("totientImproved(number)") {
      number.totientImproved
    }
  }

  def main(args: Array[String]): Unit = {
    test(10090)
  }
}
