package co.zhanglintc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Proxy {
    @Before(value = "execution(* co.zhanglintc.service.AOPService.doSome(..))")
    public void beforeDoSome() {
        System.out.println("BEFORE a func using Aspect");
    }

    @After(value = "execution(* co.zhanglintc.service.AOPService.doSome(..))")
    public void afterDoSome()  {
        System.out.println("AFTER a func using Aspect");
    }

    @Before(value = "execution(* co.zhanglintc.aop.Truck.sayHello(..))")
    public void beforeTruck(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        System.out.printf("JoinPoint methodName: %s\n", methodName);
        System.out.println("BEFORE a func using Aspect");
    }

    @After(value = "execution(* co.zhanglintc.aop.Truck.sayHello(..))")
    public void afterTruck()  {
        System.out.println("AFTER a func using Aspect");
    }
}
