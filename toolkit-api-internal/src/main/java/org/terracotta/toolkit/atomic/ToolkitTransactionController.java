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
package org.terracotta.toolkit.atomic;

import org.terracotta.toolkit.ToolkitFeature;
import org.terracotta.toolkit.concurrent.locks.ToolkitLock;

/**
 * A Controller for {@link ToolkitTransaction}. <br>
 * Write Locks taken inside the toolkit transaction will be released only after the transaction is commited. Accessing
 * multiple locks or Locked Objects inside a transaction should be done in a fixed order in order to avoid deadlocks.
 */

public interface ToolkitTransactionController extends ToolkitFeature {

  /**
   * Creates a ToolkitTransaction. This transaction will be current transaction up to
   * {@link ToolkitTransaction#commit()} is called by the same thread. User should use {@link ToolkitLock} with
   * {@link ToolkitTransaction} for visibility.
   */
  public ToolkitTransaction beginTransaction(ToolkitTransactionType type);

}
