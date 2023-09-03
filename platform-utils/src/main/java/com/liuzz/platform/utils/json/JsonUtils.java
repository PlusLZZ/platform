package com.liuzz.platform.utils.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.liuzz.platform.utils.array.CollectionUtils;
import com.liuzz.platform.utils.date.DatePattern;
import com.liuzz.platform.utils.string.StringUtils;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class JsonUtils {

    private static ObjectMapper objectMapper = initMapper();

    public static void init(ObjectMapper mapper){
        objectMapper = mapper;
    }

    public static ObjectMapper getInstance(){
        return objectMapper;
    }

    /**
     * 对象序列化为字符串
     * string类型数据直接返回
     * 对于空值的序列化行为建议使用注解来对类单独配置@JsonInclude
     *
     * @param obj Object
     * @return jsonString
     */
    @SneakyThrows
    public static String toJson(Object obj) {
        if (obj instanceof String) {
            return obj.toString();
        }
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * 反序列化
     *
     * @param jsonStr jsonStr
     * @param type    class
     * @param <T>     泛型
     * @return T
     */
    @SneakyThrows
    public static <T> T parse(String jsonStr, Class<T> type) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        return objectMapper.readValue(jsonStr, type);
    }

    @SneakyThrows
    public static <T> List<T> parseArray(String jsonStr, Class<T> type) {
        if (StringUtils.isBlank(jsonStr)) {
            return CollectionUtils.list();
        }
        return objectMapper.readValue(jsonStr, objectMapper.getTypeFactory().constructCollectionType(List.class, type));
    }

    /**
     * 初始化构建一个ObjectMapper
     *
     * @return ObjectMapper
     */
    public static ObjectMapper initMapper() {
        return JsonMapper.builder()
                .defaultLocale(Locale.CHINA)
                .defaultTimeZone(TimeZone.getTimeZone("GMT+8"))
                // 禁止日期的时间戳毫秒数序列化
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                // json中包含对象不存在属性时不报错
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                // 提供JDK8的日期时间支持
                .addModule(new Java8TimeModule())
                // 设置默认date类型的序列化时间格式
                .defaultDateFormat(new SimpleDateFormat(DatePattern.NORM_DATETIME_PATTERN))
                // 禁用全局设置
                .visibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE)
                // 只序列化字段
                .visibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                // 默认空值不进行序列化,谨慎使用
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .build();
    }

}
