/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.feature;

import org.terracotta.toolkit.ToolkitFeature;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;

/**
 * Feature that can be used to control the management communication channel.
 */
public interface ManagementInternalFeature extends ToolkitFeature {

  /**
   * Register an object as a management service.
   *
   * @param service The object to register as a service.
   *                All methods will be made available on the L2's as potential calling targets.
   * @param executorService The executor that will be used to perform the calls on the service.
   * @return an opaque object representing this service's ID
   */
  Object registerManagementService(Object service, ExecutorService executorService);

  /**
   * Unregister a previously registered management service.
   *
   * @param serviceID an opaque object representing this service's ID
   */
  void unregisterManagementService(Object serviceID);

  /**
   * Send an object as an event to all L2's via the management channel.
   * Note that it is the responsibility of the user to make sure the event's class
   * is available on all L2's or deserialization errors will occur.
   *
   * @param event the event.
   */
  void sendEvent(Serializable event);

}

