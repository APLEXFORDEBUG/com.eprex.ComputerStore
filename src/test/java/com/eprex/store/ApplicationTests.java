package com.eprex.store;

import com.eprex.store.entity.User;
import com.eprex.store.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private DataSource dataSource;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {

    }

    @Test
    void getDataSource() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Test
    void testUser(){
        User user = userMapper.findByUserName("eprex");
        System.out.println(user);
    }

}
