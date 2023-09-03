package com.liuzz.platform.utils.id;

import com.liuzz.platform.utils.network.NetworkUtils;
import com.liuzz.platform.utils.network.Pid;
import com.sun.xml.internal.ws.util.UtilException;
import org.springframework.util.Assert;

public class IdUtils {

    private static Snowflake snowflake;

    public static String nextId(){
        if (snowflake == null){
            synchronized (Snowflake.class){
                if (snowflake == null){
                    snowflake = new Snowflake();
                }
            }
        }
        return snowflake.nextIdStr();
    }


    /**
     * 获取随机UUID
     *
     * @return 随机UUID
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String simpleUUID() {
        return UUID.randomUUID().toString(true);
    }

    /**
     * 获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 随机UUID
     * @since 4.1.19
     */
    public static String fastUUID() {
        return UUID.fastUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 简化的UUID，去掉了横线
     * @since 4.1.19
     */
    public static String fastSimpleUUID() {
        return UUID.fastUUID().toString(true);
    }


    /**
     * 获取数据中心ID<br>
     * 数据中心ID依赖于本地网卡MAC地址。
     * <p>
     * 此算法来自于mybatis-plus#Sequence
     * </p>
     *
     * @param maxDatacenterId 最大的中心ID
     * @return 数据中心ID
     */
    public static long getDataCenterId(long maxDatacenterId) {
        Assert.isTrue(maxDatacenterId > 0, "maxDatacenterId must be > 0");
        if(maxDatacenterId == Long.MAX_VALUE){
            maxDatacenterId -= 1;
        }
        long id = 1L;
        byte[] mac = null;
        try{
            mac = NetworkUtils.getLocalHardwareAddress();
        }catch (UtilException ignore){
            // ignore
        }
        if (null != mac) {
            id = ((0x000000FF & (long) mac[mac.length - 2])
                    | (0x0000FF00 & (((long) mac[mac.length - 1]) << 8))) >> 6;
            id = id % (maxDatacenterId + 1);
        }

        return id;
    }

    /**
     * 获取机器ID，使用进程ID配合数据中心ID生成<br>
     * 机器依赖于本进程ID或进程名的Hash值。
     *
     * <p>
     * 此算法来自于mybatis-plus#Sequence
     * </p>
     *
     * @param datacenterId 数据中心ID
     * @param maxWorkerId  最大的机器节点ID
     * @return ID
     */
    public static long getWorkerId(long datacenterId, long maxWorkerId) {
        final StringBuilder mpid = new StringBuilder();
        mpid.append(datacenterId);
        try {
            mpid.append(Pid.INSTANCE.get());
        } catch (UtilException igonre) {
            //ignore
        }
        /*
         * MAC + PID 的 hashcode 获取16个低位
         */
        return (mpid.toString().hashCode() & 0xffff) % (maxWorkerId + 1);
    }


}
