package nl.wwbakker.aoc2021
import better.files._

private case class Position(horizontal : Int, depth: Int)

object Day2 {
  @main def d2a(): Unit =
    val file = file"./files/day2/input"
    val initialPosition = Position(0, 0)
    val finalPosition = file.lines.foldLeft(initialPosition)((previousPosition, inputLine) =>
      inputLine.split(" ").toList match {
        case "forward" :: number :: Nil => previousPosition.copy(horizontal = previousPosition.horizontal + number.toInt)
        case "down" :: number :: Nil => previousPosition.copy(depth = previousPosition.depth + number.toInt)
        case "up" :: number :: Nil => previousPosition.copy(depth = previousPosition.depth - number.toInt)
      }
    )
    println(s"multiplying position * depth = ${finalPosition.depth * finalPosition.horizontal}")

  private case class State(aim : Int, horizontal : Int, depth : Int)

  @main def d2b(): Unit =
    val file = file"./files/day2/input"
    val initialState = State(0, 0, 0)
    val finalState = file.lines.foldLeft(initialState) { (prevState, inputLine) =>
      val result = inputLine.split(" ").toList match {
        case "forward" :: number :: Nil => prevState.copy(
          horizontal = prevState.horizontal + number.toInt,
          depth = prevState.depth + (prevState.aim * number.toInt)
        )
        case "down" :: number :: Nil => prevState.copy(aim = prevState.aim + number.toInt)
        case "up" :: number :: Nil => prevState.copy(aim = prevState.aim - number.toInt)
      }
      println(s"input: $inputLine | result: $result")
      result
    }
    println(s"multiplying position * depth = ${finalState.depth * finalState.horizontal}")
}

