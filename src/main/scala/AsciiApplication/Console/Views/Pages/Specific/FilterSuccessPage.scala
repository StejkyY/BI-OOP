package AsciiApplication.Console.Views.Pages.Specific

import AsciiApplication.Console.Views.Pages.TextPage

object FilterSuccessPage extends TextPage{
  /**
   * Renders text page that implies successful application of a filter on image
   */
  override def render(): String = "Successfully Applied Filter.\n"
}
