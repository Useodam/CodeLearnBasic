package sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.ex00.sample.Restaurant;

import javax.sql.DataSource;
import java.sql.Connection;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DITests {

    @Autowired
    Restaurant restaurant;

    @Autowired
    DataSource dataSource;

    @Test
    public void testCon() throws Exception{

        Connection conn = dataSource.getConnection();

        System.out.println(dataSource.getConnection());

        conn.close();
    }

    @Test
    public void testExists(){
        System.out.println(restaurant);
    }
}
