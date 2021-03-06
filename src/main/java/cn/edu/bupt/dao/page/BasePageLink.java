/**
 * Copyright © 2016-2017 The Thingsboard Authors
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
package cn.edu.bupt.dao.page;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class BasePageLink implements Serializable {

    private static final long serialVersionUID = -4189954843653250481L;

    protected final int limit;

    protected UUID idOffset;

    public BasePageLink(int limit, UUID idOffset) {
        this.limit = limit;
        this.idOffset = idOffset;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getLimit() {
        return limit;
    }

    public UUID getIdOffset() {
        return idOffset;
    }

    public void setIdOffset(UUID idOffset) {
        this.idOffset = idOffset;
    }
}
