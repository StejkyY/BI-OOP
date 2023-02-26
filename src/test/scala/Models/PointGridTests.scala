package Models

import org.scalatest.FunSuite

class PointGridTests extends FunSuite{

  test ( "getPoint" ){
    val list = List(List('A','B'), List('B','A'), List('F','F'))
    val grid = PointGrid ( list )

    assert ( grid.getPoint(1, 2) == 'F')
  }
  test ( "getPoint - out of bounds" ){
    val list = List(List('A','B'), List('B','A'), List('F','F'))
    val grid = PointGrid ( list )

    try {
      grid.getPoint(3, 2)
      assert (false)
    } catch {
      case e : Exception =>
    }

  }

  test ( "getHeight" ){
    val list = List(List('A','B'), List('B','A'), List('F','F'))
    val grid = PointGrid ( list )

    assert ( grid.getHeight == 3 )
  }

  test ( "getWidth" ){
    val list = List(List('A','B'), List('B','A'), List('F','F'))
    val grid = PointGrid ( list )

    assert ( grid.getWidth == 2 )
  }

  test ( "getLine" ){
    val list = List(List('A','B'), List('B','A'), List('F','F'))
    val grid = PointGrid ( list )

    assert ( grid.getLine(1) == List('B','A'))
  }
  test ( "getLine - out of bounds" ){
    val list = List(List('A','B'), List('B','A'), List('F','F'))
    val grid = PointGrid ( list )

    try {
      grid.getLine( -1 )
      assert(false)
    }catch{
      case e: Exception =>
    }
  }

  test ( "map" ){
    def mapper ( item: Char ): Int = {
      if ( item == 'A' ) 1
      else 2
    }
    //testing mapping from Grid of Chars to Grid of Ints
    val list = List(List('A','B'), List('B','A'), List('F','F'))
    val grid = PointGrid ( list )
    val gridCorrect = PointGrid ( List(List(1,2), List(2,1), List(2,2)))

    assert ( grid.map ( mapper ) == gridCorrect )
  }
}
