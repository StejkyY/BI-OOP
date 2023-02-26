package Pages.Specific

import AsciiApplication.Console.Views.Pages.Specific.LoadSuccessPage
import org.scalatest.FunSuite

class LoadSuccessPageTests extends FunSuite {
  test ("render"){
    val page =  LoadSuccessPage
    assert(page.render() == "Successfully Loaded Image.\n")
  }
}
