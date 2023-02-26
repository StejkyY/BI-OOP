package AsciiApplication.Console.Views.Pages

trait Page[T] {
  /**
   * Renders a page in a datatype T
   */
  def render(): T
}
