package Converters.DataType.Specific

import Converters.DataType.DataTypeConverter
import Models.Pixel

class PixelToAscii extends DataTypeConverter [Pixel, Char] {

  /**
   * Converts Pixel to a Char (ASCII)
   * @param item Pixel to be converted
   */
  override def convert(item: Pixel): Char = {
    //checking if the pixel is okay
    if ( item.r < 0 || item.r > 255 || item.b < 0 || item.b > 255 || item.g < 0 || item.g > 255 ) throw new  Exception ( "Pixel error" )
    //get the greyscale
    val greyscale = (0.3 * item.r) + (0.59 * item.g) + (0.11 * item.b)
    val ramp = """$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/|()1{}[]?-_+~<>i!lI;:,"^`\'. """
    //get the corresponding character from ramp
    val asciiChar : Char = ramp(((ramp.length() - 1) * greyscale / 255).toInt)
    asciiChar
  }
}
