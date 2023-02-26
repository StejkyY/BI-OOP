package Checkers

import Checkers.DataCheckers.Specific.FileTypeChecker
import org.scalatest.FunSuite

class FileTypeCheckerTests extends FunSuite{
  test ( "basic check"){
    val checker = new FileTypeChecker ( List ( "png", "jpg"))
    val filename = "t.jpg"

    assert ( checker.check( filename ) == filename )
  }
  test ( "no allowed file types"){
    val checker = new FileTypeChecker ( List.empty )
    val filename = "t.jpg"

    try {
      checker.check(filename)
      assert ( false )
    } catch {
      case e: Exception =>
    }
  }
  test ( "empty filename"){
    val checker = new FileTypeChecker ( List ( "png", "jpg"))
    val filename = ""

    try {
      checker.check(filename)
      assert ( false )
    } catch {
      case e: Exception =>
    }
  }
  test ( "wrong filename"){
    val checker = new FileTypeChecker ( List ( "png", "jpg"))
    val filename = "ttrt"

    try {
      checker.check(filename)
      assert ( false )
    } catch {
      case e: Exception =>
    }
  }
  test ( "unsupported file type"){
    val checker = new FileTypeChecker ( List ( "png", "jpg"))
    val filename = "ttrt.txt"

    try {
      checker.check(filename)
      assert ( false )
    } catch {
      case e: Exception =>
    }
  }
}
