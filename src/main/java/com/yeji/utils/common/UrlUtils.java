package com.yeji.utils.common;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * URL 유틸
 */
@Slf4j
public class UrlUtils {

    /**
     * URI 가져오기
     * @Method Name : getUri
     * @param url
     * @param data MultiValueMap
     * @return
     */
    public static URI getUri(String url, MultiValueMap<String, String> data) {

        URI uri= UriComponentsBuilder.fromHttpUrl(url)
                .queryParams(data)
                .build()
                .encode()
                .toUri();
        return uri;
    }

    /**
     * URL에서 Pathvariable 변수값만 추출해서 List<String>에 담아 리턴
     * @param url
     * @return
     */
    public static List<String> getPathvariable(String url) {
        if(StringUtils.isEmpty(url)) return Lists.newArrayList();

        Pattern p = Pattern.compile("(\\{[a-zA-Z]+_[a-zA-Z]+\\})");
        Matcher m = p.matcher(url);

        List<String> fieldList = Lists.newArrayList();
        while (m.find()){
            fieldList.add(m.group().replaceAll("\\{|}",""));
        }
        return fieldList;
    }

    /**
     * QueryString을 Map으로 변환
     * @param query
     * @return
     */
    public static Map<String, String> queryToMap(String query) {
        Map<String, String> result = new HashMap<>();
        if(StringUtils.isEmpty(query)) return result;

        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length>1) {
                result.put(pair[0], pair[1]);
            }else{
                result.put(pair[0], "");
            }
        }
        return result;
    }

    /**
     * GET 문자열 decoding 처리
     * @param obj
     * @return
     */
    public static<T> T decode(T obj) {
        if(obj == null) return obj;
        if(obj instanceof String) {
            try {
                return (T) URLDecoder.decode((String) obj, StandardCharsets.UTF_8.name());
            } catch (UnsupportedEncodingException e) {
                log.error("URLDecoding Fail: {}",obj);
                return obj;
            }
        }
        return obj;
    }
}
