package Pages.Specific

import AsciiApplication.Console.Views.Pages.Specific.FilterSuccessPage
import org.scalatest.FunSuite

class FilterSuccessPageTests extends FunSuite{
  test ("render"){
    val page =  FilterSuccessPage
    assert(page.render() == "Successfully Applied Filter.\n")
  }
}
