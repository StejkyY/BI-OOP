package Loaders

trait Loader [T, B] {
  /**
   * Loads something from datatype T source to datatype B
   * @param source Source to the loaded
   */
  def load ( source: T): B
}
