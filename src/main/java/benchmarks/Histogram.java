package benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 3, time = 2)
@Measurement(iterations = 5, time = 2)
public class Histogram {

    private static final int SIZE = 1 << 20;
    private static final int HISTO_BINS = 256;

    private float[] data;

    @Param({"0.5", "0.6", "0.7", "0.8", "0.9"})
    float skew;

    @Setup(Level.Trial)
    public void setup() {
        Random rnd = new Random();
        data = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            float v = rnd.nextFloat();
            float t = rnd.nextFloat();
            data[i] = t < skew ? 0.12345f : v;
        }
    }

    @Benchmark
    public int[] histo() {
        int[] histo = new int[HISTO_BINS];
        for (int i = 0; i < SIZE; i++) {
            int bin = (int) (data[i] * HISTO_BINS);
            histo[bin]++;
        }
        return histo;
    }

    @Benchmark
    public int[] histo_batch4() {
        int[] tmp0 = new int[HISTO_BINS];
        int[] tmp1 = new int[HISTO_BINS];
        int[] tmp2 = new int[HISTO_BINS];
        int[] tmp3 = new int[HISTO_BINS];

        for (int i = 0; i < SIZE; ) {
            tmp0[(int) (data[i++] * HISTO_BINS)]++;
            tmp1[(int) (data[i++] * HISTO_BINS)]++;
            tmp2[(int) (data[i++] * HISTO_BINS)]++;
            tmp3[(int) (data[i++] * HISTO_BINS)]++;
        }

        int[] histo = new int[HISTO_BINS];
        for (int i = 0; i < HISTO_BINS; i++) {
            histo[i] = tmp0[i] + tmp1[i] + tmp2[i] + tmp3[i];
        }
        return histo;
    }

}
