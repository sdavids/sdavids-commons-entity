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

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

@MockitoSettings
final class HasLongIdTest {

  private static final long ID = 1L;

  @Mock private HasLongId hasLongId;

  @Test
  void hasId_withId_null() {
    when(hasLongId.getId()).thenReturn(null);
    when(hasLongId.hasId()).thenCallRealMethod();

    assertThat(hasLongId.hasId()).isFalse();
  }

  @Test
  void hasId_withId() {
    when(hasLongId.getId()).thenReturn(2L);
    when(hasLongId.hasId()).thenCallRealMethod();

    assertThat(hasLongId.hasId()).isTrue();
  }

  @Test
  void nonNullLongId_null() {
    assertThat(nonNullLongId(null)).isFalse();
  }

  @Test
  void nonNullLongId_withId_null() {
    when(hasLongId.getId()).thenReturn(null);

    assertThat(nonNullLongId(hasLongId)).isFalse();
  }

  @Test
  void nonNullLongId_withId() {
    when(hasLongId.getId()).thenReturn(3L);

    assertThat(nonNullLongId(hasLongId)).isTrue();
  }

  @Test
  void longIdFrom_null() {
    assertThat(longIdFrom(null)).isNull();
  }

  @Test
  void longIdFrom_hasLongId_returns_null() {
    when(hasLongId.getId()).thenReturn(null);

    assertThat(longIdFrom(hasLongId)).isNull();
  }

  @Test
  void longIdFrom_() {
    when(hasLongId.getId()).thenReturn(ID);

    assertThat(longIdFrom(hasLongId)).isEqualTo(ID);
  }

  @Test
  void nullIfLongIdNull_null() {
    assertThat(nullIfLongIdNull(null)).isNull();
  }

  @Test
  void nullIfLongIdNull_hasLongId_returns_null() {
    when(hasLongId.getId()).thenReturn(null);

    assertThat(nullIfLongIdNull(hasLongId)).isNull();
  }

  @Test
  void nullIfLongIdNull_() {
    when(hasLongId.getId()).thenReturn(ID);

    assertThat(nullIfLongIdNull(hasLongId)).isEqualTo(hasLongId);
  }
}
