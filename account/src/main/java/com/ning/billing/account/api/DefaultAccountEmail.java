/*
 * Copyright 2010-2011 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.account.api;

import java.util.UUID;

import com.ning.billing.util.entity.Entity;
import com.ning.billing.util.entity.EntityBase;

public class DefaultAccountEmail extends EntityBase implements AccountEmail, Entity {
    private final UUID accountId;
    private final String email;

    public DefaultAccountEmail(final UUID accountId, final String email) {
        super();
        this.accountId = accountId;
        this.email = email;
    }

    public DefaultAccountEmail(final AccountEmail source, final String newEmail) {
        this(source.getAccountId(), newEmail);
    }

    public DefaultAccountEmail(final UUID id, final UUID accountId, final String email) {
        super(id);
        this.accountId = accountId;
        this.email = email;
    }

    @Override
    public UUID getAccountId() {
        return accountId;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DefaultAccountEmail");
        sb.append("{accountId=").append(accountId);
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final DefaultAccountEmail that = (DefaultAccountEmail) o;

        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) {
            return false;
        }
        if (email != null ? !email.equals(that.email) : that.email != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountId != null ? accountId.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
