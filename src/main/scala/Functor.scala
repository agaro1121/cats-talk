



/*trait Functor[F[_]] {

  def map[A, B](fa: F[A])(f: A => B): F[B]

}

object Functor {

  implicit class FunctorOps[F[_], A](val fa: F[A]) extends AnyVal {
    def map[B](f: A => B)(implicit F: Functor[F]): F[B] = F.map(fa)(f)
  }


}*/
