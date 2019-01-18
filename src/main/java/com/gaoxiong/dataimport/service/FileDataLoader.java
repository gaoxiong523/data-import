package com.gaoxiong.dataimport.service;

import java.io.File;

/**
 * @author gaoxiong
 * @ClassName FileDataLoader
 * @Description 读取文件 返回 数据
 * {@code
 * public interface FileDataLoader {
 *      List<String> load(File file);
 *  }
 * }
 * 上诉接口看起来没问题, 但如果文件很大的时候,机器的内存就会被吃完,从而导致内存溢出
 * 改进如下
 * 面对大数据加载，优先使用 Stream 方式，即一边读取一边处理，而不是一次性加载至内存中。
 * 那我们如何调整我们的接口呢？回调，是的。需要使用回调进行流式处理。
 * 新接口与之前最大的区别在于，load 不是直接返回所有数据，而是每读取一行数据，就通过 LineCallback 对数据进行处理。
 * @date 2019/1/17 15:41
 */
public interface FileDataLoader {
    void load( File file,LineCallback callback );

    interface LineCallback {
        void onData(String line);
    }
}
