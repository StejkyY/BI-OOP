package AsciiApplication.Console

import AsciiApplication.Console.Controllers.ConsoleController
import AsciiApplication.Console.Views.ConsoleView
import Exporters.Text.StdOutputExporter

object Main extends App {
  val stdOutput = new StdOutputExporter
  val controller = new ConsoleController(stdOutput)

  //Create the view
  val view = new ConsoleView(controller)

  //Run the program
  view.run(args)

}
