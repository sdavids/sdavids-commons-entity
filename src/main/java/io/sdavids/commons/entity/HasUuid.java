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

import java.util.UUID;

/**
 * A marker interface for an object having a {@code UUID}.
 *
 * @see UUID
 * @since 1.0
 */
@FunctionalInterface
public interface HasUuid {

  /**
   * Returns the {@code UUID} from the given object.
   *
   * @param obj the object; null returns null
   * @return the {@code UUID}; may be null
   * @since 1.0
   */
  static UUID uuidFrom(HasUuid obj) {
    return obj == null ? null : obj.getUuid();
  }

  /**
   * Returns whether the given object has a {@code UUID}.
   *
   * @param obj the object; null returns false
   * @return true if it has a {@code UUID}; false otherwise
   * @see java.util.function.Predicate
   * @since 1.0
   */
  static boolean nonNullUuid(HasUuid obj) {
    return !(obj == null || obj.getUuid() == null);
  }

  /**
   * Returns the {@code UUID} of this object.
   *
   * @return the {@code UUID}; may be null
   * @since 1.0
   */
  UUID getUuid();

  /**
   * Returns whether this object has an {@code UUID}.
   *
   * @return true if it has an {@code UUID}; false otherwise
   * @since 1.0
   */
  default boolean hasUuid() {
    return getUuid() != null;
  }
}
