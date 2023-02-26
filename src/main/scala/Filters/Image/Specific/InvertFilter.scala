package Filters.Image.Specific

import Converters.DataType.Specific.AsciiToAsciiInverted
import Filters.Image.ImageFilter
import Models.{Image, Pixel}

class InvertFilter extends ImageFilter {
  /**
   * Applies the filter on an image
   * @param item Image to apply the filter on
   */
  override def applyFilter(item: Image[Char]): Image[Char] = {
    if ( item.getGrid().getHeight() == 0 || item.getGrid().getWidth() == 0 ) throw new Exception ( "Image size error")
    val invertMapper = new AsciiToAsciiInverted
    item.transform( invertMapper.convert )
  }

  /**
   * Equals method for comparing filters (used in testing)
   * @param obj Object to compare with
   */
  override def equals(obj: Any): Boolean = {
    obj match {
      case p: InvertFilter => true
      case _ => false
    }
  }
}
