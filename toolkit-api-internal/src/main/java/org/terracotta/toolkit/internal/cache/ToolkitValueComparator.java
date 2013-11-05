package org.terracotta.toolkit.internal.cache;

/**
 * Used to compare two toolkit values.
 * 
 * @author Nishant
 */
public interface ToolkitValueComparator<V> {
     /**
      * Compare the two values.
      * 
      * @param v1 value to compare
      * @param v2 value to compare
      * @return {@code true} if the values are equal
      */
     boolean equals(V v1, V v2);

}
