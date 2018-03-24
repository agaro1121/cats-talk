import scala.concurrent.Future

object CatsExperiment extends App {


  import cats._
  import cats.implicits._
  import cats.data._

  println(Show[Int].show(5))

  println(5.show)
  println(Show[String].show("abc"))
  println("abc".show)


  import concurrent.ExecutionContext.Implicits.global
  Functor[Future]

  val map = Map(
    "1" -> 0,
    "2" -> 1,
    "4" -> 4
  )

  val map2 = Map(
    "1" -> 1,
    "2" -> 1,
    "3" -> 3
  )

  println(Semigroup[Map[String, Int]].combine(map, map2))


  import Tree._
  val l1 = leaf(1)
  val o1 = Option(2)

  val ek: EitherK[Tree, Option, Int] = EitherK.rightc(o1)
  val ek2: EitherK[Tree, Option, Int] = EitherK.leftc(l1)

  println(ek.map(_ + 10))
  println(ek2.map(_ + 10))

  /////////
  val s2i: String => Option[Int] = n => Option(n.toInt)
  val i2d: Int => Option[Double] = i => Option(i.toDouble)


  println(Kleisli(s2i).andThen(i2d).apply("5"))

  println(OptionT(List(Option(1))).map(_ + 10).value)

  /////////
  val id: Id[Int] = 5
  val id2: Id[Int] = 1
  val c = for {
    ov <- id
    i <- id2
  } yield ov + i

  println(c)

  val ekk: EitherK[Tree, Id, Int] = EitherK.rightc(id)
  println(ekk)

}
