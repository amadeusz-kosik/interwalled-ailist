package me.kosik.interwalled

import me.kosik.interwalled.ailist.data.{AIListConfiguration, Interval}
import org.scalatest.Assertion
import org.scalatest.matchers.should.Matchers

import scala.jdk.CollectionConverters._


package object ailist {

  object AIListTestHelper extends Matchers {

    def buildList[T](intervals: Seq[Interval[T]], aiListConfig: AIListConfiguration = AIListConfiguration.DEFAULT): AIList[T] = {
      val listBuilder = new AIListBuilder[T](aiListConfig)

      intervals.foreach(interval => listBuilder.put(interval))
      listBuilder.build()
    }

    def buildResult[T, U](aiList: AIList[T], otherList: Seq[Interval[U]]): JoinResult[T, U] = {
      val intervalsPairs = otherList.flatMap { rightInterval =>
        aiList.overlapping(rightInterval).asScala.map(leftInterval => IntervalsPair(leftInterval, rightInterval))
      }
      JoinResult(intervalsPairs)
    }

    def buildExpected[T, U](leftIntervals: Seq[Interval[T]], rightIntervals: Seq[Interval[U]]): JoinResult[T, U] = {
      def isOverlapping(lhs: Interval[T], rhs: Interval[U]): Boolean = lhs.to >= rhs.from && rhs.to >= lhs.from

      JoinResult(leftIntervals.flatMap { leftInterval =>
        rightIntervals
          .filter { rightInterval => isOverlapping(leftInterval, rightInterval)}
          .map(rightInterval => IntervalsPair(leftInterval, rightInterval))
      })
    }

    def assertEqual[T, U](expected: JoinResult[T, U], actual: JoinResult[T, U]): Assertion = {
      actual.intervalPairs.length shouldEqual expected.intervalPairs.length
      actual.intervalPairs.toSet should contain theSameElementsAs expected.intervalPairs.toSet
    }
  }

  case class IntervalsPair[T, U](leftInterval: Interval[T], rightInterval: Interval[U])

  case class JoinResult[T, U](intervalPairs: Seq[IntervalsPair[T, U]])
}
