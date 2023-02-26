package Filters.Image.Specific

import Filters.Image.ImageFilter
import Models.{Image, PointGrid}

class FlipFilter ( val param: String) extends ImageFilter {

  /**
   * Applies the filter on an image
   * @param item Image to apply the filter on
   */
  override def applyFilter(item: Image[Char]): Image[Char] = {
    if ( item.getGrid().getHeight() == 0 || item.getGrid().getWidth() == 0 ) throw new Exception ( "Image size error")
    //flipping based on the filter's parameter
    if ( param.equals("x")){
      flipOnXAxis( item )
    }
    else if ( param.equals("y")){
      flipOnYAxis(item)
    }
    else throw new Exception ("Flipping only by x, y axis" )
  }

  /**
   * Flips the image on X axis
   * @param item Image to flip
   */
  def flipOnXAxis ( item: Image[Char]):Image [Char] = {
    var result: List[List[Char]] = List.empty

    for ( i <- 0 until item.getGrid().getHeight() ) {
      result = item.getGrid().getLine( i ).toList :: result
    }
    Image(new PointGrid[Char]( result ))
  }

  /**
   * Flips the image on Y axis
   * @param item Image to flip
   */
  def flipOnYAxis ( item: Image[Char] ): Image[Char] = {
    var result: List[List[Char]] = List.empty
    for ( i <- 0 until item.getGrid().getHeight() ) {
      result = result :+ item.getGrid().getLine( i ).toList.reverse
    }
    Image(new PointGrid[Char]( result ))
  }

  /**
   * Equals method for comparing filters (used in testing)
   * @param obj Object to compare with
   */
  override def equals(obj: Any): Boolean = {
    obj match {
      case p: FlipFilter => param.equals(p.param)
      case _ => false
    }
  }
}
