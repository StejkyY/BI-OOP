package Pages.Specific

import AsciiApplication.Console.Views.Pages.Specific.{ConversionSuccessPage, FilterSuccessPage}
import org.scalatest.FunSuite

class ConversionSuccessPageTests extends FunSuite{
  test ("render"){
    val page =  ConversionSuccessPage
    assert(page.render() == "Successfully Converted Image.\n")
  }
}
