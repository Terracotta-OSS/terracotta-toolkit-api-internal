/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.internal;

/**
 * A terracotta L1 instance
 */
public interface TerracottaL1Instance {
  /**
   * Shut down the terracotta L1
   */
  void shutdown();
}
