package Converters

import Converters.DataType.Specific.{AsciiImageToString, PixelToAscii}
import Models.{Image, Pixel, PointGrid}
import org.scalatest.FunSuite

class PixelToAsciiTests extends FunSuite{
    test ("convert"){
      val converter = new PixelToAscii
      val pixA = Pixel ( 1, 2, 3 )
      val pixB = Pixel ( 58, 67, 45)

      //these are the corresponding characters to the pixels
      assert ( converter.convert(pixA) == '$')
      assert ( converter.convert(pixB) == 'p')
    }
    test ("convert with wrong pixel"){
      val converter = new PixelToAscii
      val pix = Pixel ( -1, 2, 3 )

      try {
        converter.convert( pix )
        assert ( false )
      } catch {
        case e: Exception =>
      }
    }
}
