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
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import io.servicecomb.transport.rest.vertx.accesslog.element.impl.DurationMillisecondElement;
import io.servicecomb.transport.rest.vertx.accesslog.parser.AccessLogElementExtraction;

public class DurationMillisecondMatcherTest {
  private static final DurationMillisecondMatcher MATCHER = new DurationMillisecondMatcher();

  private static final String RAW_PATTERN = "%D %h %{PATTERN}t %D%D %H %D";

  @Test
  public void testExtractElementPlaceHolder() {
    List<AccessLogElementExtraction> extractionList = MATCHER.extractElementPlaceholder(RAW_PATTERN);

    assertEquals(4, extractionList.size());
    assertEquals(0, extractionList.get(0).getStart());
    assertEquals(2, extractionList.get(0).getEnd());
    assertEquals(MATCHER.getAccessLogElement(), extractionList.get(0).getAccessLogElement());
    assertEquals(18, extractionList.get(1).getStart());
    assertEquals(20, extractionList.get(1).getEnd());
    assertEquals(MATCHER.getAccessLogElement(), extractionList.get(1).getAccessLogElement());
    assertEquals(20, extractionList.get(2).getStart());
    assertEquals(22, extractionList.get(2).getEnd());
    assertEquals(MATCHER.getAccessLogElement(), extractionList.get(2).getAccessLogElement());
    assertEquals(26, extractionList.get(3).getStart());
    assertEquals(28, extractionList.get(3).getEnd());
    assertEquals(MATCHER.getAccessLogElement(), extractionList.get(3).getAccessLogElement());
  }

  @Test
  public void testGetPlaceholderPattern() {
    assertEquals("%D", MATCHER.getPlaceholderPattern());
  }

  @Test
  public void getAccessLogElement() {
    assertTrue(DurationMillisecondElement.class.equals(MATCHER.getAccessLogElement().getClass()));
  }
}