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

/**
 * Logging interface implemented by loggers provided by the toolkit.
 */
public interface ToolkitLogger {
  /**
   * Log a message at the debug level.
   * 
   * @param message message to log
   */
  void debug(Object message);

  /**
   * Log a message at the debug level, including the passed {@code Throwable} in the message
   * 
   * @param message message to log
   * @param t associated throwable
   */
  void debug(Object message, Throwable t);

  /**
   * Log a message at the info level.
   * 
   * @param message message to log
   */
  void info(Object message);

  /**
   * Log a message at the info level, including the passed {@code Throwable} in the message
   * 
   * @param message message to log
   * @param t associated throwable
   */
  void info(Object message, Throwable t);

  /**
   * Log a message at the warn level.
   * 
   * @param message message to log
   */
  void warn(Object message);

  /**
   * Log a message at the warn level, including the passed {@code Throwable} in the message
   * 
   * @param message message to log
   * @param t associated throwable
   */
  void warn(Object message, Throwable t);

  /**
   * Log a message at the error level.
   * 
   * @param message message to log
   */
  void error(Object message);

  /**
   * Log a message at the error level, including the passed {@code Throwable} in the message
   * 
   * @param message message to log
   * @param t associated throwable
   */
  void error(Object message, Throwable t);

  /**
   * Log a message at the fatal level.
   * 
   * @param message message to log
   */
  void fatal(Object message);

  /**
   * Log a message at the fatal level, including the passed {@code Throwable} in the message
   * 
   * @param message message to log
   * @param t associated throwable
   */
  void fatal(Object message, Throwable t);

  /**
   * Returns {@code true} if debug level messages from this logger will be recorded.
   * 
   * @return {@code true} if debug logging is enabled
   */
  boolean isDebugEnabled();

  /**
   * Returns {@code true} if info level messages from this logger will be recorded.
   * 
   * @return {@code true} if info logging is enabled
   */
  boolean isInfoEnabled();

  /**
   * Returns the name of this logger.
   * 
   * @return name of this logger
   */
  String getName();
}
