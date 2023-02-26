package Converters

import Converters.DataType.Specific.AsciiToAsciiInverted
import org.scalatest.FunSuite

class AsciiToAsciiInvertedTests extends FunSuite {
    test ( "convert"){
      val converter = new AsciiToAsciiInverted
      val a = '*'
      val b = '$'

      //comparing to inverted characters according to the used map
      assert ( converter.convert(a) == ';')
      assert ( converter.convert(b) == ' ')
    }
}
