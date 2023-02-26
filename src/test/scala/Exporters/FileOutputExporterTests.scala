package Exporters

import java.io.File

import Exporters.Text.FileOutputExporter
import Helpers.TestWithFiles
import org.scalatest.FunSuite

class FileOutputExporterTests extends FunSuite
  with TestWithFiles
{
  test("No file exists"){
    val fileName = getTestFile

    try {
      ensureDeleted(fileName)

      val file = new File(fileName)
      val exporter = new FileOutputExporter(file)

      exporter.export("Ahoj")
      exporter.close()

      assertFileContent(fileName, "Ahoj")
    }
    finally {
      ensureDeleted(fileName)
    }
  }

  test("File already exists"){
    val fileName = getTestFile

    try{
      ensureCreated(fileName)

      val file = new File(fileName)
      val exporter = new FileOutputExporter(file)

      exporter.export("Ahoj")
      exporter.close()

      assertFileContent(fileName, "Ahoj")
    }
    finally{
      ensureDeleted(fileName)
    }
  }

}
