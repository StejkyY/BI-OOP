package AsciiApplication.Console.Views.Pages.Specific

import AsciiApplication.Console.Views.Pages.TextPage

object LoadSuccessPage extends TextPage{
  /**
   * Renders text page that implies successful loading of an image
   */
  override def render(): String = "Successfully Loaded Image.\n"
}
