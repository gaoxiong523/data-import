package com.gaoxiong.dataimport.util;

import com.gaoxiong.dataimport.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author gaoxiong
 * @ClassName Utils
 * @Description TODO
 * @date 2019/1/17 15:14
 */
public class Utils {
    public static String createRandomData() {
        return toLine(createRandomUser());
    }

    public static String toLine ( User user ) {
        return new StringBuilder()
                .append(user.getUid())
                .append("#")
                .append(user.getName())
                .append("#")
                .append(new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthAt()))
                .toString();
    }

    /**
     * {@link Math.abs() 取绝对值}
     * @return
     */
    public static User createRandomUser () {
        Random random = new Random();
        return User.builder()
                .uid(Math.abs(random.nextLong()))
                .name("name-" + Math.abs(random.nextInt()))
                .birthAt(new Date())
                .build();
    }
}
