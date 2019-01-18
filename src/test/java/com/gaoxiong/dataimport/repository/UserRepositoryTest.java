package com.gaoxiong.dataimport.repository;

import com.gaoxiong.dataimport.model.User;
import com.google.common.base.Stopwatch;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.gaoxiong.dataimport.util.Utils.createRandomUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    private static final int COUNT = 10 * 10000;
    private static final int PRE_BATCH_COUNT = 2000;
    @Autowired
    private Flyway flyway;
    @Autowired
    private UserRepository userRepository;

    private List<User> users;
    private List<List<User>> batchUser;

    @Before
    public void before(){
        this.users = new ArrayList<>(COUNT);
        this.batchUser = new ArrayList<>(COUNT/PRE_BATCH_COUNT);
        List<User> preBatchUser = new ArrayList<>(PRE_BATCH_COUNT);
        this.batchUser.add(preBatchUser);
        for (int i = 0; i < COUNT; i++) {
            //创建一个user对象
            User user = createRandomUser();
            //总的集合
            users.add(user);
            //拆分后的集合
            preBatchUser.add(user);
            if (i >= preBatchUser.size()) {
                //
                batchUser.add(preBatchUser);
                //当达到拆分集合的大小后 初始化集合
                preBatchUser = new ArrayList<>(PRE_BATCH_COUNT);
            }
        }
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void save (){
        Stopwatch started = Stopwatch.createStarted();
        for (User user : users) {

        }

    }


    @Test
    public void save1(){

    }
}