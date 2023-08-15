package co.zhanglintc.anotherService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Getter
@Component
public class Person {
    @Resource(name = "City")
    private City city;

    @Resource(name = "School")
    private School school;
}
