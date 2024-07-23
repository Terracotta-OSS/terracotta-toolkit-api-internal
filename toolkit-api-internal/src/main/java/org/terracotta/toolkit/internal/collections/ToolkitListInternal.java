/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.internal.collections;

import org.terracotta.toolkit.collections.ToolkitList;

/**
 * Internal api for ToolkitList
 */
public interface ToolkitListInternal<E> extends ToolkitList<E> {

  /**
   * Performs an unlocked add. Its up to the user to take locks and create transactions.
   */
  boolean unlockedAdd(E e);
}
