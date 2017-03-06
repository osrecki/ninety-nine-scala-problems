package me.osrecki.prog.scala.ninety_nine

object TestUtility {
  def printlnToString(block: => Unit): String = {
    val stream = new java.io.ByteArrayOutputStream()
    Console.withOut(stream) { block }
    stream.toString
  }
}
