package Loaders.File.Specific

import java.awt.image.BufferedImage
import java.io.File

import Checkers.DataCheckers.Specific.{FilePathChecker, FileTypeChecker}
import Loaders.File.FileLoader
import Models.{Image, Pixel, PointGrid}
import javax.imageio.ImageIO

class ImageLoader extends FileLoader [String, Image [Pixel]]{
  /**
   * Loads the image from source
   * @param source Source of the image
   */
  override def load(source: String): Image[Pixel] = {
    //Working with the relative/absolute path obtained
    val pathChecker = new FilePathChecker( "src/main/resources/images")
    //check the file type
    val typeChecker = new FileTypeChecker( List ("png", "jpg") )
    val path = pathChecker.check(source)
    val filename = path.split( "/").toList.last
    typeChecker.check( filename )

    var image: BufferedImage = null
    try {
      image = ImageIO.read(new File(path))
    } catch {
      case e: Exception => throw new Exception ( "Image loading error.")
    }
    if ( image.getWidth() == 0 || image.getHeight() == 0 ) throw new Exception ( "Image size error." )
    val w = image.getWidth()
    val h = image.getHeight()

    //loading the image pixel by pixel
    var imageArray: List[List[Pixel]] = List.empty[List[Pixel]]
    for ( y <- 0 until h  ) {
      var arr: List [Pixel] = List[Pixel]()
      for (x <- 0 until w ) {
        val color = image.getRGB(x, y)
        //extracting the colors
        arr =  arr :+ Pixel((color & 0xff0000) >> 16, (color & 0xff00) >> 8, color & 0xff)
      }
      imageArray = arr :: imageArray
    }
    if ( imageArray.isEmpty ) throw new Exception ( "Image size error.")
    Image(new PointGrid[Pixel]( imageArray ))
  }
}
