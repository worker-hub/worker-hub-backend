package com.breakingbad.workerhub.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProfilesTest {

    @Nested
    @DisplayName("contain() 테스트")
    class ContainTest {

      @ParameterizedTest
      @ValueSource(strings = {"prd", "dev", "local"})
      @DisplayName("등록 되어 있는 profile은 true를 반환한다.")
      void contain_success(String profile) {
        assertThat(Profiles.contains(profile)).isTrue();
      }

      @ParameterizedTest
      @ValueSource(strings = {"test", "realease", "personal", "exe"})
      @DisplayName("등록 되어 있지 않은 profile은 false를 반환한다.")
      void contain_fail(String profile) {
        assertThat(Profiles.contains(profile)).isFalse();
      }

    }

    @Nested
    @DisplayName("from() 테스트")
    class FromTest {

      @Test
      @DisplayName("등록 되어 있는 profile은 해당하는 Profiles 값을 반환한다.")
      void from_success() {
        Profiles prd = Profiles.from("prd");
        assertThat(prd).isEqualTo(Profiles.PRODUCTION);

        Profiles dev = Profiles.from("dev");
        assertThat(dev).isEqualTo(Profiles.DEVELOPMENT);

        Profiles local = Profiles.from("local");
        assertThat(local).isEqualTo(Profiles.LOCAL);
      }

    }

    @Nested
    @DisplayName("toString() 테스트")
    class ToStringTest {

        @Test
        @DisplayName("Profiles.toString()은 name 값을 반환한다.")
        void toString_test() {
          String prd = Profiles.PRODUCTION.toString();
          assertThat(prd).isEqualTo("prd");

          String dev = Profiles.DEVELOPMENT.toString();
          assertThat(dev).isEqualTo("dev");

          String local = Profiles.LOCAL.toString();
          assertThat(local).isEqualTo("local");
        }

      }

}