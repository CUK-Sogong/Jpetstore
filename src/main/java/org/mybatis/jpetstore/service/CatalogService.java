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

import java.util.ArrayList;
import java.util.List;

import org.mybatis.jpetstore.domain.Category;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Product;
import org.mybatis.jpetstore.domain.Sequence;
import org.mybatis.jpetstore.mapper.CategoryMapper;
import org.mybatis.jpetstore.mapper.ItemMapper;
import org.mybatis.jpetstore.mapper.ProductMapper;
import org.mybatis.jpetstore.mapper.SequenceMapper;
import org.springframework.stereotype.Service;

/**
 * The Class CatalogService.
 *
 * @author Eduardo Macarron
 */
@Service
public class CatalogService {

  private final CategoryMapper categoryMapper;
  private final ItemMapper itemMapper;
  private final ProductMapper productMapper;
  private final SequenceMapper sequenceMapper;

  public CatalogService(CategoryMapper categoryMapper, ItemMapper itemMapper, ProductMapper productMapper, SequenceMapper sequenceMapper) {
    this.categoryMapper = categoryMapper;
    this.itemMapper = itemMapper;
    this.productMapper = productMapper;
    this.sequenceMapper = sequenceMapper;
  }

  public List<Category> getCategoryList() {
    return categoryMapper.getCategoryList();
  }

  public Category getCategory(String categoryId) {
    return categoryMapper.getCategory(categoryId);
  }

  public Product getProduct(String productId) {
    return productMapper.getProduct(productId);
  }

  public List<Product> getProductListByCategory(String categoryId) {
    return productMapper.getProductListByCategory(categoryId);
  }

  /**
   * Search product list.
   *
   * @param keywords
   *          the keywords
   * @return the list
   */
  public List<Product> searchProductList(String keywords) {
    List<Product> products = new ArrayList<>();
    for (String keyword : keywords.split("\\s+")) {
      products.addAll(productMapper.searchProductList("%" + keyword.toLowerCase() + "%"));
    }
    return products;
  }

  public List<Item> getItemListByProduct(String productId) {
    return itemMapper.getItemListByProduct(productId);
  }

  public Item getItem(String itemId) {
    return itemMapper.getItem(itemId);
  }

  public boolean isItemInStock(String itemId) {
    return itemMapper.getInventoryQuantity(itemId) > 0;
  }

  public List<Product> getUserProductList() {
    return productMapper.getUserProductList();
  }

  public List<Item> getUserItemList() {
    return itemMapper.getUserItemList();
  }

  public List<Item> getUserItemListByFilter(String f_category, String f_charge, int f_order, String f_search) {
    return itemMapper.getUserItemListByFilter(f_category, f_charge,f_order, f_search);
  }
  public void insertUserItem(Item userItem) {
    itemMapper.insertUserItem(userItem);
  }

  public void insertUserProduct(Product userProduct) {
    productMapper.insertUserProduct(userProduct);
  }
  public void setProductDescription(String productId,String description) {
    productMapper.setProductDescription(productId,description);
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


  public Item getUserItem(String itemId) {
    return itemMapper.getUserItem(itemId);
  }

  public Product getUserProduct(String itemId) {
    return productMapper.getUserProduct(itemId);
  }

  public void updateUserItem(Item userItem) {
    itemMapper.updateUserItem(userItem);
  }

  public void updateUserProduct(Product userProduct) { productMapper.updateUserProduct(userProduct); }

  public void deleteUserItem(String itemId) { itemMapper.deleteUserItem(itemId); }

  public void deleteUserProduct(String itemId) { productMapper.deleteUserProduct(itemId); }

  public List<Item> getUserItemListByUsername(String username) { return itemMapper.getUserItemListByUsername(username); }
}