/*
 * Copyright Terracotta, Inc.
 * Copyright IBM Corp. 2024, 2025
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
package org.terracotta.toolkit.internal.concurrent.locks;

import org.terracotta.toolkit.concurrent.locks.ToolkitLockType;

public enum ToolkitLockTypeInternal {
  /**
   * Exclusive write lock.
   */
  WRITE,

  /**
   * Shared read lock.
   */
  READ,
  /**
   * Exclusive write lock.
   * <p>
   * For Terracotta clustered toolkits, synchronously flushes enclosed changes to the Terracotta Server Array, blocking
   * the unlocking thread until changes have been acknowledged as committed.
   */
  SYNCHRONOUS_WRITE,
  /**
   * Shared write lock.
   * <p>
   * No-op lock level that provides no exclusion guarantees. For Terracotta clustered toolkits, does provide transaction
   * boundaries. Use at your own risk.
   */
  CONCURRENT;

  public ToolkitLockType getToolkitLockType() {
    switch (this) {
      case WRITE:
        return ToolkitLockType.WRITE;
      case READ:
        return ToolkitLockType.READ;
      case SYNCHRONOUS_WRITE:
        return ToolkitLockType.WRITE;
      case CONCURRENT:
        throw new UnsupportedOperationException();
    }
    throw new AssertionError();
  }
}
