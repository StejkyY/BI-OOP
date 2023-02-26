package Filters

import Models.{Image, PointGrid}
import org.scalatest.FunSuite
import Filters.Image.Specific.FlipFilter

class FlipFilterTests extends FunSuite{
  test ( "applyFilter") {
    val list = List(List('A','B'), List('B','A'), List('M','D'))
    val grid = PointGrid ( list )
    val img = Image ( grid )

    //same list as above flipped by X axis
    val listFlipped = List(List('M','D'), List('B','A'), List('A','B'))
    val gridFlipped = PointGrid ( listFlipped )
    val imgFlipped = Image ( gridFlipped )

    val param = "x"
    val filter = new FlipFilter ( param )
    assert ( filter.applyFilter( img ) == imgFlipped )
  }

  test ( "applyFilter with wrong parameter") {
    val list = List(List('A','B'), List('B','A'), List('M','D'))
    val grid = PointGrid ( list )
    val img = Image ( grid )

    val param = "420"
    val filter = new FlipFilter ( param )
    try {
      filter.applyFilter(img)
      assert (false)
    } catch {
      case e: Exception =>
    }
  }

  test ( "applyFilter on empty image") {
    val list: List[List[Char]] = List.empty
    val grid = PointGrid ( list )
    val img = Image ( grid )

    val param = "x"
    val filter = new FlipFilter ( param )
    try {
      filter.applyFilter(img)
      assert (false)
    } catch {
      case e: Exception =>
    }
  }

  test ( "applyFilter with empty parameter") {
    val list = List(List('A','B'), List('B','A'), List('M','D'))
    val grid = PointGrid ( list )
    val img = Image ( grid )

    val param = ""
    val filter = new FlipFilter ( param )
    try {
      filter.applyFilter(img)
      assert (false)
    } catch {
      case e: Exception =>
    }
  }

  test ( "flipOnXAxis") {
    val list = List(List('A','B'), List('B','A'), List('M','D'), List ('G', 'R'))
    val grid = PointGrid ( list )
    val img = Image ( grid )

    //same list as above flipped by X axis
    val listFlipped = List(List('G','R'), List('M','D'), List('B','A'), List('A','B'))
    val gridFlipped = PointGrid ( listFlipped )
    val imgFlipped = Image ( gridFlipped )

    val param = "x"
    val filter = new FlipFilter ( param )
    assert ( filter.flipOnXAxis( img ) == imgFlipped )
  }
  test ( "flipOnYAxis") {
    val list = List(List('A','B'), List('B','A'), List('M','D'), List ('G', 'R'))
    val grid = PointGrid ( list )
    val img = Image ( grid )

    //same list as above flipped by Y axis
    val listFlipped = List(List('B','A'), List('A','B'), List('D','M'), List('R','G'))
    val gridFlipped = PointGrid ( listFlipped )
    val imgFlipped = Image ( gridFlipped )

    val param = "y"
    val filter = new FlipFilter ( param )
    assert ( filter.flipOnYAxis( img ) == imgFlipped )
  }
}
