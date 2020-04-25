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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.List;


@WebServlet(name = "NewProductServlet", urlPatterns = {"/admin/newproduct"})
@MultipartConfig
public class NewProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> categoryList = CategoryDao.getAllCategories();
        request.setAttribute("categories", categoryList);
        RequestDispatcher rd
                = request.getRequestDispatcher("../newproduct.jsp");
        rd.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Product newProduct = getAddedProduct(request);
        ProductDao.addProduct(newProduct);
        addImages(request, newProduct);
        ProductDao.updateProduct(newProduct);
        RequestDispatcher rd
                = request.getRequestDispatcher("../newproduct.jsp");
        rd.include(request, response);
        response.sendRedirect("../main");
    }

    private void addImages(HttpServletRequest request, Product product)
            throws IOException, ServletException {

        Part filePart = request.getPart("productImage");
        if (filePart.getSize() != 0)
            setUploadedImage(product, filePart, 1);

        Part filePart2 = request.getPart("productImage2");
        if (filePart2.getSize() != 0)
            setUploadedImage(product, filePart2, 2);

        Part filePart3 = request.getPart("productImage3");
        if (filePart3.getSize() != 0)
            setUploadedImage(product, filePart3, 3);

    }

    private Product getAddedProduct(HttpServletRequest request) throws IOException, ServletException {
        String productName = request.getParameter("name");
        int productPrice = Integer.parseInt(request.getParameter("price"));
        int productQuantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
//        int category = Integer.parseInt(request.getParameter("category"));

        Category productCategory = CategoryDao.getCategoryByName(request.getParameter("category"));

        Product product = new Product(productCategory, productName, productPrice, productQuantity);
        product.setDescription(description);
        // get uploaded images

        return product;
    }

    private void setUploadedImage(Product product, Part filePart, int imageNumber) throws IOException {
        ServletContext sc = getServletConfig().getServletContext();
//        System.getProperty("user.home")+
        String path = sc.getInitParameter("product-image-directory");
        //sc.getRealPath("..\\product");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String fileNameOnServer = product.getId() + "-" + imageNumber;
        File savedFile = new File(path);
        if (!savedFile.exists()) {
            savedFile.mkdir();
        }
        FileOutputStream outStream = new FileOutputStream(new File(path + fileNameOnServer));

        outStream.write(filePart.getInputStream().readAllBytes());
//        ProductImage productImage = new ProductImage();
//        ProductImageId productImageId = new ProductImageId();
//        productImageId.setUrl(product.getName() + fileName);
//        productImage.setId(productImageId);
//        product.addImage(productImage);
    }

}
