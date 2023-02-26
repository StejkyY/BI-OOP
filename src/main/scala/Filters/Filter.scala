package Filters

trait Filter [T] {
  /**
   * Applies the filter on an item of datatype T
   * @param item Item to apply the filter on
   */
  def applyFilter ( item: T ): T
}
