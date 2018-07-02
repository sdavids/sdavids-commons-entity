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

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

@MockitoSettings
final class HasIntegerIdTest {

  private static final int ID = 2;

  @Mock private HasIntegerId hasIntegerId;

  @Test
  void hasId_withId_null() {
    when(hasIntegerId.getId()).thenReturn(null);
    when(hasIntegerId.hasId()).thenCallRealMethod();

    assertThat(hasIntegerId.hasId()).isFalse();
  }

  @Test
  void hasId_withId() {
    when(hasIntegerId.getId()).thenReturn(2);
    when(hasIntegerId.hasId()).thenCallRealMethod();

    assertThat(hasIntegerId.hasId()).isTrue();
  }

  @Test
  void nonNullIntegerId_null() {
    assertThat(nonNullIntegerId(null)).isFalse();
  }

  @Test
  void nonNullIntegerId_withId_null() {
    when(hasIntegerId.getId()).thenReturn(null);

    assertThat(nonNullIntegerId(hasIntegerId)).isFalse();
  }

  @Test
  void nonNullIntegerId_withId() {
    when(hasIntegerId.getId()).thenReturn(3);

    assertThat(nonNullIntegerId(hasIntegerId)).isTrue();
  }

  @Test
  void integerIdFrom_null() {
    assertThat(integerIdFrom(null)).isNull();
  }

  @Test
  void integerIdFrom_hasIntegerId_returns_null() {
    when(hasIntegerId.getId()).thenReturn(null);

    assertThat(integerIdFrom(hasIntegerId)).isNull();
  }

  @Test
  void integerIdFrom_() {
    when(hasIntegerId.getId()).thenReturn(ID);

    assertThat(integerIdFrom(hasIntegerId)).isEqualTo(ID);
  }

  @Test
  void nullIfIntegerIdNull_null() {
    assertThat(nullIfIntegerIdNull(null)).isNull();
  }

  @Test
  void nullIfIntegerIdNull_hasIntegerId_returns_null() {
    when(hasIntegerId.getId()).thenReturn(null);

    assertThat(nullIfIntegerIdNull(hasIntegerId)).isNull();
  }

  @Test
  void nullIfIntegerIdNull_() {
    when(hasIntegerId.getId()).thenReturn(ID);

    assertThat(nullIfIntegerIdNull(hasIntegerId)).isEqualTo(hasIntegerId);
  }
}
