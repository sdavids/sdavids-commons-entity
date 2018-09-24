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

import static io.sdavids.commons.entity.HasStringId.nonNullStringId;
import static io.sdavids.commons.entity.HasStringId.nullIfStringIdNull;
import static io.sdavids.commons.entity.HasStringId.stringIdFrom;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

@MockitoSettings
class HasStringIdTest {

  @Nested
  class HasId {

    @Test
    void getIdReturnsNull() {
      when(hasStringId.getId()).thenReturn(null);
      when(hasStringId.hasId()).thenCallRealMethod();

      assertThat(hasStringId.hasId()).isFalse();
    }

    @Test
    void getIdReturnsId() {
      when(hasStringId.getId()).thenReturn("ID1");
      when(hasStringId.hasId()).thenCallRealMethod();

      assertThat(hasStringId.hasId()).isTrue();
    }
  }

  @Nested
  class NonNullStringId {

    @Test
    void withNull() {
      assertThat(nonNullStringId(null)).isFalse();
    }

    @Test
    void getIdReturnsNull() {
      when(hasStringId.getId()).thenReturn(null);

      assertThat(nonNullStringId(hasStringId)).isFalse();
    }

    @Test
    void getIdReturnsValue() {
      when(hasStringId.getId()).thenReturn("ID2");

      assertThat(nonNullStringId(hasStringId)).isTrue();
    }
  }

  @Nested
  class StringIdFrom {

    @Test
    void withNull() {
      assertThat(stringIdFrom(null)).isNull();
    }

    @Test
    void getIdReturnsNull() {
      when(hasStringId.getId()).thenReturn(null);

      assertThat(stringIdFrom(hasStringId)).isNull();
    }

    @Test
    void getIdReturnsValue() {
      when(hasStringId.getId()).thenReturn(ID);

      assertThat(stringIdFrom(hasStringId)).isEqualTo(ID);
    }
  }

  @Nested
  class NullIfStringIdNull {

    @Test
    void withNull() {
      assertThat(nullIfStringIdNull(null)).isNull();
    }

    @Test
    void getIdReturnsNull() {
      when(hasStringId.getId()).thenReturn(null);

      assertThat(nullIfStringIdNull(hasStringId)).isNull();
    }

    @Test
    void getIdReturnsValue() {
      when(hasStringId.getId()).thenReturn(ID);

      assertThat(nullIfStringIdNull(hasStringId)).isEqualTo(hasStringId);
    }
  }

  static final String ID = "ID";

  @Mock HasStringId hasStringId;
}
