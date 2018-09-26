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

import static io.sdavids.commons.entity.HasUuid.nonNullUuid;
import static io.sdavids.commons.entity.HasUuid.uuidFrom;
import static java.util.UUID.fromString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.UUID;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

@SuppressWarnings("ClassCanBeStatic")
@MockitoSettings
class HasUuidTest {

  @Nested
  class HasUuid_ {

    @Test
    void getUuidReturnsNull(@Mock HasUuid hasUuid) {
      when(hasUuid.getUuid()).thenReturn(null);
      when(hasUuid.hasUuid()).thenCallRealMethod();

      assertThat(hasUuid.hasUuid()).isFalse();
    }

    @Test
    void getUuidReturnsUuid(@Mock HasUuid hasUuid) {
      when(hasUuid.getUuid()).thenReturn(fromString("706054f0-9ba4-45fd-99ad-facec5275507"));
      when(hasUuid.hasUuid()).thenCallRealMethod();

      assertThat(hasUuid.hasUuid()).isTrue();
    }
  }

  @Nested
  class NonNullUuid {

    @Test
    void withNull() {
      assertThat(nonNullUuid(null)).isFalse();
    }

    @Test
    void getUuidReturnsNull(@Mock HasUuid hasUuid) {
      when(hasUuid.getUuid()).thenReturn(null);

      assertThat(nonNullUuid(hasUuid)).isFalse();
    }

    @Test
    void getUuidReturnsValue(@Mock HasUuid hasUuid) {
      when(hasUuid.getUuid()).thenReturn(fromString("1a24a0fb-6c46-42e7-a3cf-9b1648b8e94f"));

      assertThat(nonNullUuid(hasUuid)).isTrue();
    }
  }

  @Nested
  class UuidFrom {

    @Test
    void withNull() {
      assertThat(uuidFrom(null)).isNull();
    }

    @Test
    void getUuidReturnsNull(@Mock HasUuid hasUuid) {
      when(hasUuid.getUuid()).thenReturn(null);

      assertThat(uuidFrom(hasUuid)).isNull();
    }

    @Test
    void getUuidReturnsValue(@Mock HasUuid hasUuid) {
      when(hasUuid.getUuid()).thenReturn(ID);

      assertThat(uuidFrom(hasUuid)).isEqualTo(ID);
    }
  }

  static final UUID ID = fromString("a9495cf6-5f29-49ee-8b28-72505f68b5ab");
}
