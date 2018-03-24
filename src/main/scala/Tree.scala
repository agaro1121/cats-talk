import cats.Functor


trait Tree[+T]
case class Leaf[T](a: T) extends Tree[T]
case class Branch[T](l: Tree[T], r: Tree[T]) extends Tree[T]

object Tree {

  implicit val TreeFunctor: Functor[Tree] = new Functor[Tree] {
    override def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = fa match {
      case Leaf(a) => Leaf(f(a))
      case Branch(l, r) => Branch(map(l)(f), map(r)(f))
    }
  }

  /**
    * Smart Constructors
    * */
  def leaf[A](a: A): Tree[A] = Leaf(a)
  def branch[A](l: Tree[A], r: Tree[A]): Tree[A] = Branch(l, r)

}