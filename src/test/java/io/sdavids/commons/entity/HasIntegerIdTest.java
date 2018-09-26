/*
 * Copyright (c) 2017, Sebastian Davids
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.sdavids.commons.entity;

import static io.sdavids.commons.entity.HasIntegerId.integerIdFrom;
import static io.sdavids.commons.entity.HasIntegerId.nonNullIntegerId;
import static io.sdavids.commons.entity.HasIntegerId.nullIfIntegerIdNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

@SuppressWarnings("ClassCanBeStatic")
@MockitoSettings
class HasIntegerIdTest {

  @Nested
  class HasId {

    @Test
    void getIdReturnsNull(@Mock HasIntegerId hasIntegerId) {
      when(hasIntegerId.getId()).thenReturn(null);
      when(hasIntegerId.hasId()).thenCallRealMethod();

      assertThat(hasIntegerId.hasId()).isFalse();
    }

    @Test
    void getIdReturnsId(@Mock HasIntegerId hasIntegerId) {
      when(hasIntegerId.getId()).thenReturn(43342);
      when(hasIntegerId.hasId()).thenCallRealMethod();

      assertThat(hasIntegerId.hasId()).isTrue();
    }
  }

  @Nested
  class NonNullIntegerId {

    @Test
    void withNull() {
      assertThat(nonNullIntegerId(null)).isFalse();
    }

    @Test
    void getIdReturnsNull(@Mock HasIntegerId hasIntegerId) {
      when(hasIntegerId.getId()).thenReturn(null);

      assertThat(nonNullIntegerId(hasIntegerId)).isFalse();
    }

    @Test
    void getIdReturnsValue(@Mock HasIntegerId hasIntegerId) {
      when(hasIntegerId.getId()).thenReturn(34543);

      assertThat(nonNullIntegerId(hasIntegerId)).isTrue();
    }
  }

  @Nested
  class IntegerIdFrom {

    @Test
    void withNull() {
      assertThat(integerIdFrom(null)).isNull();
    }

    @Test
    void getIdReturnsNull(@Mock HasIntegerId hasIntegerId) {
      when(hasIntegerId.getId()).thenReturn(null);

      assertThat(integerIdFrom(hasIntegerId)).isNull();
    }

    @Test
    void getIdReturnsValue(@Mock HasIntegerId hasIntegerId) {
      when(hasIntegerId.getId()).thenReturn(ID);

      assertThat(integerIdFrom(hasIntegerId)).isEqualTo(ID);
    }
  }

  @Nested
  class NullIfIntegerIdNull {

    @Test
    void withNull() {
      assertThat(nullIfIntegerIdNull(null)).isNull();
    }

    @Test
    void getIdReturnsNull(@Mock HasIntegerId hasIntegerId) {
      when(hasIntegerId.getId()).thenReturn(null);

      assertThat(nullIfIntegerIdNull(hasIntegerId)).isNull();
    }

    @Test
    void getIdReturnsValue(@Mock HasIntegerId hasIntegerId) {
      when(hasIntegerId.getId()).thenReturn(ID);

      assertThat(nullIfIntegerIdNull(hasIntegerId)).isEqualTo(hasIntegerId);
    }
  }

  static final int ID = 34662;
}
