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

package com.ning.billing.account.dao;

import java.util.UUID;

import com.ning.billing.account.api.Account;
import com.ning.billing.account.api.AccountApiException;
import com.ning.billing.util.callcontext.InternalCallContext;
import com.ning.billing.util.callcontext.InternalTenantContext;
import com.ning.billing.util.entity.EntityPersistenceException;
import com.ning.billing.util.entity.dao.EntityDao;
import com.ning.billing.util.entity.dao.UpdatableEntityDao;

public interface AccountDao extends EntityDao<Account> {

    public Account getAccountByKey(String key, InternalTenantContext context);

    /**
     * @throws AccountApiException when externalKey is null
     */
    public UUID getIdFromKey(String externalKey, InternalTenantContext context) throws AccountApiException;

    /**
     * @param accountId       the id of the account
     * @param paymentMethodId the is of the current default paymentMethod
     */
    public void updatePaymentMethod(UUID accountId, UUID paymentMethodId, InternalCallContext context) throws EntityPersistenceException;

    public void update(Account account, InternalCallContext context);
}
