/*
 *    Copyright 2010-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.jpetstore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Order;
import org.mybatis.jpetstore.domain.Sequence;
import org.mybatis.jpetstore.mapper.*;
import org.mybatis.jpetstore.domain.LineItem;
import org.mybatis.jpetstore.domain.UserAdopt;
import org.mybatis.jpetstore.domain.UserSale;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserSalesService {

    private final UserSalesMapper userSalesMapper;

    public UserSalesService (UserSalesMapper userSalesMapper) {
        this.userSalesMapper = userSalesMapper;
    }

    public List<UserSale> getSalesList() { return userSalesMapper.getSalesList(); }
}
