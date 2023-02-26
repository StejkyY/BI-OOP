package Views

import AsciiApplication.Console.Controllers.Controller
import AsciiApplication.Console.Views.ConsoleView
import Filters.Image.ImageFilter
import Filters.Image.Specific.{FlipFilter, InvertFilter, RotateFilter}
import org.mockito.Mockito.{times, verify}
import org.mockito.MockitoSugar.mock
import org.mockito.captor.ArgCaptor
import org.scalatest.FunSuite


class ConsoleViewTests extends FunSuite {
  test("help command") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)

    view.processCommand("--help")
    verify(mockController).showHelp()
  }

  test("--image-random command") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)

    view.processCommand("--image-random")

    //check if the function that has to be called was actually called
    verify(mockController).generateImage()
  }

  test("--image command relative") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)

    //capture path
    val pathCapture = ArgCaptor[String]
    view.processCommand("--image fanta.png")

    //check if the function that has to be called was actually called
    verify(mockController).loadImage(pathCapture)

    //check if the path is right
    assert(pathCapture.value == "fanta.png")
  }
  test("--image command with filters") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)

    val pathCapture = ArgCaptor[String]
    val filters = ArgCaptor [ImageFilter]

    view.processCommand("--image fanta.png --invert --flip x --flip y --rotate 180")
    verify(mockController).loadImage(pathCapture)

    //check if the filters were applied 4 times
    verify(mockController, times (4)).filterImage(filters)

    println ( filters.values.head )
    assert(pathCapture.value == "fanta.png")

    //check if the filters were all correct
    assert ( filters.values.head.equals ( new InvertFilter() ))
    assert ( filters.values( 1 ).equals( new FlipFilter("x") ))
    assert ( filters.values ( 2 ) == new FlipFilter("y") )
    assert ( filters.values ( 3 ) == new RotateFilter(180) )
  }
  test("--image command with --output-console") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)

    val pathCapture = ArgCaptor[String]
    view.processCommand("--image fanta.png --output-console")
    verify(mockController).loadImage(pathCapture)
    verify(mockController).exportImageToConsole()
  }
  test("--image command with --output-file relative") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)

    val pathInCapture = ArgCaptor[String]
    val pathOutCapture = ArgCaptor[String]
    view.processCommand("--image fanta.png --output-file result.txt")
    verify(mockController).loadImage(pathInCapture)
    verify(mockController).exportImageToFile(pathOutCapture)

    assert(pathInCapture.value == "fanta.png")
    assert(pathOutCapture.value == "result.txt")
  }
  test("--image command with --output-file absolute") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)

    val pathInCapture = ArgCaptor[String]
    val pathOutCapture = ArgCaptor[String]
    view.processCommand("--image fanta.png --output-file src/main/resources/outputs/result.txt")
    verify(mockController).loadImage(pathInCapture)
    verify(mockController).exportImageToFile(pathOutCapture)

    assert(pathInCapture.value == "fanta.png")
    assert(pathOutCapture.value == "src/main/resources/outputs/result.txt")
  }
  test("Long command") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)

    val pathInCapture = ArgCaptor[String]
    val filterCapture = ArgCaptor[ImageFilter]
    val pathOutCapture = ArgCaptor[String]

    view.processCommand("--image fanta.png --invert --rotate 270 --output-file result.txt --flip x --output-console")
    verify(mockController).loadImage(pathInCapture)
    verify(mockController, times(3)).filterImage(filterCapture)
    verify(mockController).exportImageToFile( pathOutCapture )
    verify(mockController).exportImageToConsole( )

    assert(pathInCapture.value == "fanta.png")
    assert(filterCapture.values.head.equals(new InvertFilter))
    assert(filterCapture.values(1).equals(new RotateFilter(270)))
    assert(pathOutCapture.value == "result.txt")
    assert(filterCapture.values(2).equals(new FlipFilter("x")))
  }
  test("Long command with empty filter parameter") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)

    try {
    view.processCommand("--image fanta.png --invert --rotate --output-file result.txt --flip x --output-console")
      assert ( false )
    }catch {
      case e: Exception =>
    }

  }
  test("Completely wrong command") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)
    try {
      view.processCommand("s dadasd adasdas65")
      assert(false)
    } catch {
      case e: Exception =>
    }
  }
  test("--image with wrong filepath") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)
    try {
      view.processCommand("--image f")
      assert(false)
    } catch {
      case e: Exception =>
    }
  }
  test("--image with empty filepath") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)
    try {
      view.processCommand("--image ")
      assert(false)
    } catch {
      case e: Exception =>
    }
  }
  test("--output with unknown parameter") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)
    try {
      view.processCommand("--image fanta.png --output-g")
      assert(false)
    } catch {
      case e: Exception =>
    }
  }
  test("--output with empty filepath") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)
    try {
      view.processCommand("--image fanta.png --output-file")
      assert(false)
    } catch {
      case e: Exception =>
    }
  }
  test("--flip with no parameter") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)
    try {
      view.processCommand("--image fanta.png --flip --output-file")
      assert(false)
    } catch {
      case e: Exception =>
    }
  }
  test("--rotate with no parameter") {
    val mockController = mock[Controller]
    val view = new ConsoleView(mockController)
    try {
      view.processCommand("--image fanta.png --flip x --rotate --output-file")
      assert(false)
    } catch {
      case e: Exception =>
    }
  }
}