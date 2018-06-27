/*
 * Copyright (c) 2017-2018, Sebastian Davids
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

import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * A marker interface for an object having a {@code UUID} ID.
 *
 * @see UUID
 * @since 1.0
 */
@FunctionalInterface
public interface HasUuidId {

  /**
   * Returns the {@code UUID} ID from the given object.
   *
   * @param obj the object; null returns null
   * @return the ID; may be null
   * @since 1.0
   */
  static @Nullable UUID uuidIdFrom(@Nullable HasUuidId obj) {
    return obj == null ? null : obj.getId();
  }

  /**
   * Returns whether the given object has an ID.
   *
   * @param obj the object; null returns false
   * @return true if it has an ID; false otherwise
   * @see java.util.function.Predicate
   * @since 1.0
   */
  static boolean nonNullUuidId(@Nullable HasUuidId obj) {
    return !(obj == null || obj.getId() == null);
  }

  /**
   * Returns either the passed in object, or if the {@code HasUuidId} is null or its ID is null,
   * null.
   *
   * @param obj the {@code HasUuidId} to check; may be null
   * @return the passed {@code HasUuidId}, or null if it was null or its ID was null
   * @since 1.0
   */
  static @Nullable HasUuidId nullIfUuidIdNull(@Nullable HasUuidId obj) {
    return obj == null ? null : obj.getId() == null ? null : obj;
  }

  /**
   * Returns the ID of this object.
   *
   * @return the ID; may be null
   * @since 1.0
   */
  @Nullable
  UUID getId();

  /**
   * Returns whether this object has an ID.
   *
   * @return true if it has an ID; false otherwise
   * @since 1.0
   */
  default boolean hasId() {
    return getId() != null;
  }
}
