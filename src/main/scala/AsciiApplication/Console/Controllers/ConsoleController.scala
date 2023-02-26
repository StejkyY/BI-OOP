package AsciiApplication.Console.Controllers

import java.io.File

import AsciiApplication.Console.Views.Pages.Generic.SuccessResponse
import AsciiApplication.Console.Views.Pages.Specific.{ConversionSuccessPage, FilterSuccessPage, GeneratingSuccessPage, HelpPage, ImagePage, LoadSuccessPage, MainPage}
import AsciiApplication.Console.Views.Pages.TextPage
import Checkers.DataCheckers.Specific.{FilePathChecker, FileTypeChecker}
import Converters.DataType.Specific.{AsciiImageToString, PixelToAscii}
import Exporters.Text.{FileOutputExporter, TextExporter}
import Filters.Image.ImageFilter
import Generators.RandomGenerators.Specific.RandomImageGenerator
import Loaders.File.Specific.ImageLoader
import Models.{Image, Pixel, PointGrid}
import javax.imageio.IIOException

class ConsoleController ( stdOutput: TextExporter) extends Controller{
  private var imageChar : Image [Char] = null
  private var imagePixel : Image [Pixel] = null

  override def showHelp(): Unit = render( new HelpPage )

  override def generateImage(): Unit = {
    val generator = new RandomImageGenerator
    imagePixel = generator.generate()
    render ( GeneratingSuccessPage )
  }

  override def loadImage(source: String): Unit = {
    val loader : ImageLoader = new ImageLoader
      imagePixel = loader.load(source)
      render(LoadSuccessPage)
  }

  override def convertImage(): Unit = {
    val converter: PixelToAscii = new PixelToAscii
      imageChar = imagePixel.transform( converter.convert )
      render ( ConversionSuccessPage )
  }

  /**
   * Renders a TextPage object
   * @param renderer Renderer that can render a text
   */
  protected def render ( renderer: TextPage): Unit = {
    val output = renderer.render()
    stdOutput.export ( output )
  }

  override def showMainPage(): Unit = render ( new MainPage )

  override def exportImageToFile(path: String): Unit = {
    val renderer = new ImagePage( imageChar )
      //work with the filepath (absolute/relative)
      val pathChecker = new FilePathChecker( "src/main/resources/outputs")
      //check the type
      val typeChecker = new FileTypeChecker( List ("txt") )
      val filename = path.split( "/").toList.last
      typeChecker.check( filename )

      val file = new File(pathChecker.check( path ))
      val exporter = new FileOutputExporter(file)

      //Do the export
      exporter.export(renderer.render())
      exporter.close()
      //Return success
      render(SuccessResponse)
  }

  override def exportImageToConsole(): Unit = {
      render(new ImagePage(imageChar))
  }

  override def filterImage(filter: ImageFilter): Unit = {
      imageChar = filter.applyFilter(imageChar)
      render(FilterSuccessPage)
  }
}
