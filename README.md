

## Benchmarking

### ListBuilding
List building benchmark, to pick the correct way to load the data into AIListBuilder.
```
Benchmark                                     (dataSource)  (rowsCountStr)  Mode  Cnt  Score    Error  Units
ListBuilding.benchmarkBulkLoad        consecutiveIntervals          128000  avgt   20  0.002 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad   consecutiveIntervals          128000  avgt   20  0.003 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad        consecutiveIntervals          256000  avgt   20  0.007 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad   consecutiveIntervals          256000  avgt   20  0.010 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad        consecutiveIntervals          512000  avgt   20  0.018 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad   consecutiveIntervals          512000  avgt   20  0.022 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad        overlappingIntervals          128000  avgt   20  0.002 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad   overlappingIntervals          128000  avgt   20  0.003 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad        overlappingIntervals          256000  avgt   20  0.007 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad   overlappingIntervals          256000  avgt   20  0.009 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad        overlappingIntervals          512000  avgt   20  0.017 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad   overlappingIntervals          512000  avgt   20  0.023 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad            lastingIntervals          128000  avgt   20  0.003 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad       lastingIntervals          128000  avgt   20  0.003 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad            lastingIntervals          256000  avgt   20  0.007 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad       lastingIntervals          256000  avgt   20  0.010 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad            lastingIntervals          512000  avgt   20  0.016 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad       lastingIntervals          512000  avgt   20  0.022 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad       shortPoissonIntervals          128000  avgt   20  0.002 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad  shortPoissonIntervals          128000  avgt   20  0.003 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad       shortPoissonIntervals          256000  avgt   20  0.007 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad  shortPoissonIntervals          256000  avgt   20  0.009 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad       shortPoissonIntervals          512000  avgt   20  0.017 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad  shortPoissonIntervals          512000  avgt   20  0.022 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad             mixed1Intervals          128000  avgt   20  0.002 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad        mixed1Intervals          128000  avgt   20  0.003 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad             mixed1Intervals          256000  avgt   20  0.006 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad        mixed1Intervals          256000  avgt   20  0.009 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad             mixed1Intervals          512000  avgt   20  0.016 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad        mixed1Intervals          512000  avgt   20  0.021 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad             mixed2Intervals          128000  avgt   20  0.041 ±  0.001   s/op
ListBuilding.benchmarkIterativeLoad        mixed2Intervals          128000  avgt   20  0.043 ±  0.001   s/op

ListBuilding.benchmarkBulkLoad             mixed2Intervals          256000  avgt   20  0.170 ±  0.003   s/op
ListBuilding.benchmarkIterativeLoad        mixed2Intervals          256000  avgt   20  0.173 ±  0.002   s/op

ListBuilding.benchmarkBulkLoad             mixed2Intervals          512000  avgt   20  0.652 ±  0.002   s/op
ListBuilding.benchmarkIterativeLoad        mixed2Intervals          512000  avgt   20  0.668 ±  0.008   s/op

ListBuilding.benchmarkBulkLoad             mixed3Intervals          128000  avgt   20  0.164 ±  0.003   s/op
ListBuilding.benchmarkIterativeLoad        mixed3Intervals          128000  avgt   20  0.168 ±  0.002   s/op

ListBuilding.benchmarkBulkLoad             mixed3Intervals          256000  avgt   20  0.679 ±  0.009   s/op
ListBuilding.benchmarkIterativeLoad        mixed3Intervals          256000  avgt   20  0.685 ±  0.009   s/op

ListBuilding.benchmarkBulkLoad             mixed3Intervals          512000  avgt   20  2.791 ±  0.046   s/op
ListBuilding.benchmarkIterativeLoad        mixed3Intervals          512000  avgt   20  2.782 ±  0.071   s/op

ListBuilding.benchmarkBulkLoad             mixed4Intervals          128000  avgt   20  0.141 ±  0.003   s/op
ListBuilding.benchmarkIterativeLoad        mixed4Intervals          128000  avgt   20  0.137 ±  0.003   s/op

ListBuilding.benchmarkBulkLoad             mixed4Intervals          256000  avgt   20  0.579 ±  0.007   s/op
ListBuilding.benchmarkIterativeLoad        mixed4Intervals          256000  avgt   20  0.564 ±  0.008   s/op

ListBuilding.benchmarkBulkLoad             mixed4Intervals          512000  avgt   20  2.243 ±  0.026   s/op
ListBuilding.benchmarkIterativeLoad        mixed4Intervals          512000  avgt   20  2.272 ±  0.032   s/op
```

### ListDataStructure

Using ArrayList:
```
Benchmark                         (dataRowsCountStr)           (dataSource)  (queryRowsCountStr)  (querySource)  Mode  Cnt   Score    Error  Units
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                16000    querySparse  avgt   20   0.548 ±  0.029   s/op
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                16000     queryDense  avgt   20   0.591 ±  0.037   s/op
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                32000    querySparse  avgt   20   2.374 ±  0.129   s/op
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                32000     queryDense  avgt   20   2.740 ±  0.088   s/op
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                64000    querySparse  avgt   20   7.125 ±  0.209   s/op
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                64000     queryDense  avgt   20   6.444 ±  0.131   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                16000    querySparse  avgt   20   0.534 ±  0.009   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                16000     queryDense  avgt   20   0.549 ±  0.011   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                32000    querySparse  avgt   20   1.452 ±  0.014   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                32000     queryDense  avgt   20   1.516 ±  0.052   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                64000    querySparse  avgt   20   4.752 ±  0.036   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                64000     queryDense  avgt   20   5.982 ±  0.037   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                16000    querySparse  avgt   20   0.004 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                16000     queryDense  avgt   20   0.005 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                32000    querySparse  avgt   20   0.006 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                32000     queryDense  avgt   20   0.007 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                64000    querySparse  avgt   20   0.016 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                64000     queryDense  avgt   20   0.014 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                16000    querySparse  avgt   20   0.051 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                16000     queryDense  avgt   20   0.036 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                32000    querySparse  avgt   20   0.191 ±  0.003   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                32000     queryDense  avgt   20   0.124 ±  0.002   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                64000    querySparse  avgt   20   0.733 ±  0.015   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                64000     queryDense  avgt   20   0.738 ±  0.027   s/op

ListDataStructure.benchmarkQuery              128000        mixed1Intervals                16000    querySparse  avgt   20   0.306 ±  0.027   s/op
ListDataStructure.benchmarkQuery              128000        mixed1Intervals                16000     queryDense  avgt   20   0.254 ±  0.002   s/op
ListDataStructure.benchmarkQuery              128000        mixed1Intervals                32000    querySparse  avgt   20   1.066 ±  0.017   s/op
ListDataStructure.benchmarkQuery              128000        mixed1Intervals                32000     queryDense  avgt   20   1.103 ±  0.017   s/op
ListDataStructure.benchmarkQuery              128000        mixed1Intervals                64000    querySparse  avgt   20   4.269 ±  0.048   s/op
ListDataStructure.benchmarkQuery              128000        mixed1Intervals                64000     queryDense  avgt   20   3.031 ±  0.032   s/op

ListDataStructure.benchmarkQuery              128000        mixed2Intervals                16000    querySparse  avgt   20   0.748 ±  0.008   s/op
ListDataStructure.benchmarkQuery              128000        mixed2Intervals                16000     queryDense  avgt   20   0.847 ±  0.010   s/op
ListDataStructure.benchmarkQuery              128000        mixed2Intervals                32000    querySparse  avgt   20   1.570 ±  0.021   s/op
ListDataStructure.benchmarkQuery              128000        mixed2Intervals                32000     queryDense  avgt   20   2.534 ±  0.032   s/op
ListDataStructure.benchmarkQuery              128000        mixed2Intervals                64000    querySparse  avgt   20   5.915 ±  0.064   s/op
ListDataStructure.benchmarkQuery              128000        mixed2Intervals                64000     queryDense  avgt   20   7.728 ±  0.056   s/op

ListDataStructure.benchmarkQuery              128000        mixed3Intervals                16000    querySparse  avgt   20   0.937 ±  0.010   s/op
ListDataStructure.benchmarkQuery              128000        mixed3Intervals                16000     queryDense  avgt   20   1.013 ±  0.015   s/op
ListDataStructure.benchmarkQuery              128000        mixed3Intervals                32000    querySparse  avgt   20   2.482 ±  0.026   s/op
ListDataStructure.benchmarkQuery              128000        mixed3Intervals                32000     queryDense  avgt   20   2.236 ±  0.019   s/op
ListDataStructure.benchmarkQuery              128000        mixed3Intervals                64000    querySparse  avgt   20   6.627 ±  0.365   s/op
ListDataStructure.benchmarkQuery              128000        mixed3Intervals                64000     queryDense  avgt   20   6.672 ±  0.093   s/op

ListDataStructure.benchmarkQuery              128000        mixed4Intervals                16000    querySparse  avgt   20   0.991 ±  0.017   s/op
ListDataStructure.benchmarkQuery              128000        mixed4Intervals                16000     queryDense  avgt   20   1.020 ±  0.023   s/op
ListDataStructure.benchmarkQuery              128000        mixed4Intervals                32000    querySparse  avgt   20   2.515 ±  0.044   s/op
ListDataStructure.benchmarkQuery              128000        mixed4Intervals                32000     queryDense  avgt   20   2.536 ±  0.063   s/op
ListDataStructure.benchmarkQuery              128000        mixed4Intervals                64000    querySparse  avgt   20   7.295 ±  0.184   s/op
ListDataStructure.benchmarkQuery              128000        mixed4Intervals                64000     queryDense  avgt   20   7.050 ±  0.074   s/op
```

Using raw list:
```

Benchmark                         (dataRowsCountStr)           (dataSource)  (queryRowsCountStr)  (querySource)  Mode  Cnt  Score    Error  Units
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                16000    querySparse  avgt   20  0.599 ±  0.007   s/op
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                16000     queryDense  avgt   20  0.660 ±  0.006   s/op
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                32000    querySparse  avgt   20  1.064 ±  0.014   s/op
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                32000     queryDense  avgt   20  1.804 ±  0.019   s/op
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                64000    querySparse  avgt   20  3.286 ±  0.033   s/op
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                64000     queryDense  avgt   20  6.131 ±  0.049   s/op

ListDataStructure.benchmarkQuery              128000   overlappingIntervals                16000    querySparse  avgt   20  0.387 ±  0.004   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                16000     queryDense  avgt   20  0.678 ±  0.014   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                32000    querySparse  avgt   20  1.078 ±  0.010   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                32000     queryDense  avgt   20  1.884 ±  0.022   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                64000    querySparse  avgt   20  5.772 ±  0.045   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                64000     queryDense  avgt   20  6.146 ±  0.056   s/op

ListDataStructure.benchmarkQuery              128000       lastingIntervals                16000    querySparse  avgt   20  0.004 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                16000     queryDense  avgt   20  0.005 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                32000    querySparse  avgt   20  0.006 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                32000     queryDense  avgt   20  0.006 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                64000    querySparse  avgt   20  0.013 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                64000     queryDense  avgt   20  0.013 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                16000    querySparse  avgt   20  0.044 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                16000     queryDense  avgt   20  0.040 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                32000    querySparse  avgt   20  0.079 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                32000     queryDense  avgt   20  0.086 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                64000    querySparse  avgt   20  0.585 ±  0.008   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                64000     queryDense  avgt   20  0.486 ±  0.007   s/op

ListDataStructure.benchmarkQuery              128000        mixed1Intervals                16000    querySparse  avgt   20  0.282 ±  0.005   s/op
ListDataStructure.benchmarkQuery              128000        mixed1Intervals                16000     queryDense  avgt   20  0.185 ±  0.004   s/op
ListDataStructure.benchmarkQuery              128000        mixed1Intervals                32000    querySparse  avgt   20  0.820 ±  0.012   s/op
ListDataStructure.benchmarkQuery              128000        mixed1Intervals                32000     queryDense  avgt   20  0.515 ±  0.005   s/op
ListDataStructure.benchmarkQuery              128000        mixed1Intervals                64000    querySparse  avgt   20  2.698 ±  0.025   s/op
ListDataStructure.benchmarkQuery              128000        mixed1Intervals                64000     queryDense  avgt   20  1.755 ±  0.017   s/op

ListDataStructure.benchmarkQuery              128000        mixed2Intervals                16000    querySparse  avgt   20  0.620 ±  0.012   s/op
ListDataStructure.benchmarkQuery              128000        mixed2Intervals                16000     queryDense  avgt   20  0.433 ±  0.006   s/op
ListDataStructure.benchmarkQuery              128000        mixed2Intervals                32000    querySparse  avgt   20  1.141 ±  0.022   s/op
ListDataStructure.benchmarkQuery              128000        mixed2Intervals                32000     queryDense  avgt   20  1.598 ±  0.030   s/op
ListDataStructure.benchmarkQuery              128000        mixed2Intervals                64000    querySparse  avgt   20  3.549 ±  0.029   s/op
ListDataStructure.benchmarkQuery              128000        mixed2Intervals                64000     queryDense  avgt   20  4.913 ±  0.055   s/op

ListDataStructure.benchmarkQuery              128000        mixed3Intervals                16000    querySparse  avgt   20  0.628 ±  0.003   s/op
ListDataStructure.benchmarkQuery              128000        mixed3Intervals                16000     queryDense  avgt   20  1.009 ±  0.014   s/op
ListDataStructure.benchmarkQuery              128000        mixed3Intervals                32000    querySparse  avgt   20  1.909 ±  0.132   s/op
ListDataStructure.benchmarkQuery              128000        mixed3Intervals                32000     queryDense  avgt   20  2.350 ±  0.112   s/op
ListDataStructure.benchmarkQuery              128000        mixed3Intervals                64000    querySparse  avgt   20  4.784 ±  0.023   s/op
ListDataStructure.benchmarkQuery              128000        mixed3Intervals                64000     queryDense  avgt   20  8.266 ±  0.259   s/op

ListDataStructure.benchmarkQuery              128000        mixed4Intervals                16000    querySparse  avgt   20  0.742 ±  0.016   s/op
ListDataStructure.benchmarkQuery              128000        mixed4Intervals                16000     queryDense  avgt   20  0.760 ±  0.018   s/op
ListDataStructure.benchmarkQuery              128000        mixed4Intervals                32000    querySparse  avgt   20  1.792 ±  0.046   s/op
ListDataStructure.benchmarkQuery              128000        mixed4Intervals                32000     queryDense  avgt   20  1.837 ±  0.067   s/op
ListDataStructure.benchmarkQuery              128000        mixed4Intervals                64000    querySparse  avgt   20  4.813 ±  0.063   s/op
ListDataStructure.benchmarkQuery              128000        mixed4Intervals                64000     queryDense  avgt   20  5.051 ±  0.056   s/op
```

Alternative memory management
```
Benchmark                         (dataRowsCountStr)           (dataSource)  (queryRowsCountStr)  (querySource)  Mode  Cnt   Score    Error  Units
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                16000    querySparse  avgt   20   0.418 ±  0.005   s/op
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                16000     queryDense  avgt   20   0.415 ±  0.005   s/op
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                32000    querySparse  avgt   20   1.152 ±  0.013   s/op
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                32000     queryDense  avgt   20   2.054 ±  0.032   s/op
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                64000    querySparse  avgt   20   4.535 ±  0.248   s/op
ListDataStructure.benchmarkQuery              128000   consecutiveIntervals                64000     queryDense  avgt   20   6.545 ±  0.093   s/op

ListDataStructure.benchmarkQuery              128000   overlappingIntervals                16000    querySparse  avgt   20   0.417 ±  0.006   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                16000     queryDense  avgt   20   0.735 ±  0.009   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                32000    querySparse  avgt   20   1.145 ±  0.010   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                32000     queryDense  avgt   20   2.123 ±  0.013   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                64000    querySparse  avgt   20   6.257 ±  0.304   s/op
ListDataStructure.benchmarkQuery              128000   overlappingIntervals                64000     queryDense  avgt   20   6.549 ±  0.084   s/op

ListDataStructure.benchmarkQuery              128000       lastingIntervals                16000    querySparse  avgt   20   0.004 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                16000     queryDense  avgt   20   0.005 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                32000    querySparse  avgt   20   0.005 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                32000     queryDense  avgt   20   0.006 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                64000    querySparse  avgt   20   0.012 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000       lastingIntervals                64000     queryDense  avgt   20   0.012 ±  0.001   s/op

ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                16000    querySparse  avgt   20   0.044 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                16000     queryDense  avgt   20   0.027 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                32000    querySparse  avgt   20   0.169 ±  0.002   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                32000     queryDense  avgt   20   0.089 ±  0.001   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                64000    querySparse  avgt   20   0.543 ±  0.002   s/op
ListDataStructure.benchmarkQuery              128000  shortPoissonIntervals                64000     queryDense  avgt   20   0.616 ±  0.009   s/op

ListDataStructure.benchmarkQuery              128000        mixed1Intervals                16000    querySparse  avgt   20   0.307 ±  0.006   s/op
ListDataStructure.benchmarkQuery              128000        mixed1Intervals                16000     queryDense  avgt   20   0.194 ±  0.002   s/op
ListDataStructure.benchmarkQuery              128000        mixed1Intervals                32000    querySparse  avgt   20   0.557 ±  0.005   s/op
ListDataStructure.benchmarkQuery              128000        mixed1Intervals                32000     queryDense  avgt   20   0.555 ±  0.002   s/op
ListDataStructure.benchmarkQuery              128000        mixed1Intervals                64000    querySparse  avgt   20   1.825 ±  0.017   s/op
ListDataStructure.benchmarkQuery              128000        mixed1Intervals                64000     queryDense  avgt   20   1.801 ±  0.021   s/op

ListDataStructure.benchmarkQuery              128000        mixed2Intervals                16000    querySparse  avgt   20   0.510 ±  0.003   s/op
ListDataStructure.benchmarkQuery              128000        mixed2Intervals                16000     queryDense  avgt   20   0.551 ±  0.010   s/op
ListDataStructure.benchmarkQuery              128000        mixed2Intervals                32000    querySparse  avgt   20   1.595 ±  0.015   s/op
ListDataStructure.benchmarkQuery              128000        mixed2Intervals                32000     queryDense  avgt   20   1.621 ±  0.027   s/op
ListDataStructure.benchmarkQuery              128000        mixed2Intervals                64000    querySparse  avgt   20   5.216 ±  0.144   s/op
ListDataStructure.benchmarkQuery              128000        mixed2Intervals                64000     queryDense  avgt   20   5.214 ±  0.047   s/op

ListDataStructure.benchmarkQuery              128000        mixed3Intervals                16000    querySparse  avgt   20   0.671 ±  0.012   s/op
ListDataStructure.benchmarkQuery              128000        mixed3Intervals                16000     queryDense  avgt   20   0.879 ±  0.020   s/op
ListDataStructure.benchmarkQuery              128000        mixed3Intervals                32000    querySparse  avgt   20   2.349 ±  0.029   s/op
ListDataStructure.benchmarkQuery              128000        mixed3Intervals                32000     queryDense  avgt   20   2.426 ±  0.022   s/op
ListDataStructure.benchmarkQuery              128000        mixed3Intervals                64000    querySparse  avgt   20   6.387 ±  0.122   s/op
ListDataStructure.benchmarkQuery              128000        mixed3Intervals                64000     queryDense  avgt   20   7.953 ±  0.047   s/op

ListDataStructure.benchmarkQuery              128000        mixed4Intervals                16000    querySparse  avgt   20   0.977 ±  0.024   s/op
ListDataStructure.benchmarkQuery              128000        mixed4Intervals                16000     queryDense  avgt   20   1.071 ±  0.039   s/op
ListDataStructure.benchmarkQuery              128000        mixed4Intervals                32000    querySparse  avgt   20   2.824 ±  0.092   s/op
ListDataStructure.benchmarkQuery              128000        mixed4Intervals                32000     queryDense  avgt   20   3.014 ±  0.146   s/op
ListDataStructure.benchmarkQuery              128000        mixed4Intervals                64000    querySparse  avgt   20   7.836 ±  0.564   s/op
ListDataStructure.benchmarkQuery              128000        mixed4Intervals                64000     queryDense  avgt   20   9.780 ±  0.789   s/op
```