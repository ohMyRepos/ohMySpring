package co.zhanglintc;

import co.zhanglintc.anotherService.City;
import co.zhanglintc.anotherService.Person;
import co.zhanglintc.service.AOPService;
import co.zhanglintc.service.SpringService;
import co.zhanglintc.service.impl.SpringServiceImpl;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final String beanConfig = "beans.xml";
    private static ApplicationContext ctx = null;

    @BeforeClass
    public static void setUpOnetime() {
        System.out.println("setUpOnetime...");
        ctx = new ClassPathXmlApplicationContext(beanConfig);
    }

    @AfterClass
    public static void tearDownOnetime() {
        System.out.println("tearDownOnetime...");
        ((ClassPathXmlApplicationContext) ctx).close();
    }

    @Before
    public void setUp() {
        System.out.println("setUp..");
        // ctx = new ClassPathXmlApplicationContext(beanConfig);
    }

    @After
    public void tearDown() {
        System.out.println("tearDown..");
    }

    @Test
    public void test00() {
        System.out.println("assertTrue");
        Assert.assertTrue(true);
    }

    @Test
    public void test01() {
        SpringService ss = (SpringServiceImpl) ctx.getBean("SpringServiceImpl");
        ss.doSome();
        System.out.println(ss);
    }

    @Test
    public void test02() {
        SpringService ss = ctx.getBean(SpringServiceImpl.class);
        ss.doSome();
    }

    @Test
    public void test03() {
        int numbs = ctx.getBeanDefinitionCount();
        System.out.println(String.format("%s beans here", numbs));
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(String.format("bean name: %s", name));
        }
    }

    @Test
    public void test04() {
        SpringServiceImpl ssi = ctx.getBean(SpringServiceImpl.class);
        String name = ssi.getName();
        System.out.println(name);
    }

    @Test
    public void test05() {
        SpringService ss1 = (SpringServiceImpl) ctx.getBean("SpringServiceImpl");
        SpringService ss2 = ctx.getBean(SpringServiceImpl.class);
        System.out.println(ss1);
        System.out.println(ss2);
    }

    @Test
    public void test06() {
        City city = ctx.getBean(City.class);
        Person person = ctx.getBean(Person.class);
        System.out.println(String.format("City.name: %s", city.getName()));
        System.out.println(String.format("City.school: %s", city.getSchool()));
        System.out.println(String.format("City.subSchool: %s", city.getSubSchool()));
        System.out.println(String.format("Person.city: %s", person.getCity().getName()));
    }

    @Test
    public void test07() {
        AOPService as = ctx.getBean(AOPService.class);
        System.out.printf("Wrapped type: '%s'\n", as.getClass());
        as.doSome();
    }
}
