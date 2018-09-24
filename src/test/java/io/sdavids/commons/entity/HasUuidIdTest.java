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

import static io.sdavids.commons.entity.HasUuidId.nonNullUuidId;
import static io.sdavids.commons.entity.HasUuidId.nullIfUuidIdNull;
import static io.sdavids.commons.entity.HasUuidId.uuidIdFrom;
import static java.util.UUID.fromString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.UUID;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

@MockitoSettings
class HasUuidIdTest {

  @Nested
  class HasId {

    @Test
    void getIdReturnsNull() {
      when(hasUuidId.getId()).thenReturn(null);
      when(hasUuidId.hasId()).thenCallRealMethod();

      assertThat(hasUuidId.hasId()).isFalse();
    }

    @Test
    void getIdReturnsId() {
      when(hasUuidId.getId()).thenReturn(fromString("0a396616-a174-4840-8eff-f266fd3fca32"));
      when(hasUuidId.hasId()).thenCallRealMethod();

      assertThat(hasUuidId.hasId()).isTrue();
    }
  }

  @Nested
  class NonNullUuidId {

    @Test
    void withNull() {
      assertThat(nonNullUuidId(null)).isFalse();
    }

    @Test
    void getIdReturnsNull() {
      when(hasUuidId.getId()).thenReturn(null);

      assertThat(nonNullUuidId(hasUuidId)).isFalse();
    }

    @Test
    void getIdReturnsValue() {
      when(hasUuidId.getId()).thenReturn(fromString("f388fc77-040b-4642-a563-12022ee1508c"));

      assertThat(nonNullUuidId(hasUuidId)).isTrue();
    }
  }

  @Nested
  class UuidIdFrom {

    @Test
    void withNull() {
      assertThat(uuidIdFrom(null)).isNull();
    }

    @Test
    void getIdReturnsNull() {
      when(hasUuidId.getId()).thenReturn(null);

      assertThat(uuidIdFrom(hasUuidId)).isNull();
    }

    @Test
    void getIdReturnsValue() {
      when(hasUuidId.getId()).thenReturn(ID);

      assertThat(uuidIdFrom(hasUuidId)).isEqualTo(ID);
    }
  }

  @Nested
  class NullIfUuidIdNull {

    @Test
    void withNull() {
      assertThat(nullIfUuidIdNull(null)).isNull();
    }

    @Test
    void getIdReturnsNull() {
      when(hasUuidId.getId()).thenReturn(null);

      assertThat(nullIfUuidIdNull(hasUuidId)).isNull();
    }

    @Test
    void getIdReturnsValue() {
      when(hasUuidId.getId()).thenReturn(ID);

      assertThat(nullIfUuidIdNull(hasUuidId)).isEqualTo(hasUuidId);
    }
  }

  static final UUID ID = fromString("1833e288-f477-48f2-81da-3ce6fde82252");

  @Mock HasUuidId hasUuidId;
}
