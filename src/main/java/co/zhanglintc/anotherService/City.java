package co.zhanglintc.anotherService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component("City")
public class City {
    @Value("${myCity}")
    private String name;

    @Autowired(required = true)
    @Qualifier("School")
    private School school;

    @Autowired
    private SubSchool subSchool;
}
