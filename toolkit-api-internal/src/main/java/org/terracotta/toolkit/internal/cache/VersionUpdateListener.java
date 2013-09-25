package org.terracotta.toolkit.internal.cache;

/**
 * @author Eugene Shelestovich
 */
public interface VersionUpdateListener<K, V> {

  void onLocalPut(K key, V value, long version, int segmentNumber);

  void onLocalRemove(K key, long version, int segmentNumber);
}
