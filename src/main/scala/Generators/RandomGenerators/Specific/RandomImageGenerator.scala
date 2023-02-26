package Generators.RandomGenerators.Specific

import Generators.RandomGenerators.RandomGenerator
import Models.{Image, Pixel, PointGrid}

import scala.util.Random

class RandomImageGenerator extends RandomGenerator [Image[Pixel]]{
  /**
   * Generates a completely random image of random size (just simple random pixels), atleast 2x2, max 800*800
   */
  override def generate(): Image[Pixel] = {
    val minHeight = 2
    val maxHeight = 800
    val minWidth = 2
    val maxWidth = 800
    val randomHeight = Random.between (minHeight, maxHeight)
    val randomWidth = Random.between(minWidth, maxWidth )

    var list: List [List [Pixel]]= List.empty

    for ( i <- 0 until randomHeight ){
      var row: List [Pixel] = List.empty
      for ( l <- 0 until randomWidth ) {
        row = row :+ Pixel ( Random.between ( 0, 255 ), Random.between ( 0, 255 ), Random.between ( 0, 255 ) )
      }
      list = list :+ row
    }
    Image ( PointGrid ( list ) )
  }
}
