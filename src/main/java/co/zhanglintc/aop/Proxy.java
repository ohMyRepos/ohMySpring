package co.zhanglintc.aop;

import org.aspectj.lang.annotation.*;

@Aspect
public class Proxy {

    @Before(value = "execution(* co.zhanglintc.service.AOPService.doSome(..))")
    public void beforeFunc() {
        System.out.println("BEFORE a func using Aspect");
    }

    @After(value = "execution(* co.zhanglintc.service.AOPService.doSome(..))")
    public void afterFunc()  {
        System.out.println("AFTER a func using Aspect");
    }
}
