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

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

@MockitoSettings
final class HasStringIdTest {

  private static final String ID = "test1";

  @Mock private HasStringId hasStringId;

  @Test
  void hasId_withId_null() {
    when(hasStringId.getId()).thenReturn(null);
    when(hasStringId.hasId()).thenCallRealMethod();

    assertThat(hasStringId.hasId()).isFalse();
  }

  @Test
  void hasId_withId() {
    when(hasStringId.getId()).thenReturn("test2");
    when(hasStringId.hasId()).thenCallRealMethod();

    assertThat(hasStringId.hasId()).isTrue();
  }

  @Test
  void nonNullStringId_null() {
    assertThat(nonNullStringId(null)).isFalse();
  }

  @Test
  void nonNullStringId_withId_null() {
    when(hasStringId.getId()).thenReturn(null);

    assertThat(nonNullStringId(hasStringId)).isFalse();
  }

  @Test
  void nonNullStringId_withId() {
    when(hasStringId.getId()).thenReturn("test3");

    assertThat(nonNullStringId(hasStringId)).isTrue();
  }

  @Test
  void stringIdFrom_null() {
    assertThat(stringIdFrom(null)).isNull();
  }

  @Test
  void stringIdFrom_hasStringId_returns_null() {
    when(hasStringId.getId()).thenReturn(null);

    assertThat(stringIdFrom(hasStringId)).isNull();
  }

  @Test
  void stringIdFrom_() {
    when(hasStringId.getId()).thenReturn(ID);

    assertThat(stringIdFrom(hasStringId)).isEqualTo(ID);
  }

  @Test
  void nullIfStringIdNull_null() {
    assertThat(nullIfStringIdNull(null)).isNull();
  }

  @Test
  void nullIfStringIdNull_hasStringId_returns_null() {
    when(hasStringId.getId()).thenReturn(null);

    assertThat(nullIfStringIdNull(hasStringId)).isNull();
  }

  @Test
  void nullIfStringIdNull_() {
    when(hasStringId.getId()).thenReturn(ID);

    assertThat(nullIfStringIdNull(hasStringId)).isEqualTo(hasStringId);
  }
}
