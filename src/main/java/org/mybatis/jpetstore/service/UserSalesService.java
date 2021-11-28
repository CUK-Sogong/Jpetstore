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

import org.mybatis.jpetstore.domain.Image;
import org.mybatis.jpetstore.domain.Sequence;
import org.mybatis.jpetstore.domain.UserSale;
import org.mybatis.jpetstore.mapper.*;
import org.mybatis.jpetstore.domain.UserAdopt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserSalesService {

    private final UserSalesMapper userSalesMapper;
    private final SequenceMapper sequenceMapper;

    public UserSalesService(UserSalesMapper userSalesMapper, SequenceMapper sequenceMapper) {
        this.userSalesMapper = userSalesMapper;
        this.sequenceMapper = sequenceMapper;
    }

    @Transactional
    public void insertAdopt(UserAdopt userAdopt) {
        userAdopt.setAid(getNextId("adoptnum"));
        userSalesMapper.insertAdopt(userAdopt);
    }
    @Transactional
    public void updateAdopt(UserAdopt userAdopt) {
        userSalesMapper.updateAdopt(userAdopt);
    }
    @Transactional
    public void deleteAdopt(int aid) {
        userSalesMapper.deleteAdopt(aid);
    }
    @Transactional
    public List<UserAdopt> getAdoptList() {
        return userSalesMapper.getAdoptList();
    }

    public List<UserAdopt> getAdoptListByUsername(String username) {
        return userSalesMapper.getAdoptListByUsername(username);
    }

    public UserAdopt getAdopt(int aid) {
        return userSalesMapper.getAdopt(aid);
    }

    public List<UserSale> getSalesListByUsername(String username) {
        return userSalesMapper.getSalesListByUsername(username);
    }

    public List<UserSale> getSalesListtest() {
        return userSalesMapper.getSalesListtest();
    }

    public List<UserSale> getSalesList(String f_category,String f_charge, int f_order, String f_search) {
        return userSalesMapper.getSalesList(f_category,f_charge,f_order, f_search);
    }


    public List<UserSale> getSalesListAll() {
        return userSalesMapper.getSalesListAll();
    }


    public void insertSale(UserSale userSale) {
        userSale.setsid(getNextId("salesnum"));
        userSalesMapper.insertSale(userSale);
    }
    public void updateSales(UserSale userSale) {
        userSalesMapper.updateSales(userSale);
    }

    public void deleteSales(int sid) {
        userSalesMapper.deleteSales(sid);
    }

    public UserSale getSales(int sid) {
        return userSalesMapper.getSales(sid);
    }
    public UserSale getSalesRecent() {
        return userSalesMapper.getSalesRecent();
    }

    public UserAdopt getAdoptRecent() {
        return userSalesMapper.getAdoptRecent();
    }

    public List<UserAdopt> getAdoptListBySid(int sid) {
        return userSalesMapper.getAdoptListBySid(sid);
    }

    public void acceptAdopt(int aid) {
        userSalesMapper.acceptAdopt(aid);
    }

    public void refusalAdopt(int aid) {
        userSalesMapper.refusalAdopt(aid);
    }

    public int getAdoptCnt(int sid) {
        return userSalesMapper.getAdoptCnt(sid);
    }

    public void insertImage(Image image) {
        image.setFid(getNextId("filenum"));
        userSalesMapper.insertImage(image);
    }

    public List<Image> getImageList(int sid) { return userSalesMapper.getImageList(sid); }

    public String getImageDirBySid(int sid) { return userSalesMapper.getImageDirBySid(sid); }

    public int getNextId(String name) {
        Sequence sequence = sequenceMapper.getSequence(new Sequence(name, -1));
        if (sequence == null) {
            throw new RuntimeException(
                    "Error: A null sequence was returned from the database (could not get next " + name + " sequence).");
        }
        Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
        sequenceMapper.updateSequence(parameterObject);
        return sequence.getNextId();
    }



}
