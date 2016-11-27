package Bench;
import java.util.concurrent.TimeUnit;

import Sort.InsertionSort;
import Sort.KStatistic;
import Sort.MergeSort;
import Sort.ShellSort;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;


@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class Shell_Bench {

    private int[] a;
    private int[] genReverse(int n){
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = n-i;
        }
        return arr;
    }
    private int[] genGood(int n){
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = i;
        }
        return arr;
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        a = Helper.gen(1000000);
    }

    @Benchmark
    public void measureShellSort(Blackhole bh) {
        bh.consume(ShellSort.sort(a));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Shell_Bench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}