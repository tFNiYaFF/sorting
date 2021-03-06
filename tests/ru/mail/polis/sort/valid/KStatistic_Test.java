import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import Bench.Helper;
import Sort.InsertionSort;
import Sort.InsertionSortPlus;
import Sort.KStatistic;
import Sort.KStatisticPlus;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(value = Parameterized.class)
public class KStatistic_Test {

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
                {Integer.MAX_VALUE, 0, 0, Integer.MIN_VALUE},
                Helper.gen(1),
                Helper.gen(10),
                Helper.gen(100),
                Helper.gen(1000),
                Helper.gen(10000),
                {},
                null,
        });
    }

    private boolean isTrue(int key) {
        if(array==null){
            return true;
        }
        if (3>array.length-1){
            return true;
        }
        Arrays.sort(array);
        if (array[3]==key){
            return true;
        }
        return false;
    }

    @Test
    public void test01_checkKStatistic() throws IOException {
        Assert.assertTrue(isTrue(KStatistic.GetKStatistic(array,3, new Random())));
    }


    @Test
    public void test02_checkKStatisticPlus() throws IOException {
        Assert.assertTrue(isTrue(KStatisticPlus.GetKStatistic(array, 3)));
    }

}
