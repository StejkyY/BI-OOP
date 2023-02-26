package AsciiApplication.Console.Views.Pages.Specific

import AsciiApplication.Console.Views.Pages.TextPage

object GeneratingSuccessPage extends TextPage{
  /**
   * Renders text page that implies successful generating of an image
   */
  override def render(): String = "Successfully Generated Image.\n"
}
