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
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Product;
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

    public List<UserAdopt> getAdoptListByUsername(String username) { return userSalesMapper.getAdoptListByUsername(username); }
    @Transactional
    public UserAdopt getAdopt(int aid) {
        return userSalesMapper.getAdopt(aid);
    }
    @Transactional
    public UserAdopt getAdoptRecent() {
        return userSalesMapper.getAdoptRecent();
    }
    @Transactional
    public List<UserAdopt> getAdoptListBySid(String sid) {
        return userSalesMapper.getAdoptListBySid(sid);
    }
    @Transactional
    public void acceptAdopt(int aid) {
        userSalesMapper.acceptAdopt(aid);
    }
    @Transactional
    public void refusalAdopt(int aid) {
        userSalesMapper.refusalAdopt(aid);
    }
    @Transactional
    public int getAdoptCnt(String sid) {
        return userSalesMapper.getAdoptCnt(sid);
    }
    @Transactional
    public void insertImage(Image image) {
        image.setFid(getNextId("filenum"));
        userSalesMapper.insertImage(image);
    }

    public List<Image> getImageList(String itemId) { return userSalesMapper.getImageList(itemId); }

    public String getImageDirByItemId(String itemId) { return userSalesMapper.getImageDirByItemId(itemId); }

    public UserAdopt getAdoptByUsernameAndItemId(String username, String itemId) {
        return userSalesMapper.getAdoptByUsernameAndItemId(username, itemId);
    }
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
