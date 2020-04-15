package com.arams.servlets;

import com.arams.beans.Category;
import com.arams.beans.Product;
import com.arams.beans.ProductImage;
import com.arams.beans.ProductImageId;
import com.arams.db.dao.classes.CategoryDao;
import com.arams.db.dao.classes.ProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;


@WebServlet(name = "NewProductServlet", urlPatterns = {"/newProduct"})
@MultipartConfig
public class NewProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> categoryList = CategoryDao.getAllCategories();
        request.setAttribute("categories", categoryList);
        System.out.println(categoryList);
        RequestDispatcher rd
                = request.getRequestDispatcher("newproduct.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductDao.addProduct(getAddedProduct(request));
        response.getWriter().print("done");
    }

    private Product getAddedProduct(HttpServletRequest request) throws IOException, ServletException {
        String productName = request.getParameter("name");
        int productPrice = Integer.parseInt(request.getParameter("price"));
        int productQuantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        int category = Integer.parseInt(request.getParameter("category"));
        Category productCategory = new Category();
        productCategory.setId(category);
        Product product = new Product(productCategory, productName, productPrice, productQuantity);
        product.setDescription(description);
        // get uploaded images

        Part filePart = request.getPart("productImage");

        setUploadedImage(product, filePart);
        Part filePart2 = request.getPart("productImage2");

        setUploadedImage(product, filePart2);
        Part filePart3 = request.getPart("productImage3");

        setUploadedImage(product, filePart3);
        return product;
    }

    private void setUploadedImage(Product product, Part filePart) throws IOException {
        ServletContext sc = getServletConfig().getServletContext();
        String path = System.getProperty("user.home")+sc.getInitParameter("product-image-directory");
                //sc.getRealPath("..\\product");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String fileNameOnServer = product.getName()+ fileName;
        File savedFile = new File(path);
        if (!savedFile.exists()) {
            savedFile.mkdir();
        }
        path = savedFile.getAbsolutePath();
        System.out.println(path + "\\" + fileNameOnServer);
        filePart.write(path + "\\" + fileNameOnServer);
        ProductImage productImage = new ProductImage();
        ProductImageId productImageId = new ProductImageId();
        productImageId.setUrl(product.getName() + fileName);
        productImage.setId(productImageId);
        product.addImage(productImage);
    }

}
