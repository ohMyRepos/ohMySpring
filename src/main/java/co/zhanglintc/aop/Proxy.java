package co.zhanglintc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.LinkedList;

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

    @AfterReturning(value = "execution(* co.zhanglintc.aop.Truck.getSize(..))", returning = "o")
    public void afterReturningTruck(JoinPoint jp, Object o) {
        String methodName = jp.getSignature().getName();
        System.out.printf("JoinPoint methodName: %s\n", methodName);
        System.out.printf("return value in AOP before: %s\n", o);
        ((LinkedList<Integer>) o).add(4);
        System.out.printf("return value in AOP after: %s\n", o);
        System.out.println("AFTER RETURNING");
    }

    @Around("execution(* co.zhanglintc.aop.Truck.getTruckName(..))")
    public Object aroundTruck(ProceedingJoinPoint pjp) throws Throwable {
        System.out.printf("pjp func name: %s\n", pjp.getSignature().getName());
        System.out.println("before pjp");
        Object result = pjp.proceed();
        System.out.printf("pjp name: %s\n", result);
        System.out.println("after pjp");
        result = "theHelicopter";
        return result;
    }

    @Pointcut(value = "execution(* co.zhanglintc.aop.Truck.letBroke(..))")
    private void truckLetBrok() {}

    @AfterThrowing(value = "truckLetBrok()", throwing = "ex")
    public void afterThrowing(JoinPoint jp, Exception ex) {
        System.out.printf("afterThrowing func name: %s\n", jp.getSignature().getName());
        System.out.printf("ex message in AfterThrowing: %s\n", ex.getMessage());
    }

    @After(value = "truckLetBrok()")
    public void alwaysAfterTruck(JoinPoint jp) {
        System.out.printf("alwaysAfterTruck func name: %s\n", jp.getSignature().getName());
    }
}
