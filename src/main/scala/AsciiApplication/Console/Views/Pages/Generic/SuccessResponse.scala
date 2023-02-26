package AsciiApplication.Console.Views.Pages.Generic

import AsciiApplication.Console.Views.Pages.TextPage

object SuccessResponse extends TextPage{
  /**
   * Renders text page that implies success
   */
  override def render(): String = "Success\n"
}
