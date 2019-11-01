/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.cluster;

import org.terracotta.toolkit.cluster.ClusterEvent;
import org.terracotta.toolkit.cluster.ClusterListener;

public interface OutOfBandClusterListener extends ClusterListener {

  boolean useOutOfBandNotification(ClusterEvent event);

}