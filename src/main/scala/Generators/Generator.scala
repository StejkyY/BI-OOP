package Generators

trait Generator [T] {

  /**
   * Generates something of datatype T
   */
  def generate ( ): T
}
