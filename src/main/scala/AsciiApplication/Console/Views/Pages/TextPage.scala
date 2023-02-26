package AsciiApplication.Console.Views.Pages

trait TextPage extends Page[String] {
  /**
   * Renders a text page in string
   */
  def render(): String
}
