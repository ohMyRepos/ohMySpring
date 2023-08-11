package co.zhanglintc.service.impl;

import co.zhanglintc.anotherService.SubSchool;
import co.zhanglintc.service.SpringService;

public class SpringServiceImpl implements SpringService {

    private String name;

    private SubSchool school;

    public SpringServiceImpl() {
        System.out.println("SpringServiceImpl Constructor");
    }

    public void doSome() {
        System.out.println("SpringServiceImpl run");
        System.out.println(school.toString()
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubSchool getSchool() {
        return school;
}

    public void setSchool(SubSchool school) {
        this.school = school;
    }
}
