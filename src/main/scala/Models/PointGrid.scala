package Models

case class PointGrid [T](points: Iterable[Iterable[T]]){

  /**
   * Returns point from the grid based on coordinates in the datatype T (datatype of image's points)
   * @param x X coordinate
   * @param y Y coordinate
   * @return
   */
  def getPoint ( x: Int, y: Int ): T = {
      if ( x < 0 || y < 0 || x > getWidth() || y > getHeight ( ) ) throw new Exception ( "Point coordinates out of bounds error")
      var tmp = points.slice(y, y + 1).head
      tmp = tmp.slice( x, x + 1)
      tmp.head
  }

  /**
   * Returns Height of the grid
   */
  def getHeight ( ) : Int = {
    points.size
  }

  /**
   * Returns Height of the grid
   */
  def getWidth ( ) : Int = {
    points.head.size
  }

  /**
   * Returns Line of the grid based on y coordinate in Iterable collection of the datatype T (datatype of image's points)
   * @param y Y coordinate
   * @return
   */
  def getLine ( y: Int): Iterable [T] = {
    if ( y < 0 || y > getHeight ( ) ) throw new Exception ( "Y coordinate out of bounds error")
    points.slice(y, y + 1).head
  }

  /**
   * Maps a mapper function on the grid
   * @param mapper Mapper function to be applied
   * @return
   */
  def map [A] ( mapper: T => A ): PointGrid[A]  = {
    PointGrid(points.map( _.map ( mapper ) ))
  }
}
