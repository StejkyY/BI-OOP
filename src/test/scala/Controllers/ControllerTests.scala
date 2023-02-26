package Controllers

import java.io.{ByteArrayOutputStream, OutputStream}

import AsciiApplication.Console.Controllers.ConsoleController
import AsciiApplication.Console.Main.controller
import AsciiApplication.Console.Views.Pages.Generic.SuccessResponse
import AsciiApplication.Console.Views.Pages.Specific.{ConversionSuccessPage, FilterSuccessPage, GeneratingSuccessPage, HelpPage, ImagePage, LoadSuccessPage, MainPage}
import Converters.DataType.Specific.PixelToAscii
import Exporters.Text.StreamTextExporter
import Filters.Image.Specific.{FlipFilter, InvertFilter, RotateFilter}
import Filters.InvertFilterTests
import Helpers.TestWithFiles
import Loaders.File.Specific.ImageLoader
import org.scalatest.FunSuite

import scala.io.Source

class ControllerTests extends FunSuite with TestWithFiles {
  protected def getConsoleController(stream: OutputStream): ConsoleController ={
    val exporter = new StreamTextExporter(stream)
    new ConsoleController(exporter)
  }

  test ("help command"){
      val stream = new ByteArrayOutputStream()
      val controller = getConsoleController(stream)

      controller.showHelp()

      //checking if the text in stream is the same as the help page
      val text = stream.toString("UTF-8")
      assert(text == new HelpPage().render())
  }
  test ("generate image"){
    val stream = new ByteArrayOutputStream()
    val controller = getConsoleController(stream)

    controller.generateImage()

    //checking if the text in stream is success
    val text = stream.toString("UTF-8")
    assert(text == GeneratingSuccessPage.render() )
  }
  test ("load image"){
    val stream = new ByteArrayOutputStream()
    val controller = getConsoleController(stream)

    controller.loadImage( "fanta.png" )

    //checking if the text in stream is success
    val text = stream.toString("UTF-8")
    assert(text == LoadSuccessPage.render() )
  }
  test ( "load image with wrong file"){
    val stream = new ByteArrayOutputStream()
    val controller = getConsoleController(stream)

    try {
      controller.loadImage("fant.png")
      assert ( false )
    } catch {
      case e: Exception =>
    }
  }
  test ("convert image"){
    val stream = new ByteArrayOutputStream()
    val controller = getConsoleController(stream)

    controller.loadImage( "fanta.png" )
    stream.reset()
    controller.convertImage()

    //checking if the text in stream is success
    val text = stream.toString("UTF-8")
    assert(text == ConversionSuccessPage.render() )
  }
  test ("show main page command"){
    val stream = new ByteArrayOutputStream()
    val controller = getConsoleController(stream)

    controller.showMainPage()

    //checking if the text in stream is the same as main page
    val text = stream.toString("UTF-8")
    assert(text == new MainPage().render()  )
  }
  test ("export image to file"){
    val filePath = getTestFile
    try {
      val stream = new ByteArrayOutputStream()
      val controller = new ConsoleController(new StreamTextExporter(stream))
      controller.loadImage( "fanta.png")
      controller.convertImage()
      stream.reset()

      ensureCreated(filePath)
      controller.exportImageToFile(filePath)

      val text = stream.toString("UTF-8")
      assert(text == SuccessResponse.render())

      val source = Source.fromFile(filePath)
      val content = source.mkString
      source.close()

      //For comparison of the file content we need corresponding ASCII image
      val testLoader = new ImageLoader ()
      val testConverter: PixelToAscii = new PixelToAscii
      val testCharImg = testLoader.load( "fanta.png").transform( testConverter.convert )

      assert(content == new ImagePage( testCharImg ).render() )

    }
    finally{
      ensureDeleted(filePath)
    }
  }
  test ("export image to console"){
    val stream = new ByteArrayOutputStream()
    val controller = new ConsoleController(new StreamTextExporter(stream))

    controller.loadImage( "fanta.png")
    controller.convertImage()
    stream.reset()
    controller.exportImageToConsole()

    //For comparison of the console content we need corresponding ASCII image
    val testLoader = new ImageLoader ()
    val testConverter: PixelToAscii = new PixelToAscii
    val testCharImg = testLoader.load( "fanta.png").transform( testConverter.convert )

    val text = stream.toString("UTF-8")
    assert(text == new ImagePage( testCharImg ).render()  )
  }
  test ( "filter image" ){
    val stream = new ByteArrayOutputStream()
    val controller = new ConsoleController(new StreamTextExporter(stream))

    val flip = new FlipFilter( "x" )
    val invert = new InvertFilter ()
    val rotate = new RotateFilter( 90 )

    controller.loadImage( "fanta.png")
    controller.convertImage()
    stream.reset()

    //applying all filters
    controller.filterImage( flip )
    controller.filterImage( rotate )
    controller.filterImage( invert )
    val text = stream.toString("UTF-8")
    assert( text == FilterSuccessPage.render() + FilterSuccessPage.render() + FilterSuccessPage.render()  )
  }
}
