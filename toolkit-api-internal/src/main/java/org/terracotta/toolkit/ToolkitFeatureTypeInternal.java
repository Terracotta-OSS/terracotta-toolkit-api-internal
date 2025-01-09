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
package org.terracotta.toolkit;

import org.terracotta.toolkit.atomic.ToolkitTransactionController;
import org.terracotta.toolkit.internal.feature.LicenseFeature;
import org.terracotta.toolkit.internal.feature.ManagementInternalFeature;
import org.terracotta.toolkit.internal.feature.NonStopInternalFeature;

import java.util.ArrayList;
import java.util.List;

public final class ToolkitFeatureTypeInternal<T extends ToolkitFeature> {

  private static final List<ToolkitFeatureTypeInternal> features = new ArrayList<ToolkitFeatureTypeInternal>();

  private static <F extends ToolkitFeature> ToolkitFeatureTypeInternal<F> define(Class<F> clazz) {
    ToolkitFeatureTypeInternal type = new ToolkitFeatureTypeInternal(clazz);
    if (features.contains(type)) {
      //
      throw new AssertionError("Cannot define multiple times for same feature interface - " + clazz.getName());
    }
    features.add(type);
    return type;
  }

  /**
   * License feature
   */
  public static final ToolkitFeatureTypeInternal<LicenseFeature>               LICENSE     = define(LicenseFeature.class);

  /**
   * NonStop internal feature
   */
  public static final ToolkitFeatureTypeInternal<NonStopInternalFeature>       NONSTOP     = define(NonStopInternalFeature.class);

  /**
   * Management internal feature
   */
  public static final ToolkitFeatureTypeInternal<ManagementInternalFeature>    MANAGEMENT     = define(ManagementInternalFeature.class);

  /**
   * Transaction feature
   */
  public static final ToolkitFeatureTypeInternal<ToolkitTransactionController> TRANSACTION = define(ToolkitTransactionController.class);

  /**
   * Returns list of all features that a toolkit can support.
   * 
   * @return array of toolkit feature types
   * @see Toolkit#getFeature(ToolkitFeatureType)
   */
  public static ToolkitFeatureTypeInternal[] values() {
    return features.toArray(new ToolkitFeatureTypeInternal[0]);
  }

  private final Class<T> clazz;

  private ToolkitFeatureTypeInternal(Class<T> clazz) {
    if (clazz == null) throw new AssertionError();
    this.clazz = clazz;
  }

  public Class<T> getFeatureClass() {
    return clazz;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ToolkitFeatureTypeInternal other = (ToolkitFeatureTypeInternal) obj;
    if (clazz == null) {
      if (other.clazz != null) return false;
    } else if (!clazz.equals(other.clazz)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "ToolkitFeatureType [clazz=" + clazz.getName() + "]";
  }

}
