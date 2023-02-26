package AsciiApplication.Console.Views.Pages.Specific

import AsciiApplication.Console.Views.Pages.TextPage

class MainPage extends TextPage{
  /**
   * Renders the main (welcome) text page that the user sees as first
   */
  override def render(): String = {
    var result = ""

    result += "-----ASCII ART-----\n"
    result += "Welcome! If you're unsure about what to type in, rerun the application just with --help\n"

    result
  }
}
