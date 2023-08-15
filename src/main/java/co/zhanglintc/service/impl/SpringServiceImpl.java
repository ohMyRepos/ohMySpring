package co.zhanglintc.service.impl;

import co.zhanglintc.anotherService.SubSchool;
import co.zhanglintc.service.SpringService;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SpringServiceImpl implements SpringService {

    private String name;

    private SubSchool school;

    public SpringServiceImpl() {
        System.out.println("SpringServiceImpl Constructor");
    }

    public void doSome() {
        System.out.println("SpringServiceImpl run");
        System.out.println(school.toString());
    }
}
