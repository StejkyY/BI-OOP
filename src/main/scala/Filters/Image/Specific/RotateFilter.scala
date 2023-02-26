package Filters.Image.Specific

import Filters.Image.ImageFilter
import Models.{Image, PointGrid}

class RotateFilter (val angle: Int ) extends ImageFilter {
  /**
   * Applies the filter on an image
   * @param item Image to apply the filter on
   */
  override def applyFilter(item: Image[Char]): Image[Char] = {
    //rotating the image is based on the angle in filter
    if ( angle % 90 != 0 ) throw new Exception ( "Angle has to be multiplicity of 90.")
    else if ( item.getGrid().getHeight() == 0 || item.getGrid().getWidth() == 0 ) throw new Exception ( "Image size error")

    var rotationAngle = angle
    if ( angle > 360 ) rotationAngle = angle % 360
    var index = rotationAngle / 90
    var sign : Char = ' '
    if ( rotationAngle < 0 )  {
      sign = '-'
      index = index * -1
    }
    else sign = '+'
    var result: Image[Char] = null
    //one rotation will always happen if the angle is not equal to 0
    if ( angle != 0 ) result = rotate90 ( item, sign)

    //applying more rotations depending on the angle
    for ( i <- 1 until index){
      result = rotate90 ( result, sign)
    }
    result
  }

  /**
   * Rotates the image by 90 degrees
   * @param item Image for rotation
   * @param sign Sign that indicates the direction (+90, -90,...)
   * @return
   */
  def rotate90 ( item: Image[Char], sign : Char ): Image [Char] = {
    var result: List[List[Char]] = List.empty
    var col: List[Char] = List.empty

    if ( sign == '+') {
      var i = 0
      var l = 0
      //take cols of the image grid from 0 to grid's width and place them as lines
      while (i < item.getGrid().getWidth()) {
        l = 0
        while ( l < item.getGrid().getHeight()) {
          col = col :+ item.getGrid().getPoint(i, l)
          l = l + 1
        }
        result = col :: result
        i = i + 1
        col = List.empty
      }
    }
    else{
      var i = item.getGrid().getWidth() - 1
      var l = item.getGrid().getHeight() - 1
      //take cols of the image grid from grid's width to 0 and place them as lines
      while (i >= 0) {
        l = item.getGrid().getHeight() - 1
        while (l >= 0 ) {
          col = col :+ item.getGrid().getPoint(i, l)
          l = l - 1
        }
        result = col :: result
        col = List.empty
        i = i - 1
      }
    }
    Image ( new PointGrid [Char]( result))
  }

  /**
   * Equals method for comparing filters (used in testing)
   * @param obj Object to compare with
   */
  override def equals(obj: Any): Boolean = {
    obj match {
      case p: RotateFilter => angle.equals(p.angle)
      case _ => false
    }
  }
}
