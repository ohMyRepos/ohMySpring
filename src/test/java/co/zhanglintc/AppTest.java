package co.zhanglintc;

import co.zhanglintc.anotherService.City;
import co.zhanglintc.anotherService.Person;
import co.zhanglintc.aop.Truck;
import co.zhanglintc.dao.StudentDao;
import co.zhanglintc.pojo.Student;
import co.zhanglintc.service.AOPService;
import co.zhanglintc.service.SpringService;
import co.zhanglintc.service.impl.SpringServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

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
        System.out.printf("Wrapped type is Proxy: '%s'\n", as.getClass());
        as.doSome();

        Truck truck = ctx.getBean(Truck.class);
        System.out.printf("Wrapped type is Enhancer: '%s'\n", truck.getClass());
        truck.sayHello();
        System.out.printf("return value in UnitTest %s\n", truck.getSize());
    }

    @Test
    public void test08() {
        Truck truck = ctx.getBean(Truck.class);
        System.out.printf("final name: %s\n", truck.getTruckName());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test09() {
        Truck truck = ctx.getBean(Truck.class);
        System.out.printf("message from letBroke: %s\n", truck.letBroke(false));

        thrown.expect(RuntimeException.class);
        truck.letBroke(true);
    }

    @Test
    public void test10() {
        String myBatisConfig = "myBatis.xml";
        InputStream is = getClass().getClassLoader().getResourceAsStream(myBatisConfig);
        SqlSessionFactory ssFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = ssFactory.openSession();
        List<Student> students = session.selectList("co.zhanglintc.dao.StudentDao.selectStudents");
        System.out.printf("session.selectList: %s\n", students);

        StudentDao mapper = session.getMapper(StudentDao.class);
        students = mapper.selectStudents();
        System.out.printf("mapper.selectStudents: %s\n", students);

        session.close();
    }

    @Test
    public void test11() {
        String myBatisConfig = "myBatis.xml";
        InputStream is = getClass().getClassLoader().getResourceAsStream(myBatisConfig);
        SqlSessionFactory ssFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = ssFactory.openSession(false);
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> students = mapper.selectStudents();
        System.out.printf("students before: %s\n", students);

        Student sam = new Student();
        sam.setName("sam");
        sam.setAge(22);

        mapper.insertStudent(sam);
        int id = sam.getId();
        System.out.printf("id: %s\n", id);
        students = mapper.selectStudents();
        System.out.printf("students inserted: %s\n", students);

        mapper.deleteStudentById(id);
        students = mapper.selectStudents();
        System.out.printf("students deleted: %s\n", students);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test12() {
        SqlSessionFactory ssFactory = ctx.getBean(SqlSessionFactory.class);
        SqlSession sqlSession = ssFactory.openSession();
        // StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        // List<Student> students = mapper.selectStudents();
        // System.out.printf("students before: %s\n", students);
    }
}
