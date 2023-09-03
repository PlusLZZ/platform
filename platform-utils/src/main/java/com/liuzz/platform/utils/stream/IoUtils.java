package com.liuzz.platform.utils.stream;

import lombok.SneakyThrows;

import java.io.*;

/**
 * 此类中的方法只负责辅助流的读写,关闭操作不负责
 * 由于流可能被多次读写
 */
public class IoUtils {

    /**
     * 关闭
     * 关闭失败不会抛出异常
     *
     * @param closeable 被关闭的对象
     */
    public static void close(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (Exception e) {
                // 静默关闭
            }
        }
    }


    /**
     * 流中读取内容，读到输出流中，读取完毕后可选是否关闭流
     * @param in 输入流
     * @param isClose 读取完毕后是否关闭输入流
     * @return ByteArrayOutputStream
     * @throws IOException IOException
     */
    public static ByteArrayOutputStream read(InputStream in,boolean isClose) throws IOException {
        ByteArrayOutputStream out;
        if (in instanceof FileInputStream){
            out = new ByteArrayOutputStream(in.available());
        }else {
            out = new ByteArrayOutputStream();
        }
        try {
            StreamUtils.copy(in,out);
        }finally {
            if (isClose)close(in);
        }
        return out;
    }

}
