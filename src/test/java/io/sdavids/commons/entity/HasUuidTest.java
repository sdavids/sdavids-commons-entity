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
import static org.mockito.quality.Strictness.STRICT_STUBS;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

@MockitoSettings(strictness = STRICT_STUBS)
public final class HasUuidTest {

  private static final UUID UUID = fromString("1833e288-f477-48f2-81da-3ce6fde82252");

  @Mock private HasUuid hasUuid;

  @Test
  public void uuidFrom_null() {
    assertThat(uuidFrom(null)).isNull();
  }

  @Test
  public void hasUuid_withId_null() {
    when(hasUuid.getUuid()).thenReturn(null);
    when(hasUuid.hasUuid()).thenCallRealMethod();

    assertThat(hasUuid.hasUuid()).isFalse();
  }

  @Test
  public void hasUuid_withId() {
    when(hasUuid.getUuid()).thenReturn(UUID);
    when(hasUuid.hasUuid()).thenCallRealMethod();

    assertThat(hasUuid.hasUuid()).isTrue();
  }

  @Test
  public void nonNullUuid_null() {
    assertThat(nonNullUuid(null)).isFalse();
  }

  @Test
  public void nonNullUuid_withId_null() {
    when(hasUuid.getUuid()).thenReturn(null);

    assertThat(nonNullUuid(hasUuid)).isFalse();
  }

  @Test
  public void nonNullUuid_withId() {
    when(hasUuid.getUuid()).thenReturn(UUID);

    assertThat(nonNullUuid(hasUuid)).isTrue();
  }

  @Test
  public void uuidFrom_hasUuid_returns_null() {
    when(hasUuid.getUuid()).thenReturn(null);

    assertThat(uuidFrom(hasUuid)).isNull();
  }

  @Test
  public void uuidFrom_() {
    when(hasUuid.getUuid()).thenReturn(UUID);

    assertThat(uuidFrom(hasUuid)).isEqualTo(UUID);
  }
}
