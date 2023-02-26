package Converters

import Converters.DataType.Specific.AsciiImageToString
import Models.{Image, PointGrid}
import org.scalatest.FunSuite

class AsciiImageToStringTests extends FunSuite {
    test ( "convert"){
      val converter = new AsciiImageToString
      val list = List(List('A','B'), List('C','D'), List('/','/'))
      val grid = PointGrid ( list )
      val img = Image ( grid )

      val imgString= "//\nCD\nAB\n"
      assert ( converter.convert(img) == imgString)
    }
  test ( "convert empty image"){
    val converter = new AsciiImageToString
    val list: List[List[Char]] = List.empty
    val grid = PointGrid ( list )
    val img = Image ( grid )
    try {
      converter.convert(img)
      assert ( false )
    } catch {
      case e: Exception =>
    }
  }
}
