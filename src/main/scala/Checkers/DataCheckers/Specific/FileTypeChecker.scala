package Checkers.DataCheckers.Specific

import Checkers.DataCheckers.DataChecker

class FileTypeChecker (allowedTypes: Iterable [String] ) extends DataChecker[String]{
  override def check(item: String): String = {
    if ( allowedTypes.isEmpty) throw new Exception( "No files allowed error")
    if ( item.isEmpty || !item.contains( ".") ) throw new Exception( "File type error")
    val fileType = item.split( "\\." ).toList.last
    for ( i <- 0 until allowedTypes.size ) if ( allowedTypes.toList(i) == fileType) return item
    throw new Exception( "File type not supported, rerun with just --help")
  }
}
