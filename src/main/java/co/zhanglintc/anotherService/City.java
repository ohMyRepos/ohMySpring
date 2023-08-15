package co.zhanglintc.anotherService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component("City")
public class City {
    @Value("Shanghai")
    private String name;
}
