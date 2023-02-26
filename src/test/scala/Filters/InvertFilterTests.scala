package Filters

import Filters.Image.Specific.InvertFilter
import Models.{Image, PointGrid}
import org.scalatest.FunSuite

class InvertFilterTests extends FunSuite {
    test ( "applyFilter") {
      val list = List(List('*','?'), List('?','*'), List('/','/'))
      val grid = PointGrid ( list )
      val img = Image ( grid )

      //inverted Characters according to the ramp used
      val listInverted= List(List(';','Z'), List('Z',';'), List('X','X'))
      val gridInverted = PointGrid ( listInverted )
      val imgInverted = Image ( gridInverted )

      val filter = new InvertFilter
      assert ( filter.applyFilter( img ) == imgInverted )
    }
    test ( "applyFilter on empty image") {
      val list: List[List[Char]] = List.empty
      val grid = PointGrid ( list )
      val img = Image ( grid )

      val filter = new InvertFilter
      try {
        filter.applyFilter(img)
        assert ( false )
      } catch {
        case e: Exception =>
      }
    }
}
