package com.arams.db.dao.interfaces;

import com.arams.beans.Product;

import java.util.List;

public interface IProductDao {


    Product addProduct(Product product);

    Product updateProduct(Product product);

    Product deleteProduct(int productId);

    List<Product> getAllProducts();
}
