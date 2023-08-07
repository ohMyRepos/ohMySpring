package co.zhanglintc;

import co.zhanglintc.service.SpringService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String beanConfig = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(beanConfig);
        SpringService ssi = (SpringService) ctx.getBean("SpringServiceImpl");
        ssi.doSome();
    }
}
