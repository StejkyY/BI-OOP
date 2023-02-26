package Pages.Specific

import AsciiApplication.Console.Views.Pages.Specific.GeneratingSuccessPage
import org.scalatest.FunSuite

class GeneratingSuccessPage extends FunSuite{
  test ("render"){
    val page =  GeneratingSuccessPage
    assert(page.render() == "Successfully Generated Image.\n")
  }
}
