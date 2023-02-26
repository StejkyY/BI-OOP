package Filters

import Filters.Image.Specific.RotateFilter
import Models.{Image, PointGrid}
import org.scalatest.FunSuite

class RotateFilterTests extends FunSuite{

  test ( "applyFilter") {
    val list = List(List('A','B'), List('C','D'), List('E','F'))
    val grid: PointGrid[Char] = PointGrid ( list )
    val img: Image[Char] = Image ( grid )

    val listRotated= List(List('B','D','F'), List('A','C', 'E'))
    val gridRotated = PointGrid ( listRotated )
    val imgRotated = Image ( gridRotated )

    val filter = new RotateFilter ( 90 )
    assert ( filter.applyFilter( img ) == imgRotated )
  }
  test ( "applyFilter on empty image") {
    val list: List[List[Char]] = List.empty
    val grid: PointGrid[Char] = PointGrid ( list )
    val img: Image[Char] = Image ( grid )

    val filter = new RotateFilter ( 90 )
    try {
      filter.applyFilter(img)
      assert ( false )
    } catch {
      case e: Exception =>
    }
  }
  test ( "applyFilter with wrong degrees") {

    val list = List(List('A','B'), List('C','D'), List('E','F'))
    val grid: PointGrid[Char] = PointGrid ( list )
    val img: Image[Char] = Image ( grid )

    val filter = new RotateFilter ( 85 )
    try {
      filter.applyFilter(img)
      assert ( false )
    } catch {
      case e: Exception =>
    }
  }
  test ( "rotate90") {
    val list = List(List('A','B'), List('C','D'), List('E','F'))
    val grid: PointGrid[Char] = PointGrid ( list )
    val img: Image[Char] = Image ( grid )

    val listRotated= List(List('B','D','F'), List('A','C', 'E'))
    val gridRotated = PointGrid ( listRotated )
    val imgRotated = Image ( gridRotated )

    val filter = new RotateFilter ( 90 )
    //testing rotate90 function
    assert ( filter.rotate90( img, '+' ) == imgRotated )
  }
  test ( "rotate180") {
    val list = List(List('A','B'), List('C','D'), List('E','F'))
    val grid: PointGrid[Char] = PointGrid ( list )
    val img: Image[Char] = Image ( grid )

    val listRotated= List(List('F','E'), List('D','C'), List('B','A'))
    val gridRotated = PointGrid ( listRotated )
    val imgRotated = Image ( gridRotated )

    val filter = new RotateFilter ( 180 )
    assert ( filter.applyFilter( img ) == imgRotated )
  }
  test ( "rotate270") {
    val list = List(List('A','B'), List('C','D'), List('E','F'))
    val grid: PointGrid[Char] = PointGrid ( list )
    val img: Image[Char] = Image ( grid )

    val listRotated= List(List('E','C','A'), List('F','D', 'B'))
    val gridRotated = PointGrid ( listRotated )
    val imgRotated = Image ( gridRotated )

    val filter = new RotateFilter ( 270 )
    assert ( filter.applyFilter( img ) == imgRotated )
  }
  test ( "rotate360") {
    val list = List(List('A','B'), List('C','D'), List('E','F'))
    val grid: PointGrid[Char] = PointGrid ( list )
    val img: Image[Char] = Image ( grid )

    val listRotated= List(List('A','B'), List('C','D'), List('E','F'))
    val gridRotated = PointGrid ( listRotated )
    val imgRotated = Image ( gridRotated )

    val filter = new RotateFilter ( 360 )
    assert ( filter.applyFilter( img ) == imgRotated )
  }
  test ( "rotate-90") {
    val list = List(List('A','B'), List('C','D'), List('E','F'))
    val grid: PointGrid[Char] = PointGrid ( list )
    val img: Image[Char] = Image ( grid )

    val listRotated= List(List('E','C', 'A'), List('F','D','B'))
    val gridRotated = PointGrid ( listRotated )
    val imgRotated = Image ( gridRotated )

    val filter = new RotateFilter ( -90 )
    assert ( filter.applyFilter( img ) == imgRotated )
  }
  test ( "rotate-180") {
    val list = List(List('A','B'), List('C','D'), List('E','F'))
    val grid: PointGrid[Char] = PointGrid ( list )
    val img: Image[Char] = Image ( grid )

    val listRotated= List(List('F','E'), List('D','C'), List('B','A'))
    val gridRotated = PointGrid ( listRotated )
    val imgRotated = Image ( gridRotated )

    val filter = new RotateFilter ( -180 )
    assert ( filter.applyFilter( img ) == imgRotated )
  }
  test ( "rotate-270") {
    val list = List(List('A','B'), List('C','D'), List('E','F'))
    val grid: PointGrid[Char] = PointGrid ( list )
    val img: Image[Char] = Image ( grid )

    val listRotated= List(List('B','D', 'F'), List('A','C','E'))
    val gridRotated = PointGrid ( listRotated )
    val imgRotated = Image ( gridRotated )

    val filter = new RotateFilter ( -270 )
    assert ( filter.applyFilter( img ) == imgRotated )
  }
  test ( "rotate-360") {
    val list = List(List('A','B'), List('C','D'), List('E','F'))
    val grid: PointGrid[Char] = PointGrid ( list )
    val img: Image[Char] = Image ( grid )

    val listRotated= List(List('A','B'), List('C','D'), List('E','F'))
    val gridRotated = PointGrid ( listRotated )
    val imgRotated = Image ( gridRotated )

    val filter = new RotateFilter ( -360 )
    assert ( filter.applyFilter( img ) == imgRotated )
  }
}
