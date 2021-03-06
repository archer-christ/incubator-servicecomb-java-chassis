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

package io.servicecomb.metrics.core.metric;

public class TimerMetric {
  private final long total;

  private final long count;

  private final double average;

  private final long min;

  private final long max;

  public long getTotal() {
    return total;
  }

  public long getCount() {
    return count;
  }

  public double getAverage() {
    return average;
  }

  public long getMin() {
    return min;
  }

  public long getMax() {
    return max;
  }

  public TimerMetric() {
    this(0, 0, 0, 0);
  }

  public TimerMetric(long total, long count, long min, long max) {
    this.total = total;
    this.count = count;
    if (count != 0) {
      this.average = (double) total / (double) count;
    } else {
      this.average = 0;
    }
    this.min = min;
    this.max = max;
  }

  public TimerMetric merge(TimerMetric metric) {
    return new TimerMetric(this.total + metric.total, this.count + metric.count,
        getMin(this.min, metric.min), getMax(this.max, metric.max));
  }

  private long getMin(long value1, long value2) {
    return value1 == 0 || (value2 != 0 && value2 < value1) ? value2 : value1;
  }

  private long getMax(long value1, long value2) {
    return value1 == 0 || value2 > value1 ? value2 : value1;
  }
}
