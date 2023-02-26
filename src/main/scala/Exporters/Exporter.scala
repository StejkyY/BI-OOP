package Exporters

trait Exporter [T] {
  /**
   * Exports item of datatype T somewhere
   * @param item The item to export
   */
  def export(item: T): Unit
}
