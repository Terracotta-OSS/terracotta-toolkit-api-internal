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
package org.terracotta.toolkit.internal;

import org.terracotta.toolkit.Toolkit;

/**
 * Properties of a {@link Toolkit} instance
 */
public interface ToolkitProperties {
  /**
   * Returns an integer for the given property in this properties object.
   * <p>
   * If the property is found and is successfully parsed as an {@code Integer} value then the parsed integer value is
   * returned. Otherwise {@code null} is returned.
   * 
   * @param key the property key.
   * @return the resultant {@code Integer} value
   */
  Integer getInteger(String key);

  /**
   * Returns an integer for the given property in this properties object.
   * <p>
   * If the property is found and is successfully parsed as an {@code Integer} value then the parsed integer value is
   * returned. Otherwise the default value is returned.
   * 
   * @param key the property key.
   * @return the resultant {@code Integer} value
   */
  Integer getInteger(String key, Integer defaultValue);

  /**
   * Returns a long for the given property in this properties object.
   * <p>
   * If the property is found and is successfully parsed as a {@code Long} value then the parsed long value is returned.
   * Otherwise {@code null} is returned.
   * 
   * @param key the property key.
   * @return the resultant {@code Long} value
   */
  Long getLong(String key);

  /**
   * Returns a long for the given property in this properties object.
   * <p>
   * If the property is found and is successfully parsed as a {@code Long} value then the parsed long value is returned.
   * Otherwise the default value is returned.
   * 
   * @param key the property key.
   * @return the resultant {@code Long} value
   */
  Long getLong(String key, Long defaultValue);

  /**
   * Returns a boolean for the given property in this properties object.
   * <p>
   * If the property is found and is equal (ignoring case) to {@code true} then {@code Boolean.TRUE} is returned.
   * Otherwise {@code Boolean.FALSE} is returned.
   * 
   * @param key the property key.
   * @return the resultant Boolean value
   */
  Boolean getBoolean(String key);

  /**
   * Returns a boolean for the given property in this properties object.
   * <p>
   * If the property is not found then the default value is returned;
   * <p>
   * Otherwise if the property is equal (ignoring case) to {@code true} then {@code Boolean.TRUE} is returned, if not
   * then {@code Boolean.FALSE} is returned.
   * 
   * @param key the property key.
   * @return the resultant Boolean value
   */
  Boolean getBoolean(String key, Boolean defaultValue);

  /**
   * Searches for the property with the specified key in this properties object.
   * <p>
   * If the property is not found then {@code null} is returned.
   * 
   * @param key the property key.
   * @return the value in this properties object with the specified key.
   */
  String getProperty(String key);

  /**
   * Searches for the property with the specified key in this properties object.
   * <p>
   * If the property is not found then the default value is returned
   * 
   * @param key the property key.
   * @return the value in this properties object with the specified key.
   */
  String getProperty(String key, String defaultValue);

  /**
   * Sets the given property.
   * <p>
   * The given system property is set to the supplied string value.
   * 
   * @param key the property key
   * @param value the string to set the property to
   * @throws NullPointerException if the key or value is {@code null}
   */
  void setProperty(String key, String value) throws NullPointerException;
}
