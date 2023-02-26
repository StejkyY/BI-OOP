package Converters

trait Converter [T,B] {

  /**
   * Converts item of type T to type B
   * @param item Item to be converted
   */
  def convert ( item: T ) : B
}
