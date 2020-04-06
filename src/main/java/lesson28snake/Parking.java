package lesson28snake;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Parking {
    public static long carParkingRoof(List<Long> cars, int k) {
        Collections.sort(cars);
        long minimum = cars.get(cars.size()-1);
        for (int i = 0; i <= cars.size()-k;i++) {
            if (minimum>cars.get(i+k-1) - cars.get(i))
                minimum = cars.get(i+k-1) - cars.get(i)+1;
        }

        //throw new IllegalArgumentException("should be implemented");
        return minimum;
    }

    public static void main(String[] args) {
        List<Long> cars = Arrays.asList(6L, 2L, 12L, 7L);
        long r = carParkingRoof(cars, 3);
        System.out.println(cars);
        System.out.println(r); // 6
    }
}