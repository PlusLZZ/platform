package com.liuzz.platform.utils.array;

import com.liuzz.platform.utils.string.StringUtils;

import java.util.*;

public class CollectionUtils extends org.springframework.util.CollectionUtils {

    /**
     * 数组是否为空
     *
     * @param <T>   数组元素类型
     * @param array 数组
     * @return 是否为空
     */
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 对象是否为数组对象
     *
     * @param obj 对象
     * @return 是否为数组对象，如果为{@code null} 返回false
     */
    public static boolean isArray(Object obj) {
        return null != obj && obj.getClass().isArray();
    }

    /**
     * 创建一个list
     *
     * @param isLinked 是否是isLinked
     * @param values   值数组
     * @param <T>      T
     * @return List
     */
    public static <T> List<T> list(boolean isLinked, T... values) {
        if (isEmpty(values)) {
            return isLinked ? new LinkedList<>() : new ArrayList<>();
        }
        final List<T> arrayList = isLinked ? new LinkedList<>() : new ArrayList<>(values.length);
        Collections.addAll(arrayList, values);
        return arrayList;
    }

    /**
     * 创建一个ArrayList
     *
     * @param values 值数组
     * @param <T>    T
     * @return List
     */
    @SafeVarargs
    public static <T> List<T> list(T... values) {
        return list(false, values);
    }

    /**
     * 数组或集合转String
     *
     * @param obj 集合或数组对象
     * @return 数组字符串，与集合转字符串格式相同
     */
    public static String arrayToString(Object obj) {
        if (null == obj) {
            return null;
        }

        if (obj instanceof long[]) {
            return Arrays.toString((long[]) obj);
        } else if (obj instanceof int[]) {
            return Arrays.toString((int[]) obj);
        } else if (obj instanceof short[]) {
            return Arrays.toString((short[]) obj);
        } else if (obj instanceof char[]) {
            return Arrays.toString((char[]) obj);
        } else if (obj instanceof byte[]) {
            return Arrays.toString((byte[]) obj);
        } else if (obj instanceof boolean[]) {
            return Arrays.toString((boolean[]) obj);
        } else if (obj instanceof float[]) {
            return Arrays.toString((float[]) obj);
        } else if (obj instanceof double[]) {
            return Arrays.toString((double[]) obj);
        } else if (isArray(obj)) {
            // 对象数组
            try {
                return Arrays.deepToString((Object[]) obj);
            } catch (Exception ignore) {
                //ignore
            }
        }

        return obj.toString();
    }

    public static <T> String join(CharSequence delimiter, T[] array) {
        if (isEmpty(array)) return StringUtils.EMPTY;
        StringBuilder sb = new StringBuilder();
        for (T t : array) {
            sb.append(t).append(delimiter);
        }
        sb.delete(sb.length() - delimiter.length(), sb.length());
        return sb.toString();
    }

}
