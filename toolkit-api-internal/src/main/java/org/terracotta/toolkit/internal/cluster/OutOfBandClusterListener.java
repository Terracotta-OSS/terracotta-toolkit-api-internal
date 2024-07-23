/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.internal.cluster;

import org.terracotta.toolkit.cluster.ClusterEvent;
import org.terracotta.toolkit.cluster.ClusterListener;

public interface OutOfBandClusterListener extends ClusterListener {

  boolean useOutOfBandNotification(ClusterEvent event);

}