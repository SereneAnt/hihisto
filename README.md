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
Benchmark               (skew)  Mode  Cnt     Score    Error  Units
Histogram.histo            0.5  avgt    5  1031.602 ± 84.165  us/op
Histogram.histo            0.6  avgt    5  1080.761 ± 30.202  us/op
Histogram.histo            0.7  avgt    5  1180.212 ± 19.614  us/op
Histogram.histo            0.8  avgt    5  1307.632 ± 14.318  us/op
Histogram.histo            0.9  avgt    5  1485.610 ± 61.687  us/op
Histogram.histo_batch4     0.5  avgt    5   899.300 ± 17.692  us/op
Histogram.histo_batch4     0.6  avgt    5   899.135 ± 15.981  us/op
Histogram.histo_batch4     0.7  avgt    5   901.883 ± 13.474  us/op
Histogram.histo_batch4     0.8  avgt    5   902.965 ± 13.124  us/op
Histogram.histo_batch4     0.9  avgt    5   902.779 ± 15.081  us/op
```

