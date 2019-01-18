package com.gaoxiong.dataimport.service.impl;

import com.gaoxiong.dataimport.service.UserParse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.gaoxiong.dataimport.util.Utils.createRandomData;

public class CommonUserParseTest {
    private static final int COUNT = 100*10000;
    private List<String> data;
    private UserParse userParse;

    @Before
    public void setUp(){
        this.data = createTestData(COUNT);
        this.userParse = new CommonUserParse();
    }

    private List<String> createTestData ( int count ) {
        List<String> datas = new ArrayList<>(count);
        for (int i = 0;i<count;i++) {
            datas.add(createRandomData());
        }
        return datas;
    }


    @Test
    public void parse () {
        com.google.common.base.Stopwatch stopwatch = com.google.common.base.Stopwatch.createStarted();
        for (String line : data) {
            userParse.parse(line);
        }
        stopwatch.stop();
        System.out.println(String.format("parse %s data cost %s ms, TPS is %f/s",
                COUNT, stopwatch.elapsed(TimeUnit.MILLISECONDS),
                COUNT * 1f / stopwatch.elapsed(TimeUnit.MILLISECONDS)  * 1000));
    }

}