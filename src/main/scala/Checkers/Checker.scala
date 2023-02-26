package Checkers

trait Checker [T] {
  /**
   * Checks and corrects item if needed
   * @param item Item to be checked
   */
  def check ( item: T): T
}
