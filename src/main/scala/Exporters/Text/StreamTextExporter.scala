package Exporters.Text

import java.io.OutputStream


class StreamTextExporter (outputStream: OutputStream) extends TextExporter {

  private var closed = false

  /**
   * Exports text to an output stream
   * @param text Text to export
   */
  protected def exportToStream(text: String): Unit ={
    if (closed)
      throw new Exception("The stream is already closed")

    outputStream.write(text.getBytes("UTF-8"))
    outputStream.flush()
  }

  /**
   * Closes the output stream
   */
  def close(): Unit = {
    if (closed)
      return

    outputStream.close()
    closed = true
  }

  /**
   * Exports text
   * @param item Text to export
   */
  override def export(item: String): Unit = exportToStream(item)

}
