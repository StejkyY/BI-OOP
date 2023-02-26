package Pages.Specific

import AsciiApplication.Console.Views.Pages.Specific.ImagePage
import Models.{Image, PointGrid}
import org.scalatest.FunSuite

class ImagePageTests extends FunSuite{
  test ("render"){
    val list = List(List('A','B'), List('C','D'))
    val grid = PointGrid ( list )
    val img = Image ( grid )

    val page = new ImagePage ( img )
    assert(page.render() == "CD\nAB\n")
  }
}
