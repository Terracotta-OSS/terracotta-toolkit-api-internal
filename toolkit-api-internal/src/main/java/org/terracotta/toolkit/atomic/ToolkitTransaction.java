/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.atomic;


public interface ToolkitTransaction {

  /**
   * Commit the current transaction.
   * 
   * @see ToolkitTransactionController
   */
  public void commit();
}
