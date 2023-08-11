package co.zhanglintc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.zhanglintc.service.SpringService;
import co.zhanglintc.service.impl.SpringServiceImpl;

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
        System.out.println(numbs);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
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
}
