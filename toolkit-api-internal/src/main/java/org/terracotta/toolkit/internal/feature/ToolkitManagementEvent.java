/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.feature;

import java.io.Serializable;

/**
 * A management event that can be sent by the toolkit
 *
 * @author Ludovic Orban
 */
public class ToolkitManagementEvent {

  private Serializable payload;
  private String type;

  public ToolkitManagementEvent() {
  }

  public ToolkitManagementEvent(Serializable payload, String type) {
    this.payload = payload;
    this.type = type;
  }

  public Serializable getPayload() {
    return payload;
  }

  public void setPayload(Serializable payload) {
    this.payload = payload;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
