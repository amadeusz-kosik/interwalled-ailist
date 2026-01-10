package me.kosik.interwalled.ailist;

import me.kosik.interwalled.ailist.model.Interval;
import me.kosik.interwalled.ailist.model.IntervalsPair;
import me.kosik.interwalled.ailist.generator.DataGenerators;
import me.kosik.interwalled.ailist.utils.ListBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;


public class CorrectnessTest {

    /* Each correctness test asserts that list stores exactly the same elements as they
     *  were put into the list: no duplication, no data loss. */

    @Test
    void noOverlappingIntervals() {
        final List<Interval<String>> lhs = DataGenerators.consecutiveIntervals(1000);
        final List<Interval<String>> rhs = DataGenerators.consecutiveIntervals(2000, 1000);

        final AIList<String> aiList = ListBuilder.buildAIList(lhs);

        final List<IntervalsPair<String, String>> actual   = ListBuilder.buildActual(aiList, rhs);
        final List<IntervalsPair<String, String>> expected = ListBuilder.buildExpected(lhs, rhs);

        assertIterableEquals(expected, actual);
    }


    @Test
    void oneToOneIntervals() {
        final List<Interval<String>> lhs = DataGenerators.consecutiveIntervals(1000);
        final List<Interval<String>> rhs = DataGenerators.consecutiveIntervals(1000);

        final AIList<String> aiList = ListBuilder.buildAIList(lhs);

        final List<IntervalsPair<String, String>> actual   = ListBuilder.buildActual(aiList, rhs);
        final List<IntervalsPair<String, String>> expected = ListBuilder.buildExpected(lhs, rhs);

        assertIterableEquals(expected, actual);
    }

    @Test
    void allToOneIntervals() {
        final List<Interval<String>> lhs = DataGenerators.consecutiveIntervals(1000);
        final List<Interval<String>> rhs = DataGenerators.consecutiveIntervals(0, 1000, 1);

        final AIList<String> aiList = ListBuilder.buildAIList(lhs);

        final List<IntervalsPair<String, String>> actual   = ListBuilder.buildActual(aiList, rhs);
        final List<IntervalsPair<String, String>> expected = ListBuilder.buildExpected(lhs, rhs);

        assertIterableEquals(expected, actual);
    }

    @Test
    void oneToAllIntervals() {
        final List<Interval<String>> lhs = DataGenerators.consecutiveIntervals(0, 1001, 1);
        final List<Interval<String>> rhs = DataGenerators.consecutiveIntervals(1000);

        final AIList<String> aiList = ListBuilder.buildAIList(lhs);

        final List<IntervalsPair<String, String>> actual   = ListBuilder.buildActual(aiList, rhs);
        final List<IntervalsPair<String, String>> expected = ListBuilder.buildExpected(lhs, rhs);

        assertIterableEquals(expected, actual);
    }
}


//
//    test("Data validation: 1 right interval matching all left intervals, uneven intervals distribution.") {
//        val lhs = ((1 to 100) map { i =>
//                new Interval("CH1", i, i + 1, "L")
//        }) ++ ((1 to 100) map { i =>
//                new Interval("CH1", i, i + 50, "L")
//        })
//
//        val rhs = new Interval("CH1", 0, 10000, "R") :: Nil
//
//        val aiList = buildList(lhs)
//        val actual = buildResult(aiList, rhs)
//        val expected = buildExpected(lhs, rhs)
//
//        assertEqual(expected, actual)
//    }
//
//    test("Data validation: all to all matching.") {
//        val lhs = (1 to 100) map { i => new Interval("CH1", i, 1000 + i, "L")}
//        val rhs = (1 to 100) map { i => new Interval("CH1", i, 1000 + i, "R")}
//
//        val aiList = buildList(lhs)
//        val actual = buildResult(aiList, rhs)
//        val expected = buildExpected(lhs, rhs)
//
//        assertEqual(expected, actual)
//    }
//
//    test("Data validation: sparse-16 sample.") {
//        val lhs = (1 to   6) map { i => new Interval("CH1", i * 16, i * 16, "L")}
//        val rhs = (1 to 100) map { i => new Interval("CH1", i, i, "R")}
//
//        val aiList = buildList(lhs)
//        val actual = buildResult(aiList, rhs)
//        val expected = buildExpected(lhs, rhs)
//
//        assertEqual(expected, actual)
//    }
//}
