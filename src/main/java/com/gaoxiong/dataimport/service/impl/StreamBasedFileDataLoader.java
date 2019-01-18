package com.gaoxiong.dataimport.service.impl;

import com.gaoxiong.dataimport.service.FileDataLoader;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author gaoxiong
 * @ClassName StreamBasedFileDataLoader
 * @Description TODO
 * @date 2019/1/17 15:49
 */
@Service
public class StreamBasedFileDataLoader implements FileDataLoader {
    @Override
    public void load ( File file, LineCallback callback ) {
        BufferedReader bufferedReader=null;
        try {
            bufferedReader = Files.newReader(file, Charsets.UTF_8);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                //没成功读取一条数据,就通过lineCallback回调就行数据处理
                callback.onData(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
