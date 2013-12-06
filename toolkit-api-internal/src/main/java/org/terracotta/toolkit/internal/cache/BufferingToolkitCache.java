package org.terracotta.toolkit.internal.cache;

/**
 * @author tim
 */
public interface BufferingToolkitCache<K, V> extends ToolkitCacheInternal<K, V> {
  void startBuffering();

  boolean isBuffering();

  void stopBuffering();

  void flushBuffer();
}
