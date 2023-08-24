package co.zhanglintc.aop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Truck {
    public void sayHello() {
        System.out.println("Hello from Truck!!!");
    }

    public List<Integer> getSize() {
        return new LinkedList<>(Arrays.asList(1, 2, 3));
    }

    public String getTruckName() {
        System.out.println("Truck.getName ran");
        return "theTruck";
    }

    public String letBroke(boolean let) {
        if (let) {
            throw new RuntimeException("Truck is broken");
        }
        return "Truck is not broken";
    }
}
