


import Tree.{branch, leaf}

import cats.Functor
import cats.syntax.functor._

/**
  * - Create Functor
  * - Create functor instance
  * - Use TreeFunctor manually
  * - Create function that requires Functor[Tree]
  * - Make Functor[Tree] implicit to bring in whatever TreeFunctor we want
  * - Make TreeFunctor implicit to get rid of imports
  * - make Functor generic over F
  * - Create FunctorOps to reduce boilerplate
  * - Replace home-made functor with Cats
  * - Show Cats FunctorOps
  * - Introduce cats && cats.syntax package
  * - 
  *
  * */

object FunctorTest extends App {

  val tree = branch(
    branch(
      leaf(1), leaf(2)),
    leaf(3)
  )

  /*
    val mappedTree = Tree.TreeFunctor.map(tree)(_.toBinaryString)

    println(mappedTree)

    def toStringThing[A](fa: Tree[A])(implicit F : Functor[Tree]) = {
      F.map(fa)(n => s"toStringOf($n)")
      // fa.map(n => s"toStringOf($n)")
    }

    def toStringThingGeneric[F[_], A](fa: F[A])(implicit F : Functor[F]) = {
      F.map(fa)(n => s"toStringGOf($n)")
    }

    println(toStringThing(tree))
    println(toStringThingGeneric(tree))
    println(tree.map(n => s"toStringGOf($n)"))
  */


  def toStringThingGeneric2[F[_] : Functor, A](fa: F[A]) = {
    fa.map(n => s"toStringGOf($n)")
  }

  println(toStringThingGeneric2(tree))



}
