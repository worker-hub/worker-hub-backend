package com.breakingbad.workerhub.core.api;

import com.breakingbad.workerhub.constant.HttpMethod;
import com.breakingbad.workerhub.constant.RequestProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class APIConfigurationTest {

    @Nested
    @DisplayName("HttpURLConnection의 설정 값을 저장하는 configuration")
    class ConfigurationTest {

        @Test
        @DisplayName("설정 값들을 저장한다.")
        void configure() throws Exception {
            // given
            HttpMethod method = HttpMethod.GET;
            RequestProperties json = RequestProperties.JSON;
            int connectionTimeout = 20;
            int readTimeout = 60;

            // when
            APIConfiguration configuration = APIConfiguration.builder()
                    .method(method)
                    .requestProperties(json)
                    .connectionTimeout(connectionTimeout)
                    .readTimeout(readTimeout)
                    .build();

            // then
            assertThat(configuration).isNotNull()
                    .hasFieldOrPropertyWithValue("method", HttpMethod.GET)
                    .hasFieldOrPropertyWithValue("requestProperties", RequestProperties.JSON)
                    .hasFieldOrPropertyWithValue("connectionTimeout", 20)
                    .hasFieldOrPropertyWithValue("readTimeout", 60);
        }

        @Test
        @DisplayName("클래스에서 제공하는 기본 값 설정 메소드.")
        void configure_default_01() throws Exception {
            APIConfiguration configuration = APIConfiguration.configure(HttpMethod.GET, RequestProperties.JSON);

            assertThat(configuration).isNotNull()
                    .hasFieldOrPropertyWithValue("method", HttpMethod.GET)
                    .hasFieldOrPropertyWithValue("requestProperties", RequestProperties.JSON);
        }

        @Test
        @DisplayName("클래스에서 제공하는 기본 값 설정 메소드.")
        void configure_default_02() throws Exception {
            APIConfiguration configuration = APIConfiguration.configure(HttpMethod.GET, RequestProperties.JSON, Map.of("key", "value"));

            assertThat(configuration).isNotNull()
                    .hasFieldOrPropertyWithValue("method", HttpMethod.GET)
                    .hasFieldOrPropertyWithValue("requestProperties", RequestProperties.JSON)
                    .hasFieldOrPropertyWithValue("params", Map.of("key", "value"));
        }

        @Nested
        @DisplayName("APIConfiguration 클래스에서 제공해주는 HttpMethod별 기본 정적 메소드")
        class StaticMethodTest {

            @Test
            @DisplayName("파라미터가 없는 configureGET() 테스트 메소드")
            void configureGET_no_param() throws Exception {
                APIConfiguration configuration = APIConfiguration.configureGET();

                assertThat(configuration).isNotNull()
                        .hasFieldOrPropertyWithValue("method", HttpMethod.GET)
                        .hasFieldOrPropertyWithValue("requestProperties", RequestProperties.JSON);
            }

            @Test
            @DisplayName("파라미터가 있는 configureGET() 테스트 메소드")
            void configureGET_has_param() throws Exception {
                APIConfiguration configuration = APIConfiguration.configureGET(Map.of("key", "value"));

                assertThat(configuration).isNotNull()
                        .hasFieldOrPropertyWithValue("method", HttpMethod.GET)
                        .hasFieldOrPropertyWithValue("requestProperties", RequestProperties.JSON)
                        .hasFieldOrPropertyWithValue("params", Map.of("key", "value"));
            }

        }

    }

}