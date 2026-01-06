package me.kosik.interwalled.ailist.benchmark;

import me.kosik.interwalled.ailist.AIList;
import me.kosik.interwalled.ailist.AIListBuilder;
import me.kosik.interwalled.ailist.AIListIterator;
import me.kosik.interwalled.ailist.data.AIListConfiguration;
import me.kosik.interwalled.ailist.data.Interval;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class ListDataStructure {

    @Param({
            "128000",
            "256000",
            "512000"
    })
    public String dataRowsCountStr;

    @Param({
            "consecutiveIntervals",
            "overlappingIntervals",
            "lastingIntervals",
            "shortPoissonIntervals",
            "mixed1Intervals",
            "mixed2Intervals",
            "mixed3Intervals",
            "mixed4Intervals"
    })
    public String dataSource;

    @Param({
            "16000",
            "32000",
            "64000"
    })
    public String queryRowsCountStr;

    @Param({
            "querySparse",
            "queryDense"
    })
    public String querySource;

    private final Map<String, ArrayList<Interval<String>>> dataSources = new HashMap<>();
    private final Map<String, ArrayList<Interval<String>>> querySources = new HashMap<>();

    @Setup
    public void setup() {
        final int rowsCount = Integer.parseInt(dataRowsCountStr);

        dataSources.put("consecutiveIntervals",     DataGenerator.consecutive(rowsCount));
        dataSources.put("overlappingIntervals",     DataGenerator.overlapping(rowsCount));
        dataSources.put("lastingIntervals",         DataGenerator.lasting(rowsCount));
        dataSources.put("shortPoissonIntervals",    DataGenerator.shortPoisson(rowsCount));
        dataSources.put("mixed1Intervals",          DataGenerator.mixed(rowsCount, 1));
        dataSources.put("mixed2Intervals",          DataGenerator.mixed(rowsCount / 2, 2));
        dataSources.put("mixed3Intervals",          DataGenerator.mixed(rowsCount / 3, 3));
        dataSources.put("mixed4Intervals",          DataGenerator.mixed(rowsCount / 4, 4));

        final int queryRowsCount = Integer.parseInt(queryRowsCountStr);

        querySources.put("querySparse",             DataGenerator.querySparse(queryRowsCount, rowsCount));
        querySources.put("queryDense",              DataGenerator.queryDense(queryRowsCount, rowsCount));
    }

    @Benchmark
    public void benchmarkQuery(final Blackhole blackhole) {
        AIListBuilder<String> aiListBuilder =
                new AIListBuilder<>(AIListConfiguration.DEFAULT, dataSources.get(dataSource));
        AIList<String> aiList = aiListBuilder.build();

        for(Interval<String> interval: querySources.get(querySource)) {
            for (AIListIterator<String> it = aiList.overlapping(interval); it.hasNext(); ) {
                Interval<String> dbInterval = it.next();
                blackhole.consume(dbInterval);
            }
        }
    }
}
