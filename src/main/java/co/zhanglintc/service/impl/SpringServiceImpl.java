package co.zhanglintc.service.impl;

import co.zhanglintc.service.SpringService;

public class SpringServiceImpl implements SpringService {

    private String name;

    public SpringServiceImpl() {
        System.out.println("SpringServiceImpl Constructor");
    }

    public void doSome() {
        System.out.println("SpringServiceImpl run");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
