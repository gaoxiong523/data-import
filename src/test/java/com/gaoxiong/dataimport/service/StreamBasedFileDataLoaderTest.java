package com.gaoxiong.dataimport.service;

import com.gaoxiong.dataimport.service.impl.StreamBasedFileDataLoader;
import com.google.common.base.Stopwatch;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class StreamBasedFileDataLoaderTest {
    private StreamBasedFileDataLoader fileDataLoader = new StreamBasedFileDataLoader();
    private File file = new File("C:\\Users\\Administrator\\Desktop\\data\\data.txt");
    private LineCount lineCount = new LineCount() ;
    @Test
    public void load () {
        Stopwatch stopwatch = Stopwatch.createStarted();
        this.fileDataLoader.load(file,lineCount );
        stopwatch.stop();
        System.out.println(String.format("load %s data cost %s ms, TPS is %f/s",
                this.lineCount.getCount(), stopwatch.elapsed(TimeUnit.MILLISECONDS),
                this.lineCount.getCount() * 1f / stopwatch.elapsed(TimeUnit.MILLISECONDS)  * 1000));
        Assert.assertEquals(50000000, this.lineCount.getCount());
    }


    /**
     * 用于记录记录总数，单线程调用不存在并发问题
     */
    @Data
    public class LineCount implements FileDataLoader.LineCallback {
        private long count = 0;

        @Override
        public void onData(String line) {
            count ++;
        }
    }
}