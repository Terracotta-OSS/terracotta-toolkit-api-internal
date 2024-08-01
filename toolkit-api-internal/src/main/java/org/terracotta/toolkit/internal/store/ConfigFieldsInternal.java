/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terracotta.toolkit.internal.store;

public interface ConfigFieldsInternal {
  /**
   * Local store Manager name
   */
  String LOCAL_STORE_MANAGER_NAME_NAME    = "localStoreManagerName";
  /**
   * Is blank string by default. Uses a default local store manager name per toolkit unless specified
   */
  String DEFAULT_LOCAL_STORE_MANAGER_NAME = "";
  /**
   * lock strategy used for toolkit store/cache
   */
  String LOCK_STRATEGY_NAME               = "LOCK_STRATEGY";

  public enum LOCK_STRATEGY {
    LONG_LOCK_STRATEGY, STRING_LOCK_STRATEGY, OBJECT_LOCK_STRATEGY
  }

}
