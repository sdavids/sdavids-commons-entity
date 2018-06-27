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
import static org.mockito.quality.Strictness.STRICT_STUBS;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

@MockitoSettings(strictness = STRICT_STUBS)
public final class HasUuidIdTest {

  private static final UUID UUID = fromString("1833e288-f477-48f2-81da-3ce6fde82253");

  @Mock private HasUuidId hasUuidId;

  @Test
  public void hasId_withId_null() {
    when(hasUuidId.getId()).thenReturn(null);
    when(hasUuidId.hasId()).thenCallRealMethod();

    assertThat(hasUuidId.hasId()).isFalse();
  }

  @Test
  public void hasId_withId() {
    when(hasUuidId.getId()).thenReturn(UUID);
    when(hasUuidId.hasId()).thenCallRealMethod();

    assertThat(hasUuidId.hasId()).isTrue();
  }

  @Test
  public void nonNullUuidId_null() {
    assertThat(nonNullUuidId(null)).isFalse();
  }

  @Test
  public void nonNullUuidId_withId_null() {
    when(hasUuidId.getId()).thenReturn(null);

    assertThat(nonNullUuidId(hasUuidId)).isFalse();
  }

  @Test
  public void nonNullUuidId_withId() {
    when(hasUuidId.getId()).thenReturn(UUID);

    assertThat(nonNullUuidId(hasUuidId)).isTrue();
  }

  @Test
  public void uuidIdFrom_null() {
    assertThat(uuidIdFrom(null)).isNull();
  }

  @Test
  public void uuidIdFrom_hasUuidId_returns_null() {
    when(hasUuidId.getId()).thenReturn(null);

    assertThat(uuidIdFrom(hasUuidId)).isNull();
  }

  @Test
  public void uuidIdFrom_() {
    when(hasUuidId.getId()).thenReturn(UUID);

    assertThat(uuidIdFrom(hasUuidId)).isEqualTo(UUID);
  }

  @Test
  public void nullIfUuidIdNull_null() {
    assertThat(nullIfUuidIdNull(null)).isNull();
  }

  @Test
  public void nullIfUuidIdNull_hasUuidId_returns_null() {
    when(hasUuidId.getId()).thenReturn(null);

    assertThat(nullIfUuidIdNull(hasUuidId)).isNull();
  }

  @Test
  public void nullIfUuidIdNull_() {
    when(hasUuidId.getId()).thenReturn(UUID);

    assertThat(nullIfUuidIdNull(hasUuidId)).isEqualTo(hasUuidId);
  }
}
