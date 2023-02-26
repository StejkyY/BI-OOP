package Models

import org.scalatest.FunSuite

class ImageTests extends FunSuite{
  test ( "getGridChars"){
    val list = List(List('A','B'), List('C','D'))
    val grid = PointGrid ( list )

    val img = Image ( grid )
    assert (img.getGrid() == grid)
  }
  test ( "getGridPixels"){
    val list = List(List(Pixel(1,2,3),Pixel(4,5,6)), List(Pixel(7,8,9),Pixel(10,11,12)))
    val grid = PointGrid ( list )

    val img = Image ( grid )
    assert (img.getGrid() == grid)
  }
  test ( "transform" ){
    //testing transformation from Image of Chars to Image of Ints
    def mapper ( item: Char ): Int = {
      if ( item == 'A' ) 1
      else 2
    }
    val list = List(List('A','B'), List('B','A'))
    val grid = PointGrid ( list )
    val img = Image ( grid )

    val listCorrect = List(List(1,2), List(2,1))
    val gridCorrect = PointGrid ( listCorrect )
    val imgCorrect = Image ( gridCorrect )

    assert ( img.transform( mapper ) == imgCorrect )
  }
}
