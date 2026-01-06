package me.kosik.interwalled.ailist;

import me.kosik.interwalled.ailist.data.AIListConfiguration;
import me.kosik.interwalled.ailist.data.Interval;
import me.kosik.interwalled.ailist.utils.ListBuilder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListSplittingTest {

    final private List<Interval<String>> intervals = Arrays.asList(
        new Interval<>("CH1",   1,  11, "NIL"),
        new Interval<>("CH1",   1,  12, "NIL"),
        new Interval<>("CH1",   2,  13, "NIL"),
        new Interval<>("CH1",   2,  14, "NIL"),
        new Interval<>("CH1",   3,  15, "NIL"),

        new Interval<>("CH1",   4,  64, "NIL"),

        new Interval<>("CH1",   4,  12, "NIL"),
        new Interval<>("CH1",   5,  10, "NIL"),
        new Interval<>("CH1",   6,  12, "NIL"),
        new Interval<>("CH1",   6,  14, "NIL"),
        new Interval<>("CH1",   7,  18, "NIL"),

        new Interval<>("CH1",   8,  64, "NIL"),
        new Interval<>("CH1",   8,  62, "NIL"),
        new Interval<>("CH1",   9,  63, "NIL"),
        new Interval<>("CH1",   9,  61, "NIL"),
        new Interval<>("CH1",  10,  60, "NIL"),

        new Interval<>("CH1",  10,  33, "NIL"),
        new Interval<>("CH1",  11,  32, "NIL"),
        new Interval<>("CH1",  12,  33, "NIL"),
        new Interval<>("CH1",  12,  32, "NIL"),
        new Interval<>("CH1",  15,  33, "NIL")
    );

    @Test
    void basicSplitting() {
        final AIListConfiguration aiListConfig =
            new AIListConfiguration(10, 5, 5, 3, false);

        final AIList<String> aiList =
            ListBuilder.buildAIList(aiListConfig, intervals);

        assertEquals(21, aiList.size());
        assertEquals(2, aiList.getComponentsCount(), "Intervals ending with > 60 should be placed in a separate component.");
    }

    @Test
    void forceMinimalComponentLength() {
        final AIListConfiguration aiListConfig =
            new AIListConfiguration(10, 5, 5, 25, false);

        final AIList<String> aiList =
            ListBuilder.buildAIList(aiListConfig, intervals);

        assertEquals(21, aiList.size());
        assertEquals(1, aiList.getComponentsCount(), "All intervals should be placed in the same component.");
    }

    @Test
    void forceMaximalComponentsCount() {
    final AIListConfiguration aiListConfig =
                new AIListConfiguration(1, 5, 5, 3, false);

        final AIList<String> aiList =
            ListBuilder.buildAIList(aiListConfig, intervals);

        assertEquals(21, aiList.size());
        assertEquals(1, aiList.getComponentsCount(), "All intervals should be placed in the same component.");
    }
}
