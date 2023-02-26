package Converters.DataType.Specific

import Converters.DataType.DataTypeConverter

class AsciiToAsciiInverted extends DataTypeConverter [Char, Char] {
  /**
   * Converts Char (ASCII) to a Char (ASCII)
   * @param item Char to be converted
   */
  override def convert(item: Char): Char = {
    val ramp = """$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/|()1{}[]?-_+~<>i!lI;:,"^`\'. """
    //gets the greyscale of the char
    val greyscale = (ramp.indexOf(item) * 255)/(ramp.length - 1)
    //return character from the ramp, this time with the inverted greyscale
    ramp((ramp.length() - 1) * (255 - greyscale) / 255)
  }
}
