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

import static io.sdavids.commons.entity.HasLongId.longIdFrom;
import static io.sdavids.commons.entity.HasLongId.nonNullLongId;
import static io.sdavids.commons.entity.HasLongId.nullIfLongIdNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

@SuppressWarnings("ClassCanBeStatic")
@MockitoSettings
class HasLongIdTest {

  @Nested
  class HasId {

    @Test
    void getIdReturnsNull(@Mock HasLongId hasLongId) {
      when(hasLongId.getId()).thenReturn(null);
      when(hasLongId.hasId()).thenCallRealMethod();

      assertThat(hasLongId.hasId()).isFalse();
    }

    @Test
    void getIdReturnsId(@Mock HasLongId hasLongId) {
      when(hasLongId.getId()).thenReturn(2363236L);
      when(hasLongId.hasId()).thenCallRealMethod();

      assertThat(hasLongId.hasId()).isTrue();
    }
  }

  @Nested
  class NonNullLongId {

    @Test
    void withNull() {
      assertThat(nonNullLongId(null)).isFalse();
    }

    @Test
    void getIdReturnsNull(@Mock HasLongId hasLongId) {
      when(hasLongId.getId()).thenReturn(null);

      assertThat(nonNullLongId(hasLongId)).isFalse();
    }

    @Test
    void getIdReturnsValue(@Mock HasLongId hasLongId) {
      when(hasLongId.getId()).thenReturn(5688344L);

      assertThat(nonNullLongId(hasLongId)).isTrue();
    }
  }

  @Nested
  class LongIdFrom {

    @Test
    void withNull() {
      assertThat(longIdFrom(null)).isNull();
    }

    @Test
    void getIdReturnsNull(@Mock HasLongId hasLongId) {
      when(hasLongId.getId()).thenReturn(null);

      assertThat(longIdFrom(hasLongId)).isNull();
    }

    @Test
    void getIdReturnsValue(@Mock HasLongId hasLongId) {
      when(hasLongId.getId()).thenReturn(ID);

      assertThat(longIdFrom(hasLongId)).isEqualTo(ID);
    }
  }

  @Nested
  class NullIfLongIdNull {

    @Test
    void withNull() {
      assertThat(nullIfLongIdNull(null)).isNull();
    }

    @Test
    void getIdReturnsNull(@Mock HasLongId hasLongId) {
      when(hasLongId.getId()).thenReturn(null);

      assertThat(nullIfLongIdNull(hasLongId)).isNull();
    }

    @Test
    void getIdReturnsValue(@Mock HasLongId hasLongId) {
      when(hasLongId.getId()).thenReturn(ID);

      assertThat(nullIfLongIdNull(hasLongId)).isEqualTo(hasLongId);
    }
  }

  static final long ID = 347734374L;
}
