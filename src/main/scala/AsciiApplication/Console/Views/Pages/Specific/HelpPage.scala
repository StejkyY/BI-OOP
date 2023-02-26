package AsciiApplication.Console.Views.Pages.Specific

import AsciiApplication.Console.Views.Pages.TextPage

class HelpPage extends TextPage{
  /**
   * Renders text page with help
   */
  override def render(): String = {
    var result = ""

    result += "-----ARGUMENTS-----\n"
    result += "--image source\n"
    result += "--output-console\n"
    result += "--output-file target\n"
    result += "Only use TXT as output file formats.\n"
    result += "Start arguments with --image source\n"
    result += "Only use PNG and JPG as input file formats.\n"
    result += "Example command: run --image test-image.jpg [filter 1] [filter 2] [filter 3] --output-console\n"

    result += "-----FILTERS-----\n"
    result += "--invert\n"
    result += "--flip x\n"
    result += "--flip y\n"
    result += "--rotate angle (multiplier of 90)\n"
    result += "EXAMPLE: run --image test-image.jpg --rotate 90 --invert --output-file ../outputs/output.txt --flip x --output-console\n"

    result

  }
}
