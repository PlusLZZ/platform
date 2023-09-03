package com.liuzz.platform.utils.web;

import com.liuzz.platform.utils.array.CollectionUtils;
import com.liuzz.platform.utils.json.JsonUtils;
import com.liuzz.platform.utils.stream.IoUtils;
import com.liuzz.platform.utils.stream.StreamUtils;
import com.liuzz.platform.utils.string.StringUtils;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ServletUtils {

    /**
     * 写入响应json
     *
     * @param response 响应
     * @param object   对象，会序列化成 JSON 字符串
     */
    public static void writeJSON(HttpServletResponse response, Object object) {
        String content = JsonUtils.toJson(object);
        write(response, content, MediaType.APPLICATION_JSON_UTF8_VALUE);
    }

    /**
     * 返回数据给客户端
     *
     * @param response    响应对象{@link HttpServletResponse}
     * @param text        返回的内容
     * @param contentType 返回的类型
     */
    public static void write(HttpServletResponse response, String text, String contentType) {
        response.setContentType(contentType);
        Writer writer = null;
        try {
            writer = response.getWriter();
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            IoUtils.close(writer);
        }
    }

    /**
     * @param request 请求
     * @return ua
     */
    public static String getUserAgent(HttpServletRequest request) {
        String ua = request.getHeader("User-Agent");
        return ua != null ? ua : "";
    }

    /**
     * 获得请求
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (!(requestAttributes instanceof ServletRequestAttributes)) {
            return null;
        }
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    /**
     * 是否是Json请求
     */
    public static boolean isJsonRequest(ServletRequest request) {
        return StringUtils.startWithIgnoreCase(request.getContentType(), MediaType.APPLICATION_JSON_VALUE);
    }

    /**
     * 获得所有请求参数
     *
     * @param request 请求对象{@link ServletRequest}
     * @return Map
     */
    public static Map<String, String> getParamMap(ServletRequest request) {
        Map<String, String> params = new HashMap<>();
        for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {

            params.put(entry.getKey(), CollectionUtils.join(StringUtils.COMMA, entry.getValue()));
        }
        return params;
    }

    @SneakyThrows
    public static byte[] getBodyBytes(HttpServletRequest request) {
        return IoUtils.read(request.getInputStream(),true).toByteArray();
    }

    public static String getBody(HttpServletRequest request) {
        try (final InputStream is = request.getInputStream()) {
            return StreamUtils.copyToString(is, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
