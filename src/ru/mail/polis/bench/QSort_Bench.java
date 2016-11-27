package Bench;
import java.util.concurrent.TimeUnit;

import Sort.InsertionSort;
import Sort.KStatistic;
import Sort.QSort;
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
public class QSort_Bench {

    private int[] a;

    private int[] genGood(int n){
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = i;
        }
        return arr;
    }

    private int[] genBad(int n){
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = i+1;
        }
        for (int i=0; i<n; i++){
            int temp = arr[i];
            arr[i] = arr[i/2];
            arr[i/2] = temp;
        }
        int index = 0;
        int index2 = 0;
        for (int i=0; i<n; i++){
            if (arr[i] == 1){
                index = i;
            }
            if (arr[i]==2){
                index2=i;
            }
        }
        int temp = arr[index];
        arr[index] = arr[index2];
        arr[index2] = temp;
        return arr;
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        a = Helper.gen(100000);
    }

    @Benchmark
    public void measureQSort(Blackhole bh) {
        bh.consume(QSort.sort(a,0,a.length-1));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(QSort_Bench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}