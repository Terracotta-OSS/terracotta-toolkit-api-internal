package org.terracotta.toolkit.internal.cache;

/**
 * The wrapper for returning the value and its version.
 * 
 * @author mcho
 * 
 * @param <V> value type
 */
public interface VersionedValue<V> {

/**
 * @return the associated value
 */
V getValue();

/**
 * @return the version associated with the corresponding value.
 */
long getVersion();
}
