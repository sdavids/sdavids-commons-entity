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

import static org.apiguardian.api.API.Status.STABLE;

import javax.annotation.Nullable;
import org.apiguardian.api.API;

/**
 * A marker interface for an object having a {@code Long} ID.
 *
 * @since 1.0
 */
@API(status = STABLE, since = "1.0")
@FunctionalInterface
public interface HasLongId {

  /**
   * Returns the {@code Long} ID from the given object.
   *
   * @param obj the object; {@code null} returns {@code null}
   * @return the ID; may be {@code null}
   * @since 1.0
   */
  static @Nullable Long longIdFrom(@Nullable HasLongId obj) {
    return obj == null ? null : obj.getId();
  }

  /**
   * Returns whether the given object has an ID.
   *
   * @param obj the object; null returns false
   * @return {@code true} if it has an ID; false otherwise
   * @see java.util.function.Predicate
   * @since 1.0
   */
  static boolean nonNullLongId(@Nullable HasLongId obj) {
    return !(obj == null || obj.getId() == null);
  }

  /**
   * Returns either the passed in object, or if the {@code HasLongId} is null or its ID is null,
   * null.
   *
   * @param obj the {@code HasLongId} to check; may be null
   * @return the passed {@code HasLongId}, or null if it was null or its ID was null
   * @since 1.0
   */
  static @Nullable HasLongId nullIfLongIdNull(@Nullable HasLongId obj) {
    return obj == null ? null : obj.getId() == null ? null : obj;
  }

  /**
   * Returns the ID of this object.
   *
   * @return the ID; may be null
   * @since 1.0
   */
  @Nullable
  Long getId();

  /**
   * Returns whether this object has an ID.
   *
   * @return {@code true} if it has an ID; false otherwise
   * @since 1.0
   */
  default boolean hasId() {
    return getId() != null;
  }
}
