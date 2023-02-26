package AsciiApplication.Console.Views.Pages.Specific

import AsciiApplication.Console.Views.Pages.TextPage

object ConversionSuccessPage extends TextPage{
  /**
   * Renders text page that implies successful conversion of an image
   */
  override def render(): String = "Successfully Converted Image.\n"
}
