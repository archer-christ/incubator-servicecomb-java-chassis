/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.transport.rest.vertx.accesslog.parser.matcher.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.servicecomb.transport.rest.vertx.accesslog.element.impl.QueryOnlyElement;

public class QueryOnlyMatcherTest {

  public static final QueryOnlyMatcher MATCHER = new QueryOnlyMatcher();

  @Test
  public void getPlaceholderPatterns() {
    String[] patterns = MATCHER.getPlaceholderPatterns();

    assertEquals(2, patterns.length);
    assertEquals("%q", patterns[0]);
    assertEquals("cs-uri-query", patterns[1]);
  }

  @Test
  public void getAccessLogElement() {
    assertEquals(QueryOnlyElement.class, MATCHER.getAccessLogElement().getClass());
  }
}