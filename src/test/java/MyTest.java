import com.ouma.config.AnnotationPointcut;
import com.ouma.mapper.BookMapper;
import com.ouma.pojo.Books;
import com.ouma.service.BookService;
import com.ouma.service.BookServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class MyTest {
    @Test
    public void test() throws IOException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceImpl bookServiceImpl = (BookServiceImpl) applicationContext.getBean("bookServiceImpl");
        bookServiceImpl.queryAllBook();

    }
}
