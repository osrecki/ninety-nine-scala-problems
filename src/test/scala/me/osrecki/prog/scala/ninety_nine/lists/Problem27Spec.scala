package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{ FlatSpec, Matchers }
import Problem27._

class Problem27Spec extends FlatSpec with Matchers {
  val list = List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")

  it should "group the elements of a set into three disjoint subsets of sizes 2, 3 and 4." in {
    val groupsCount = fact(list.size) / (fact(2) * fact(3) * fact(4))

    group3(list) should have size groupsCount
  }

  it should "group the elements of a set into disjoint subsets" in {
    val groupsCount = fact(list.size) / (fact(2) * fact(2) * fact(5))

    group(List(2, 2, 5), list) should have size groupsCount
  }

  private def fact(i: Int) = (2 to i).product
}
