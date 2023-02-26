package Checkers.DataCheckers.Specific

import Checkers.DataCheckers.DataChecker

class FilePathChecker(absoluteDirectoryPath: String ) extends DataChecker [String]{
  /**
   * Checks filepath received (does not check anything about the file, just the path)
   * @param item Filepath to be checked
   */
  override def check(item: String): String = {
    //if the path is empty, or the name does not have "." before the type
    if ( !item.contains ( ".") || item.isEmpty) throw new Exception ( "Input filepath is invalid")
      //if the item does not contain "/" and ".." then it's just the filename, so we put the absolute path before it
    else if ( !item.contains("/") && !item.contains ( "..") )  absoluteDirectoryPath + "/" + item
      //when the filepath consists of ..filename it's wrong
    else if ( !item.contains("/") && item.contains ( "..") ) {
    {
      throw new Exception ( "Input filepath is invalid")
    }
    //relative file path
    } else if ( item.contains ("/") && item.contains ( "..") ){
      val subDirectoriesOfAbsDirPath = absoluteDirectoryPath.split("/").toList
      //removing first element which would be ".." and the last element which is the filename, we want to compare if the subdirectories are correct
      var itemSubDirectories = item.split ( "/").toList.drop ( 1 ).dropRight( 1 )
      val filename = item.split ( "/").toList.last
      var i = itemSubDirectories.size - 1
      while ( i >= 0 ) {
          if ( itemSubDirectories (i) != subDirectoriesOfAbsDirPath ( i + subDirectoriesOfAbsDirPath. size - itemSubDirectories.size ) ) {
            throw new Exception ( "Input filepath is invalid" )
          }
        i = i - 1
      }
      absoluteDirectoryPath + "/" + filename
    }
    else item
  }
}
