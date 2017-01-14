package me.osrecki.prog.scala.ninety_nine.lists

/**
  * Group the elements of a set into disjoint subsets.
  *
  * a) In how many ways can a group of 9 people work in 3 disjoint subgroups of
  *    2, 3 and 4 persons? Write a function that generates all the possibilities.
  *
  * ==Example==
  * {{{
  * scala> group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
  * res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi),
  *                                       List(Flip, Gary, Hugo, Ida)), ...
  * }}}
  *
  * b) Generalize the above predicate in a way that we can specify a list of
  *    group sizes and the predicate will return a list of groups.
  *
  * ==Example==
  * {{{
  * scala> group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi",
  *                                  "Flip", "Gary", "Hugo", "Ida"))
  * res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David),
  *                                       List(Evi, Flip, Gary, Hugo, Ida)), ...
  * }}}
  *
  * Note that we do not want permutations of the group members; i.e. ((Aldo, Beat), ...)
  * is the same solution as ((Beat, Aldo), ...). However, we make a difference between
  * ((Aldo, Beat), (Carla, David), ...) and ((Carla, David), (Aldo, Beat), ...).
  */
object Problem27 {
  import Problem26.combinations

  def group3[A](list: Seq[A]): Seq[Seq[Seq[A]]] =
    for {
      two     <- combinations(2, list)
      noTwo   = list.diff(two)
      three   <- combinations(3, noTwo)
      noThree = noTwo.diff(three)
      four    = noTwo.diff(noThree)
    } yield List(two, three, four)

  def group[A](sizes: Seq[Int], list: Seq[A]): Seq[Seq[Seq[A]]] =
    sizes match {
      case size +: tail => combinations(size, list).flatMap { combination =>
        group(tail, list.diff(combination)).map(combination +: _)
      }
      case _            => Seq(Seq(Seq.empty[A]))
    }
}
