package Models

case class Image [T](pointGrid: PointGrid [T]) {

  /**
   * Returns the PointGrid of image
   */
  def getGrid (): PointGrid [T] = {
    pointGrid
  }

  /**
   * Transforms image from datatype T to datatype A using a mapper function that is applied on grid
   * @param mapper Mapper function to be applied
   * @return
   */
  def transform [A] ( mapper: T => A ): Image [A] = {
    Image ( pointGrid.map( mapper ))
  }
}
