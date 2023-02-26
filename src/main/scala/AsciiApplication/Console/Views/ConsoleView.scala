package AsciiApplication.Console.Views

import AsciiApplication.Console.Controllers.Controller
import Checkers.DataCheckers.Specific.FilePathChecker
import Models.Image
import Converters.DataType.Specific.AsciiToAsciiInverted
import Filters.Image.Specific.{FlipFilter, InvertFilter, RotateFilter}

import scala.io.StdIn

class ConsoleView (controller: Controller) {
  /**
   * Main application loop
   */
  def run(args: Array [String]): Unit = {
    controller.showMainPage()
    var command: String = ""
    for ( i <- args.indices ) {
      command += args.toList (i)
      command += " "
    }
    processCommand( command )
  }

  /**
   * Processes all command line arguments in one String
   * @param command The command line arguments string
   */
  def processCommand ( command: String ): Unit = {
    //show help
    if ( command == "--help" ) {
      controller.showHelp()
      return
    }

    if ( command.startsWith("--image") ){
      val arguments = command.split(" ")
          var i = 0

          while ( i < arguments.toList.size  ) {
            if ( arguments.toList ( i ).equals( "--image") ){
              if (arguments.toList.size == i + 1 ) throw new Exception("Input file is empty")
              controller.loadImage( arguments.toList ( i + 1 ) )
              controller.convertImage()
              i = i + 1
            }
            //check if the argument is for generating random image
            else if ( arguments.toList ( i ).equals( "--image-random") ){
              controller.generateImage()
              controller.convertImage()
            }
            //check if the argument is for exporting to console
            else if ( arguments.toList ( i ).equals( "--output-console") ) controller.exportImageToConsole()
            //check if the argument is for exporting to file
            else if ( arguments.toList ( i ).equals( "--output-file") ) {
              if (arguments.toList.size == i + 1 ) throw new Exception("Output file is empty")
              val output = arguments.toList ( i + 1 )
              controller.exportImageToFile( output )
              i = i + 1
            }
            //check if the argument is for inverting the ASCII Image
            else if (arguments.toList ( i ).equals ( "--invert") )
            {
              controller.filterImage( new InvertFilter )
            }
            //check if the argument is for flipping the ASCII Image
            else if ( arguments.toList ( i ).equals ( "--flip")){
              if (arguments.toList.size == i + 1 ) throw new Exception("Flip parameter is missing")
              val sign = arguments.toList ( i + 1 )
              controller.filterImage( new FlipFilter( sign ) )
              i = i + 1
            }
            //check if the argument is for rotating the ASCII Image
            else if ( arguments.toList ( i ).equals ( "--rotate") ){
              if (arguments.toList.size == i + 1 ) throw new Exception("Rotate angle is missing")
              val param = arguments.toList ( i + 1 ).toInt
              controller.filterImage( new RotateFilter( param ) )
              i = i + 1
            }
            //if the argument is none of the above, it's wrong
            else throw new Exception ( "Command is wrong, rerun with --help for help" )
            i = i + 1
      }
    }
    else throw new Exception("Command is wrong, rerun with --help for help")
  }
}
