/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.cache;

import org.terracotta.toolkit.cache.ToolkitCache;
import org.terracotta.toolkit.cluster.ClusterNode;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

/**
 * Internal api for ToolkitCache
 */
public interface ToolkitCacheInternal<K, V> extends ToolkitCache<K, V> {

  /**
   * Returns set of nodes which has the corresponding key in its local jvm
   */
  Map<Object, Set<ClusterNode>> getNodesWithKeys(Set portableKeys);

  /**
   * Performs an unlocked put. This method does not take any lock so strong cache behaves like eventual cache. If user
   * takes lock outside then eventual cache will behave like strong cache.
   */
  void unlockedPutNoReturn(K k, V v, int createTime, int customTTI, int customTTL);

  void unlockedPutNoReturnVersioned(K k, V v, long version, int createTime, int customTTI, int customTTL);

  /**
   * Performs an unlocked remove. This method does not take any lock so strong cache behaves like eventual cache. If
   * user takes lock outside then eventual cache will behave like strong cache.
   */
  void unlockedRemoveNoReturn(Object k);

  void unlockedRemoveNoReturnVersioned(Object key, long version);

  /**
   * Performs an unlocked get.
   */
  V unlockedGet(Object k, boolean quiet);

  Map<K, V> unlockedGetAll(Collection<K> keys, boolean quiet);

  /**
   * Clear the local cache
   */
  void clearLocalCache();

  /**
   * Perform a local unlocked read for the given key.
   * <p/>
   * This method performs no locking and thus provides absolutely no visibility guarantees. If the value is not local it
   * will NOT be looked up from elsewhere and null is returned instead - thus one cannot distinguish between a
   * non-existent mapping from one where its present elsewhere. USE WITH CAUTION.
   *
   * @param key The key to lookup
   * @return value mapped to {@code key} if present locally in the current node, otherwise null.
   */
  V unsafeLocalGet(Object key);

  /**
   * Query whether key is present locally or not
   *
   * @return true if key is local, otherwise false
   */
  boolean containsLocalKey(Object key);

  /**
   * Return the count of local entries. <br>
   * The count returned might not be very accurate if maxEntriesLocalHeap is set to small values.
   *
   * @return count of local entries
   */
  int localSize();

  /**
   * Returns a Set containing keys in the Store which are present in the node locally. The returned set is immutable.
   *
   * @return Set of keys which are present in the node locally.
   */
  Set<K> localKeySet();

  /**
   * Return the on-heap size in bytes present locally in current node.<br>
   *
   * @return the on-heap size in bytes present locally in current node.
   */
  long localOnHeapSizeInBytes();

  /**
   * Return the off-heap size in bytes present locally in current node.
   *
   * @return the off-heap size in bytes present locally in current node.
   */
  long localOffHeapSizeInBytes();

  /**
   * Return the number of elements present locally on-heap in current node.<br>
   * The count returned might not be very accurate if maxEntriesLocalHeap is set to small values.
   *
   * @return the number of elements present locally on-heap in current node.
   */
  int localOnHeapSize();

  /**
   * Return the number of elements present locally in off-heap of current node.
   *
   * @return the number of elements present locally in off-heap of current node.
   */
  int localOffHeapSize();

  /**
   * Returns true if the key is present on-heap in current node.
   *
   * @return true if the key is present on-heap in current node otherwise false.
   */
  boolean containsKeyLocalOnHeap(Object key);

  /**
   * Returns true if the key is present off-heap in current node.
   *
   * @return true if the key is present off-heap in current node otherwise false.
   */
  boolean containsKeyLocalOffHeap(Object key);

  V put(K key, V value, int createTimeInSecs, int customMaxTTISeconds, int customMaxTTLSeconds);

  void putVersioned(K key, V value, long version);

  void putVersioned(K key, V value, long version, int createTimeInSecs, int customMaxTTISeconds, int customMaxTTLSeconds);
  
  /**
   * This method is required for WAN specific usecase. NOT to be used by other Toolkit clients.
   * It puts the new value only if the key was absent. 
   * @param key
   * @param value 
   * @param version the new version
   */
  void putIfAbsentVersioned(K key, V value, long version); 
  
  /**
   * This method is required for WAN specific usecase. NOT to be used by other Toolkit clients.
   * It puts the new value only if the key was absent. 
   * @param key
   * @param value
   * @param version
   * @param createTimeInSecs
   * @param customMaxTTISeconds
   * @param customMaxTTLSeconds
   */
  void putIfAbsentVersioned(K key, V value, long version, int createTimeInSecs, int customMaxTTISeconds, int customMaxTTLSeconds);

  /**
   * Dispose the Store from this node. If present elsewhere, the key-value store is still usable. Trying to use the
   * store after disposing locally will throw {@code IllegalStateException}.
   */
  void disposeLocally();

  void removeAll(Set<K> keys);

  void removeVersioned(Object key, long version);

  void registerVersionUpdateListener(VersionUpdateListener listener);
  
  void unregisterVersionUpdateListener(VersionUpdateListener listener);

  /**
   * Return the set of Keys in the given segment of cache
   * @param segmentIndex
   * @return
   */
  Set<K> keySetForSegment(int segmentIndex);
  
  /**
   * This method returns the {@link VersionedValue} corresponding to the given key.
   * Note that it wont update the lastAccessedTime and will act as quite GET.
   * @param key
   * @return VersionedValue
   */
  VersionedValue<V> getVersionedValue(Object key);
  
  /**
   * This method clears the cache but wont generate the server events.
   */
  public void clearVersioned();

  /**
   * This method submit a request to clear for this cache and returns. The cache {@link size} may not be 0 immediately after this method call.
   */
  void quickClear();
  
  /**
   * Returns approximate size of this cache without waiting for all transaction to finish.
   * 
   * @return approximate size of this cache
   */
  int quickSize();
  
  /**
   * Removes the entry for a key only if currently mapped to a given value.
   * This is equivalent to
   * <pre>
   *   if (map.containsKey(key) &amp;&amp;comparator.equals(map.get(key), value)) {
   *       map.remove(key);
   *       return true;
   *   } else return false;</pre>
   * except that the action is performed atomically.
   *
   * @param key key with which the specified value is associated
   * @param value value expected to be associated with the specified key
   * @param comparator comparator to compare values
   * @return <tt>true</tt> if the value was removed
   * @throws UnsupportedOperationException if the <tt>remove</tt> operation
   *         is not supported by this map
   * @throws ClassCastException if the key or value is of an inappropriate
   *         type for this map (optional)
   * @throws NullPointerException if the specified key or value is null,
   *         and this map does not permit null keys or values (optional)
   */
  boolean remove(Object key, Object value, ToolkitValueComparator<V> comparator);

  /**
   * Replaces the entry for a key only if currently mapped to a given value.
   * This is equivalent to
   * <pre>
   *   if (map.containsKey(key) &amp;&amp; comparator.equals(map.get(key), oldValue)) {
   *       map.put(key, newValue);
   *       return true;
   *   } else return false;</pre>
   * except that the action is performed atomically.
   *
   * @param key key with which the specified value is associated
   * @param oldValue value expected to be associated with the specified key
   * @param newValue value to be associated with the specified key
   * @param comparator comparator to compare values
   * @return <tt>true</tt> if the value was replaced
   * @throws UnsupportedOperationException if the <tt>put</tt> operation
   *         is not supported by this map
   * @throws ClassCastException if the class of a specified key or value
   *         prevents it from being stored in this map
   * @throws NullPointerException if a specified key or value is null,
   *         and this map does not permit null keys or values
   * @throws IllegalArgumentException if some property of a specified key
   *         or value prevents it from being stored in this map
   */
  boolean replace(K key, V oldValue, V newValue, ToolkitValueComparator<V> comparator);
  
}
