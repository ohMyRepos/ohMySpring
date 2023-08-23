package co.zhanglintc.service.impl;

import co.zhanglintc.service.AOPService;

public class AOPServiceImpl implements AOPService {
    @Override
    public void doSome() {
        System.out.println("AOPServiceImpl doSome() func run");
    }
}
