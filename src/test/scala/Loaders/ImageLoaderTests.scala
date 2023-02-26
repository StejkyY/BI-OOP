package Loaders

import Helpers.TestWithFiles
import Loaders.File.Specific.ImageLoader
import Models.{Image, Pixel, PointGrid}
import org.scalatest.FunSuite

class ImageLoaderTests extends FunSuite with TestWithFiles {
 test("load with absolute path") {
  val filepath = "src/test/resources/images/test-image.jpg"
  val loader = new ImageLoader

  var list: List[List[Pixel]] = List.empty
  for (i <- 0 until 9) {
   var row: List[Pixel] = List.empty
   for (l <- 0 until 7) {
    row = row :+ Pixel(255, 255, 255)
   }
   list = list :+ row
  }
  val grid = PointGrid(list)
  val img = Image(grid)

  assert(loader.load(filepath) == img)
 }

 test("load empty image") {
  val filepath = "src/test/resources/images/test-image2.jpg"
  ensureCreated(filepath)
  val loader = new ImageLoader

  try {
   loader.load(filepath)
   assert(false)
  } catch {
   case e: Exception =>
  }
 }

 test("load image that does not exist") {
  val filepath = "src/test/resources/images/test-image3.jpg"
  ensureCreated(filepath)
  val loader = new ImageLoader

  try {
   loader.load(filepath)
   assert(false)
  } catch {
   case e: Exception =>
  }
 }
}
