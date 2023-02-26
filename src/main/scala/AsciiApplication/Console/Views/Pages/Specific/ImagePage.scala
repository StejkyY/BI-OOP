package AsciiApplication.Console.Views.Pages.Specific

import AsciiApplication.Console.Views.Pages.TextPage
import Converters.DataType.Specific.AsciiImageToString
import Models.Image

class ImagePage ( img: Image[Char]) extends TextPage{

  /**
   * Renders the ASCII Image in a text page
   */
  override def render(): String = {
    val toStringConverter : AsciiImageToString = new AsciiImageToString
    toStringConverter.convert( img )
  }
}
