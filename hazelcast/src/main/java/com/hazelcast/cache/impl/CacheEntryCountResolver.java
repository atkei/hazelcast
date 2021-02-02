/*
 * Copyright (c) 2008-2021, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.cache.impl;

/**
 * Contract point for tracking count of stored cache entries.
 */
public abstract class CacheEntryCountResolver {

    public abstract long getEntryCount();

    public static CacheEntryCountResolver createEntryCountResolver(CacheContext cacheContext) {
        return new CacheContextBackedEntryCountResolver(cacheContext);
    }

    private static class CacheContextBackedEntryCountResolver extends CacheEntryCountResolver {

        private final CacheContext cacheContext;

        CacheContextBackedEntryCountResolver(CacheContext cacheContext) {
            this.cacheContext = cacheContext;
        }

        @Override
        public long getEntryCount() {
            return cacheContext.getEntryCount();
        }

    }

}
