import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import Bench.Helper;
import Sort.InsertionSort;
import Sort.InsertionSortPlus;
import Sort.MSDBinary;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(value = Parameterized.class)
public class MSDBinary_Test {

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameterized.Parameter
    public int[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
                {0},
                {0, 0, 0, 0},
                {4, 3, 2, 1},
                {0, 1, 1, 0},
                {1},
                {Integer.MAX_VALUE, 1, 0, Integer.MAX_VALUE/10, 9, Integer.MAX_VALUE/2,76},
                Helper.gen(1),
                Helper.gen(10),
                Helper.gen(100),
                Helper.gen(1000),
                Helper.gen(10000),
                {},
                null,
        });
    }

    private boolean isSorted(int[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        if (!isSorted){
            for (int i=0; i<a.length; i++){
                System.out.print(a[i]+" ");
            }
        }
        return isSorted;
    }

    @Test
    public void test01_checkMSDBinary() throws IOException {
        Assert.assertTrue(isSorted(MSDBinary.sort(array)));
    }


}

