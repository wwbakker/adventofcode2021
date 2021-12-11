package nl.wwbakker.aoc2021
import better.files._

object Day1 {
  case class State(previousMeasurementOption: Option[Int], numberOfTimesIncreased: Int)

  @main def d1a(): Unit =
    val file = file"./files/day1/input"
    val measurements = file.lines.map(_.toInt)
    val initialState = State(previousMeasurementOption = None, numberOfTimesIncreased = 0)
    val finalState = measurements.foldLeft(initialState) {
      case (previousState, measurement) =>
        val isIncreased = previousState.previousMeasurementOption.exists(measurement > _)
        State(previousMeasurementOption = Some(measurement), previousState.numberOfTimesIncreased + (if (isIncreased) 1 else 0))
    }
    println(s"number of times increased ${finalState.numberOfTimesIncreased}")

  @main def d1b(): Unit =
    val file = file"./files/day1/input"
    val measurements = file.lines.map(_.toInt)
    val slidingWindowSums = measurements.sliding(3).map(_.sum)
    val initialState = State(previousMeasurementOption = None, numberOfTimesIncreased = 0)
    val finalState = slidingWindowSums.foldLeft(initialState) {
      case (previousState, measurement) =>
        val isIncreased = previousState.previousMeasurementOption.exists(measurement > _)
        State(previousMeasurementOption = Some(measurement), previousState.numberOfTimesIncreased + (if (isIncreased) 1 else 0))
    }
    println(s"number of times increased ${finalState.numberOfTimesIncreased}")
}
