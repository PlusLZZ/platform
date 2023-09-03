package com.liuzz.platform.framework.json;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.liuzz.platform.utils.date.DatePattern;
import com.liuzz.platform.utils.json.Java8TimeModule;
import com.liuzz.platform.utils.json.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Locale;

@AutoConfiguration
@Slf4j
@ConditionalOnClass(ObjectMapper.class)
@AutoConfigureBefore(JacksonAutoConfiguration.class)
public class JsonAutoConfiguration {

    /**
     * 设置时区等信息
     * 设置默认Date类型format格式
     * 配置Long类型序列化格式,避免前端精度问题
     * 设置Local系列时间序列化格式
     */
    @Bean
    @ConditionalOnMissingBean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> {
            builder.locale(Locale.CHINA);
            builder.timeZone("GMT+8");
            builder.dateFormat(new SimpleDateFormat(DatePattern.NORM_DATETIME_PATTERN));
            builder.simpleDateFormat(DatePattern.NORM_DATETIME_PATTERN);
            builder.serializerByType(Long.class, ToStringSerializer.instance);
            builder.modules(new Java8TimeModule());
            builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            builder.featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            builder.featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
            builder.visibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
            builder.visibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            builder.serializationInclusion(JsonInclude.Include.NON_NULL);
        };
    }

    @Bean
    public BeanPostProcessor objectMapperBeanPostProcessor(){
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof ObjectMapper){
                    ObjectMapper objectMapper = (ObjectMapper) bean;
                    // 注入utils
                    JsonUtils.init(objectMapper);
                }
                return bean;
            }
        };
    }

}
