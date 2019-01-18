package com.gaoxiong.dataimport;

import com.google.common.base.Charsets;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.gaoxiong.dataimport.util.Utils.createRandomData;

/**
 * @author gaoxiong
 * @ClassName Test
 * @Description TODO
 * @date 2019/1/17 15:21
 */
@RunWith(JUnit4.class)
public class Test {

    @org.junit.Test
    public void test(){
        Random random = new Random();
        long l = random.nextLong();
        System.out.println(l);
        System.out.println(Math.abs(l));
        int i = random.nextInt();
        System.out.println(i);
        System.out.println(Math.abs(i));
    }
    /**
     * 生成测试数据
     * guava 的Files.newWriter 是对bufferedWriter做了一层封装
     */
    @org.junit.Test
    public void generateData(){
        Long lineSize = Long.valueOf(50000000);
        String filePath = "C:\\Users\\Administrator\\Desktop\\data\\data.txt";
        try {
//            BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = com.google.common.io.Files.newWriter(new File(filePath), Charsets.UTF_8);
            Long dataSize = lineSize;
            while (--dataSize >= 0) {
                String line = createRandomData();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                if (dataSize % 1000000 == 0) {
                    bufferedWriter.flush();
                    System.out.println(dataSize);
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @org.junit.Test
    public void test1(){
        List<String> list = new ArrayList<>(100);
        List<String> batchList = new ArrayList<>(20);
        List<List<String>> preList = new ArrayList<>(100/20);
        for (int i = 0; i < 100; i++) {
            String s = RandomStringUtils.randomAlphabetic(3);
            list.add(s);
            batchList.add(s);
            if ( batchList.size()>=20) {
                batchList = new ArrayList<>(20);
                preList.add((List<String>) ((ArrayList<String>) batchList).clone());
            }
        }
        System.out.println(list.size());
        System.out.println(preList);
    }
}
