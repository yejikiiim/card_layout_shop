package com.yeji.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.findify.s3mock.S3Mock;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StopWatch;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * BASE 파일 테스트 클래스
 */
@SpringBootTest
@AutoConfigureMockMvc
//@Import(S3MockConfig.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("local")
// @Transactional
public class BaseFileTest {
    protected MockMvc mockMvc;
    protected final ObjectMapper mapper;
    protected final WebApplicationContext ctx;
    protected final S3Mock s3Mock;
    protected StopWatch stopWatch;
    protected static StopWatch totalStopWatch;

    // 테스트 JWT 데이터
    protected static String jwtData = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbktleSI6IjIxMEJGMDY1LUFDRjMtNEUxQS04QTM4LThFRjQ0Mzg1NTM5QSIsImlkIjoieXNraW0iLCJuYW1lIjoiXHVhZTQwXHVjNzIwXHVjMTFkIiwiZGVwYXJ0bWVudF9jb2RlIjoiMTUwMTIiLCJkZXBhcnRtZW50X25hbWUiOiJcdWM2ZjlcdWQ1MDRcdWI4NjBcdWQyYjhcdWM1ZDRcdWI0ZGNcdWQzMGNcdWQyYjgiLCJlbXBsb3llZV9udW1iZXIiOiIyMDE3MDAyNCIsImVtYWlsIjoieXNraW1AaXBhcmtpbmcuY28ua3IiLCJwb3NpdGlvbl9jb2RlIjoiSjEiLCJwb3NpdGlvbl9uYW1lIjoiXHViOWU0XHViMmM4XHVjODAwIiwiZHV0eV9jb2RlIjoiTDIiLCJkdXR5X25hbWUiOiJcdWQzMDBcdWM2ZDAiLCJ0ZWFtX25hbWUiOm51bGwsInBhdGgiOiIxMDAwfDEwMDAwfDE1MDExfDE1MDEyIiwicGF0aF9uYW1lIjoiXHVkMzBjXHVkMGI5XHVkMDc0XHViNzdjXHVjNmIwXHViNGRjfFImRHxcdWQ1MDRcdWI4NjBcdWQyYjhcdWM1ZDRcdWI0ZGNcdWQzMDB8XHVjNmY5XHVkNTA0XHViODYwXHVkMmI4XHVjNWQ0XHViNGRjXHVkMzBjXHVkMmI4In0.bxBABM7tSoHyxMyfp2P89rQSGS_cWpAqc-1bcGDrbrY";

    protected BaseFileTest(ObjectMapper mapper, WebApplicationContext ctx, S3Mock s3Mock) {
        this.mapper = mapper;
        this.ctx = ctx;
        this.s3Mock = s3Mock;
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))  // 필터 추가
                .alwaysDo(print())
                .build();
    }
}
