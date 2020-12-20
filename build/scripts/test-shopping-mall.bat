@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  test-shopping-mall startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and TEST_SHOPPING_MALL_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\test_shopping_mall.jar;%APP_HOME%\lib\spring-boot-starter-jooq-2.3.2.RELEASE.jar;%APP_HOME%\lib\jooq-codegen-3.13.5.jar;%APP_HOME%\lib\jooq-meta-extensions-3.13.5.jar;%APP_HOME%\lib\jooq-meta-3.13.5.jar;%APP_HOME%\lib\jooq-3.13.5.jar;%APP_HOME%\lib\liquibase-core-3.8.9.jar;%APP_HOME%\lib\spring-boot-starter-data-jpa-2.3.2.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-jdbc-2.3.2.RELEASE.jar;%APP_HOME%\lib\mysql-connector-java-8.0.21.jar;%APP_HOME%\lib\mariadb-java-client-2.6.2.jar;%APP_HOME%\lib\spring-boot-starter-freemarker-2.3.2.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-data-rest-2.3.2.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-web-2.3.2.RELEASE.jar;%APP_HOME%\lib\spring-boot-configuration-processor-2.3.2.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-validation-2.3.2.RELEASE.jar;%APP_HOME%\lib\spring-boot-devtools-2.3.2.RELEASE.jar;%APP_HOME%\lib\spring-cloud-starter-aws-2.2.2.RELEASE.jar;%APP_HOME%\lib\spring-security-jwt-1.1.0.RELEASE.jar;%APP_HOME%\lib\spring-cloud-aws-autoconfigure-2.2.2.RELEASE.jar;%APP_HOME%\lib\spring-cloud-aws-context-2.2.2.RELEASE.jar;%APP_HOME%\lib\spring-cloud-aws-core-2.2.2.RELEASE.jar;%APP_HOME%\lib\aws-java-sdk-s3-1.11.415.jar;%APP_HOME%\lib\aws-java-sdk-ec2-1.11.415.jar;%APP_HOME%\lib\aws-java-sdk-cloudformation-1.11.415.jar;%APP_HOME%\lib\aws-java-sdk-kms-1.11.415.jar;%APP_HOME%\lib\aws-java-sdk-core-1.11.415.jar;%APP_HOME%\lib\httpclient-4.5.12.jar;%APP_HOME%\lib\gson-2.8.6.jar;%APP_HOME%\lib\jackson-dataformat-xml-2.11.1.jar;%APP_HOME%\lib\spring-boot-starter-json-2.3.2.RELEASE.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.11.1.jar;%APP_HOME%\lib\springfox-data-rest-2.10.5.jar;%APP_HOME%\lib\spring-data-rest-webmvc-3.3.2.RELEASE.jar;%APP_HOME%\lib\spring-data-rest-core-3.3.2.RELEASE.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.11.1.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.11.1.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.11.1.jar;%APP_HOME%\lib\jackson-dataformat-cbor-2.11.1.jar;%APP_HOME%\lib\jmespath-java-1.11.415.jar;%APP_HOME%\lib\jackson-databind-2.11.1.jar;%APP_HOME%\lib\hibernate-core-5.4.18.Final.jar;%APP_HOME%\lib\jaxb-runtime-2.3.0.jar;%APP_HOME%\lib\jaxb-core-2.3.0.jar;%APP_HOME%\lib\jaxb-api-2.3.1.jar;%APP_HOME%\lib\java-uuid-generator-4.0.1.jar;%APP_HOME%\lib\commons-text-1.8.jar;%APP_HOME%\lib\commons-lang3-3.11.jar;%APP_HOME%\lib\commons-fileupload-1.4.jar;%APP_HOME%\lib\commons-io-2.7.jar;%APP_HOME%\lib\poi-ooxml-4.1.2.jar;%APP_HOME%\lib\poi-4.1.2.jar;%APP_HOME%\lib\commons-codec-1.14.jar;%APP_HOME%\lib\guava-29.0-jre.jar;%APP_HOME%\lib\spring-hateoas-1.1.0.RELEASE.jar;%APP_HOME%\lib\json-path-2.4.0.jar;%APP_HOME%\lib\springfox-swagger2-2.10.5.jar;%APP_HOME%\lib\springfox-swagger-ui-2.10.5.jar;%APP_HOME%\lib\jxls-jexcel-1.0.9.jar;%APP_HOME%\lib\UserAgentUtils-1.21.jar;%APP_HOME%\lib\type-parser-0.6.0.jar;%APP_HOME%\lib\h2-1.4.200.jar;%APP_HOME%\lib\activation-1.1.1.jar;%APP_HOME%\lib\reactive-streams-1.0.3.jar;%APP_HOME%\lib\spring-boot-starter-aop-2.3.2.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-2.3.2.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-logging-2.3.2.RELEASE.jar;%APP_HOME%\lib\logback-classic-1.2.3.jar;%APP_HOME%\lib\HikariCP-3.4.5.jar;%APP_HOME%\lib\spring-data-jpa-2.3.2.RELEASE.jar;%APP_HOME%\lib\springfox-swagger-common-2.10.5.jar;%APP_HOME%\lib\swagger-models-1.5.20.jar;%APP_HOME%\lib\springfox-spring-webmvc-2.10.5.jar;%APP_HOME%\lib\springfox-spring-web-2.10.5.jar;%APP_HOME%\lib\springfox-schema-2.10.5.jar;%APP_HOME%\lib\springfox-spi-2.10.5.jar;%APP_HOME%\lib\springfox-core-2.10.5.jar;%APP_HOME%\lib\spring-plugin-metadata-2.0.0.RELEASE.jar;%APP_HOME%\lib\spring-plugin-core-2.0.0.RELEASE.jar;%APP_HOME%\lib\jxls-2.6.0.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.30.jar;%APP_HOME%\lib\spring-data-commons-2.3.2.RELEASE.jar;%APP_HOME%\lib\log4j-to-slf4j-2.13.3.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.30.jar;%APP_HOME%\lib\slf4j-api-1.7.30.jar;%APP_HOME%\lib\jakarta.xml.bind-api-2.3.3.jar;%APP_HOME%\lib\jakarta.activation-api-1.2.2.jar;%APP_HOME%\lib\spring-orm-5.2.8.RELEASE.jar;%APP_HOME%\lib\spring-jdbc-5.2.8.RELEASE.jar;%APP_HOME%\lib\spring-tx-5.2.8.RELEASE.jar;%APP_HOME%\lib\spring-context-support-5.2.8.RELEASE.jar;%APP_HOME%\lib\spring-webmvc-5.2.8.RELEASE.jar;%APP_HOME%\lib\spring-boot-autoconfigure-2.3.2.RELEASE.jar;%APP_HOME%\lib\spring-boot-2.3.2.RELEASE.jar;%APP_HOME%\lib\spring-context-5.2.8.RELEASE.jar;%APP_HOME%\lib\freemarker-2.3.30.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-2.3.2.RELEASE.jar;%APP_HOME%\lib\spring-web-5.2.8.RELEASE.jar;%APP_HOME%\lib\jakarta.el-3.0.3.jar;%APP_HOME%\lib\hibernate-validator-6.1.5.Final.jar;%APP_HOME%\lib\jakarta.transaction-api-1.3.3.jar;%APP_HOME%\lib\jakarta.persistence-api-2.2.3.jar;%APP_HOME%\lib\spring-aspects-5.2.8.RELEASE.jar;%APP_HOME%\lib\bcpkix-jdk15on-1.64.jar;%APP_HOME%\lib\httpcore-4.4.13.jar;%APP_HOME%\lib\commons-jexl3-3.1.jar;%APP_HOME%\lib\commons-beanutils-1.9.3.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\jackson-annotations-2.11.1.jar;%APP_HOME%\lib\jackson-core-2.11.1.jar;%APP_HOME%\lib\woodstox-core-6.2.1.jar;%APP_HOME%\lib\stax2-api-4.2.1.jar;%APP_HOME%\lib\javax.activation-api-1.2.0.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\checker-qual-2.11.1.jar;%APP_HOME%\lib\error_prone_annotations-2.3.4.jar;%APP_HOME%\lib\j2objc-annotations-1.3.jar;%APP_HOME%\lib\json-smart-2.3.jar;%APP_HOME%\lib\swagger-annotations-1.5.20.jar;%APP_HOME%\lib\classmate-1.5.1.jar;%APP_HOME%\lib\mapstruct-1.3.1.Final.jar;%APP_HOME%\lib\commons-collections4-4.4.jar;%APP_HOME%\lib\commons-math3-3.6.1.jar;%APP_HOME%\lib\SparseBitSet-1.2.jar;%APP_HOME%\lib\poi-ooxml-schemas-4.1.2.jar;%APP_HOME%\lib\commons-compress-1.19.jar;%APP_HOME%\lib\curvesapi-1.06.jar;%APP_HOME%\lib\jxl-2.6.10.jar;%APP_HOME%\lib\stax-ex-1.7.8.jar;%APP_HOME%\lib\FastInfoset-1.2.13.jar;%APP_HOME%\lib\logback-core-1.2.3.jar;%APP_HOME%\lib\spring-aop-5.2.8.RELEASE.jar;%APP_HOME%\lib\spring-beans-5.2.8.RELEASE.jar;%APP_HOME%\lib\spring-expression-5.2.8.RELEASE.jar;%APP_HOME%\lib\spring-core-5.2.8.RELEASE.jar;%APP_HOME%\lib\hibernate-commons-annotations-5.1.0.Final.jar;%APP_HOME%\lib\jboss-logging-3.4.1.Final.jar;%APP_HOME%\lib\javassist-3.24.0-GA.jar;%APP_HOME%\lib\byte-buddy-1.10.13.jar;%APP_HOME%\lib\antlr-2.7.7.jar;%APP_HOME%\lib\jandex-2.1.3.Final.jar;%APP_HOME%\lib\dom4j-2.1.3.jar;%APP_HOME%\lib\jakarta.annotation-api-1.3.5.jar;%APP_HOME%\lib\snakeyaml-1.26.jar;%APP_HOME%\lib\tomcat-embed-websocket-9.0.37.jar;%APP_HOME%\lib\tomcat-embed-core-9.0.37.jar;%APP_HOME%\lib\jakarta.validation-api-2.0.2.jar;%APP_HOME%\lib\aspectjweaver-1.9.6.jar;%APP_HOME%\lib\bcprov-jdk15on-1.64.jar;%APP_HOME%\lib\accessors-smart-1.2.jar;%APP_HOME%\lib\classgraph-4.1.7.jar;%APP_HOME%\lib\xmlbeans-3.1.0.jar;%APP_HOME%\lib\log4j-1.2.14.jar;%APP_HOME%\lib\txw2-2.3.3.jar;%APP_HOME%\lib\istack-commons-runtime-3.0.5.jar;%APP_HOME%\lib\spring-jcl-5.2.8.RELEASE.jar;%APP_HOME%\lib\asm-5.0.4.jar;%APP_HOME%\lib\evo-inflector-1.2.2.jar;%APP_HOME%\lib\commons-collections-3.2.2.jar;%APP_HOME%\lib\log4j-api-2.13.3.jar;%APP_HOME%\lib\ion-java-1.0.2.jar;%APP_HOME%\lib\joda-time-2.8.1.jar


@rem Execute test-shopping-mall
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %TEST_SHOPPING_MALL_OPTS%  -classpath "%CLASSPATH%" com.yeji.Application %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable TEST_SHOPPING_MALL_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%TEST_SHOPPING_MALL_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
