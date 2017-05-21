/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huawei.paas.foundation.metrics.performance;

import java.util.List;

/**
 * PerfStat
 * @author  
 *
 */
public interface PerfStat {
    /**
     * getName
     * @return   perfstat name
     */
    String getName();

    /**
     * getPerfStatDataList
     * @return   perstat datas
     */
    List<PerfStatData> getPerfStatDataList();

    /**
     * mergeFrom
     * @param otherPerfStat   otherPerfStat
     */
    void mergeFrom(PerfStat otherPerfStat);

    /**
     * 计算统计数据
     * @param msNow             msNow
     * @param perfResultList    perfResultList
     */
    void calc(long msNow, List<PerfResult> perfResultList);

    /**
     * 计算统计数据
     * @param lastCycle         lastCycle
     * @param msCycle           msCycle
     * @param perfResultList    perfResultList
     */
    void calc(PerfStat lastCycle, long msCycle, List<PerfResult> perfResultList);
}