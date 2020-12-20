package com.yeji.utils.common;

import com.google.common.collect.Lists;
import com.yeji.utils.common.constant.ConditionType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.CaseUtils;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.data.domain.Sort;

import java.util.*;

import static com.yeji.utils.common.constant.ConditionType.eq;
import static org.jooq.impl.DSL.value;
import static org.jooq.meta.mysql.information_schema.InformationSchema.INFORMATION_SCHEMA;

@Slf4j
public class JooqUtils {


    private static final boolean DEFAULT_IP_OPTION = false;



    /**
     * Object의 null이 아닌 값을 fieldlist의 field 들에 셋팅하여
     * 넘겨 받은 InsertSetMoreStep에 에 추가 적용
     * @param moreStep
     * @param fieldList
     * @param object
     * @param nullOption true: null 허용, false: null 미허용
     * @param emptyOption true: empty 허용, false: empty 미허용
     * @return
     */
    public static <T extends Record> InsertSetMoreStep<T> setInsertSetMoreStep(InsertSetMoreStep<T> moreStep, List<Field<?>> fieldList, Object object, boolean nullOption, boolean emptyOption){
        return setInsertSetMoreStep(moreStep, fieldList, object, nullOption, emptyOption, DEFAULT_IP_OPTION);
    }



    /**
     * Object의 null이 아닌 값을 fieldlist의 field 들에 셋팅하여
     * 넘겨 받은 InsertSetMoreStep에 에 추가 적용
     * @param moreStep
     * @param fieldList
     * @param object
     * @param nullOption true: null 허용, false: null 미허용
     * @param emptyOption true: empty 허용, false: empty 미허용
     * @param ipOption true: IP 옵션 적용, false: IP 옵션 미적용
     * @return
     */
    public static <T extends Record> InsertSetMoreStep<T> setInsertSetMoreStep(InsertSetMoreStep<T> moreStep, List<Field<?>> fieldList, Object object, boolean nullOption, boolean emptyOption, boolean ipOption ){

        if(moreStep == null) return null;

        if(fieldList != null && Objects.nonNull(object)) {
            for (Field field : fieldList) {
                Object objectValue = CommonUtils.strEmptyIfNull(emptyOption, getObjectValue(field, object));

                if (CommonUtils.isProcess(nullOption, objectValue)) {
                    if(field.getName().toLowerCase().endsWith("ip") && ipOption )
                        objectValue = setConvertIp(String.valueOf(objectValue));
                    moreStep.set(field, objectValue);
                }
            }
        }
        return moreStep;
    }

    /**
     * 오브젝트 값 가져오기
     * @param field
     * @param object
     * @return
     */
    private static Object getObjectValue(Field field, Object object){

        if(field == null && Objects.isNull(object)) return null;

        Map<String, Object> map = CommonUtils.objectToMap(object);

        String fieldCamelCaseName = CaseUtils.toCamelCase(field.getName(), false, new char[]{'_'});
        if(field.getName().startsWith("_")) fieldCamelCaseName = "_"+fieldCamelCaseName;

        return map.get(fieldCamelCaseName);
    }

    /**
     * IP를 int 바이너리 형태로 변환
     * @param ip
     * @return
     */
    public static Field<Integer> setConvertIp(String ip) {
        return DSL.function("INET_ATON", Integer.class, value(ip, String.class));
    }

    /**
     * 바이너리 형태로 변환된 IP주소를 ". . . ." 형태로 변환
     * @param field
     * @return
     */
    public static Field<String> getConvertIp(Field<?> field) {
        return DSL.function("INET_NTOA", String.class,field).as(field.getName());
    }


}