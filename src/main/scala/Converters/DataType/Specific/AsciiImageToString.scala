package Converters.DataType.Specific

import Converters.DataType.DataTypeConverter
import Models.{Image, Pixel}

class AsciiImageToString extends DataTypeConverter [Image[Char], String]{
  /**
   * Converts ASCII image to string
   * @param item Image to convert
   */
  override def convert(item: Image[Char]): String = {
    if ( item.getGrid().getHeight() == 0 || item.getGrid().getWidth() == 0 ) throw new Exception ( "Image size error")
    var result = ""
    var i = item.getGrid().getHeight() - 1
    var l = 0

    //puts each char of the image into a one big string
    while ( i >= 0 ) {
      var line = ""
      while ( l < item.getGrid().getWidth() ) {
        line += item.getGrid().getPoint( l, i )
        l = l + 1
      }
      line += "\n"
      result += line
      i = i - 1
      l = 0
    }
    result
  }
}
