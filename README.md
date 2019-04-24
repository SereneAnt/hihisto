# hihisto

Some histogram benchmarking.

Inspired by https://github.com/kuksenko/quantum2

## Requirements

 - JRE 1.8+
 - Maven 3.0+

## Build project

```bash
mvn clean install
```

## Run benchmarks

```bash
java -jar target/benchmarks.jar Histogram
```

## Benchmark results

Intel Core i7-6660U @ 2.4 GHz (Skylake), 
RAM 16 GB 1867 MHz LPDDR3

```
Benchmark               (skew)  Mode  Cnt     Score     Error  Units
Histogram.histo            0.5  avgt    5  1094.557 ± 279.512  us/op
Histogram.histo            0.6  avgt    5  1113.548 ±  75.512  us/op
Histogram.histo            0.7  avgt    5  1177.384 ±  16.978  us/op
Histogram.histo            0.8  avgt    5  1414.927 ± 157.591  us/op
Histogram.histo            0.9  avgt    5  1704.915 ± 754.830  us/op
Histogram.histo_batch4     0.5  avgt    5   945.392 ±  59.285  us/op
Histogram.histo_batch4     0.6  avgt    5   970.490 ± 538.623  us/op
Histogram.histo_batch4     0.7  avgt    5   952.637 ± 223.538  us/op
Histogram.histo_batch4     0.8  avgt    5   967.818 ± 321.982  us/op
Histogram.histo_batch4     0.9  avgt    5   964.013 ± 161.535  us/op
```

Intel Core i7 @ 3.4 Ghz (Haswell),
RAM 32 GB 1867Mhz LPDDR3
```
Benchmark               (skew)  Mode  Cnt     Score   Error  Units
Histogram.histo            0.5  avgt    2  1315.268          us/op
Histogram.histo            0.6  avgt    2  1241.816          us/op
Histogram.histo            0.7  avgt    2  1333.243          us/op
Histogram.histo            0.8  avgt    2  1493.140          us/op
Histogram.histo            0.9  avgt    2  1682.105          us/op
Histogram.histo_batch4     0.5  avgt    2   939.108          us/op
Histogram.histo_batch4     0.6  avgt    2   930.374          us/op
Histogram.histo_batch4     0.7  avgt    2   923.537          us/op
Histogram.histo_batch4     0.8  avgt    2   917.833          us/op
Histogram.histo_batch4     0.9  avgt    2   918.165          us/op
```
