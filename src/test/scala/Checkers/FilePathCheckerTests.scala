package Checkers

import Checkers.DataCheckers.Specific.FilePathChecker
import org.scalatest.FunSuite

class FilePathCheckerTests extends FunSuite{
  test  ( "check absolute path" )
  {
    val path = "src/test/resources/images/test-image.jpg"
    val pathChecker = new FilePathChecker ( "src/test/resources/images")
    assert ( pathChecker.check( path ) == path )
  }
  test  ( "check wrong absolute path" )
  {
    val path = "src/test/sources/images/test-image.jpg"
    val pathChecker = new FilePathChecker ( "src/test/resources/images")
    try {
      pathChecker.check( path )
      assert ( false )
    } catch {
      case e: Exception =>
    }
  }
  test  ( "check relative path 1" )
  {
    val path = "test-image.jpg"
    val absolutePath = "src/test/resources/images/test-image.jpg"
    val pathChecker = new FilePathChecker ( "src/test/resources/images")
    assert ( pathChecker.check( path ) == absolutePath )
  }
  test  ( "check wrong relative path 1" )
  {
    val path = "test-img.jpg"
    val pathChecker = new FilePathChecker ( "src/test/resources/images")
    try {
      pathChecker.check( path )
      assert ( false )
    } catch {
      case e: Exception =>
    }
  }
  test  ( "check relative path 2" )
  {
    val path = "../test-image.jpg"
    val absolutePath = "src/test/resources/images/test-image.jpg"
    val pathChecker = new FilePathChecker ( "src/test/resources/images")
    assert ( pathChecker.check( path ) == absolutePath )
  }
  test  ( "check wrong relative path 2" )
  {
    val path = "../outputs/test-img.jpg"
    val pathChecker = new FilePathChecker ( "src/test/resources/images")
    try {
      pathChecker.check( path )
      assert ( false )
    } catch {
      case e: Exception =>
    }
  }
  test  ( "check relative path 3" )
  {
    val path = "../images/test-image.jpg"
    val absolutePath = "src/test/resources/images/test-image.jpg"
    val pathChecker = new FilePathChecker ( "src/test/resources/images")
    assert ( pathChecker.check( path ) == absolutePath )
  }
  test  ( "check wrong relative path 3" )
  {
    val path = "/test-img.jpg"
    val pathChecker = new FilePathChecker ( "src/test/resources/images")
    try {
      pathChecker.check( path )
      assert ( false )
    } catch {
      case e: Exception =>
    }
  }
  test  ( "check filename missing type" )
  {
    val path = "testimage"
    val pathChecker = new FilePathChecker ( "src/test/resources/images")
    try {
      pathChecker.check( path )
      assert ( false )
    } catch {
      case e: Exception =>
    }
  }
  test  ( "check empty filepath" )
  {
    val path = ""
    val pathChecker = new FilePathChecker ( "src/test/resources/images")
    try {
      pathChecker.check( path )
      assert ( false )
    } catch {
      case e: Exception =>
    }
  }
  test  ( "check weird filepath" )
  {
    val path = "../images\\test-image.jpg"
    val pathChecker = new FilePathChecker ( "src/test/resources/images")
    try {
      pathChecker.check( path )
      assert ( false )
    } catch {
      case e: Exception =>
    }
  }
}
