package Pages.Specific

import AsciiApplication.Console.Views.Pages.Specific.MainPage
import org.scalatest.FunSuite

class MainPageTests extends FunSuite{
  test ("render"){
    val page = new MainPage
    assert(page.render() == "-----ASCII ART-----\n" + "Welcome! If you're unsure about what to type in, rerun the application just with --help\n")
  }
}
