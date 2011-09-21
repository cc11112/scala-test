package hellotest

abstract class Nat

case object Zero extends Nat

case class Succ(n: Nat) extends Nat {
  def toInt(n: Nat): Int = n match {
    case Zero => 0
    case Succ(m) => 1 + toInt(m)

    case _ => error("can not convert to integer")
  }

  def plus(n: Nat)(m: Nat): Nat = n match {
    case Zero => m
    case Succ(k: Nat) => plus(k)(Succ(m))
  }
}


//change code here
object Main {
  val a = new Succ(Zero);
  val b = new Succ(a);

  //how to wrtie test case
  
  def main(args: Array[String]) = println(a.toInt(b.plus(a)(b)))
}
