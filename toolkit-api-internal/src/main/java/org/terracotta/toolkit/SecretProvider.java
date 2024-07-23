/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit;

/**
 * @author Alex Snaps
 */
public interface SecretProvider {

  public void fetchSecret();

  public byte[] getSecret();
}
