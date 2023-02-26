package Exporters

import java.io.ByteArrayOutputStream

import Exporters.Text.StreamTextExporter
import org.scalatest.FunSuite

class StreamTextExporterTests extends FunSuite{
  test ("Write" ){
    val stream = new ByteArrayOutputStream()
    val exporter = new StreamTextExporter(stream)

    exporter.export("POMOC")

    assert(stream.toString("UTF-8") == "POMOC")

  }
}
