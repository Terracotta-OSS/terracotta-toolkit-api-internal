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
package org.terracotta.toolkit.internal.search;

import org.terracotta.toolkit.collections.ToolkitMap;
import org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractor;

import java.util.Map;

public interface ToolkitAttributeExtractorInternal<K, V> extends ToolkitAttributeExtractor<K, V> {

  /**
   * Returns initial attribute type schema for cases when it is desired to pre-define data types for some or all of the
   * attributes to be indexed.
   */
  Map<String, Class<?>> getInitialTypeSchema();

  /**
   * XXX Provide destination for search attribute schema
   */
  ToolkitMap<String, String> createAttributeMap();
}
