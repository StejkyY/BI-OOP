package AsciiApplication.Console.Controllers

import Filters.Image.ImageFilter
import Models.Image

trait Controller {

  /**
   * Shows the main (welcome) page
   */
  def showMainPage(): Unit

  /**
   * Shows the help page
   */
  def showHelp(): Unit

  /**
   * Generates random image
   */
  def generateImage(): Unit

  /**
   * Loads image from source provided by the user
   * @param source String source of the image
   */
  def loadImage ( source: String ): Unit

  /**
   * Converts stored image of Pixels to image of Chars
   */
  def convertImage ( ) : Unit

  /**
   * Applies filter on the image of Chars
   * @param filter Filter to apply
   */
  def filterImage ( filter: ImageFilter )

  /**
   * Exports image to a file
   * @param path Path to the file
   */
  def exportImageToFile ( path: String ) : Unit

  /**
   * Exports image to console
   */
  def exportImageToConsole ( ): Unit
}
