package Pages.Generic

import AsciiApplication.Console.Views.Pages.Generic.SuccessResponse
import org.scalatest.FunSuite

class SuccessResponseTests extends FunSuite{
  test ("Success response"){
    val page = SuccessResponse
    assert(page.render() == "Success\n")
  }
}
