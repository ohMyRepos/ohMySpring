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
}
