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
package org.terracotta.toolkit.internal;

import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.ToolkitFeature;
import org.terracotta.toolkit.ToolkitFeatureTypeInternal;
import org.terracotta.toolkit.concurrent.locks.ToolkitLock;
import org.terracotta.toolkit.internal.concurrent.locks.ToolkitLockTypeInternal;

public interface ToolkitInternal extends Toolkit {

  /**
   * Get a lock with specified internal lock type
   */
  ToolkitLock getLock(String name, ToolkitLockTypeInternal lockType);

  /**
   * Registers a {@link Runnable} that will be executed before the Toolkit shuts down
   */
  void registerBeforeShutdownHook(Runnable hook);

  /**
   * Waits until all transactions are complete
   */
  void waitUntilAllTransactionsComplete();

  /**
   * Returns a new {@link ToolkitLogger} for the given name
   */
  ToolkitLogger getLogger(String name);

  /**
   * Return the uuid of this client used in mbean names
   */
  String getClientUUID();

  /**
   * Return properties of this toolkit
   */
  ToolkitProperties getProperties();

  /**
   * Returns the {@link ToolkitFeature} implementation identified by <code>type</code> associated with the
   * {@link Toolkit}.
   * 
   * @param type the type identifying the feature.
   * @return returns the feature identified by <code>type</code>.
   * @see ToolkitFeatureTypeInternal
   */
  <T extends ToolkitFeature> T getFeature(ToolkitFeatureTypeInternal<T> type);
}
