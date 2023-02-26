package Pages.Specific

import AsciiApplication.Console.Views.Pages.Specific.HelpPage
import org.scalatest.FunSuite

class HelpPageTests extends FunSuite{
  test ("render"){
    val page =  new HelpPage
    assert(page.render() == "-----ARGUMENTS-----\n"
      + "--image source\n"
      + "--output-console\n"
      + "--output-file target\n"
      + "Only use TXT as output file formats.\n"
      + "Start arguments with --image source\n"
      + "Only use PNG and JPG as input file formats.\n"
      + "Example command: run --image test-image.jpg [filter 1] [filter 2] [filter 3] --output-console\n"

      + "-----FILTERS-----\n"
      + "--invert\n"
      + "--flip x\n"
      + "--flip y\n"
      + "--rotate angle (multiplier of 90)\n"
      + "EXAMPLE: run --image test-image.jpg --rotate 90 --invert --output-file ../outputs/output.txt --flip x --output-console\n")
  }
}
