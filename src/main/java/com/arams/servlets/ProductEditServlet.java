package com.arams.servlets;

import com.arams.beans.Product;
import com.arams.db.dao.classes.ProductDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ProductEdit", urlPatterns = {"/admin/editproduct"})
@MultipartConfig
public class ProductEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = ProductDao.getProductById(productId);
        ObjectMapper mapper = new ObjectMapper();
        product.getUserProductCarts();
        String jsonObject = mapper.writeValueAsString(product);
        response.getWriter().write(jsonObject);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productID = Integer.parseInt(request.getParameter("productId"));

        FileItem[] imageFiles = new FileItem[3];
        int arrayCounter = 0;

        DiskFileItemFactory factory = new DiskFileItemFactory();

        String productsImageDirectory
                = this.getServletConfig().getServletContext()
                .getInitParameter("product-image-directory");

        ServletFileUpload uploadHandler = new ServletFileUpload(factory);

        try {

            List<FileItem> files = uploadHandler.parseRequest(request);
            for (int i = 0; i < files.size(); i++) {

                FileItem fileItem = files.get(i);

                if (fileItem.isFormField()) {

                    request.setAttribute(fileItem.getFieldName(), fileItem.getString());

                } else {

                    imageFiles[arrayCounter] = fileItem;
                    arrayCounter++;

                }

            }
//            User user = setUserData(request);
            Product product = ProductDao.getProductById(productID);

            product.setName((String) request.getAttribute("name"));
            System.out.println("oooooooooooooooooooooooooooooooooooooooooooo" + request.getAttribute("price"));
            product.setPrice(Integer.parseInt((String) request.getAttribute("price")));
            product.setQuantity(Integer.parseInt((String) request.getAttribute("quantity")));
            product.setDescription((String) request.getAttribute("description"));

            ProductDao.updateProduct(product);

            for (int i = 0; i < imageFiles.length; i++) {
                System.out.println(imageFiles[i].getFieldName());
                if (imageFiles[i].getSize() != 0) {
                    System.out.println("============================================");
                    new File(productsImageDirectory).mkdirs();
                    File newFile = new File(productsImageDirectory
                            + product.getId() + "-" + (i + 1));
                    newFile.createNewFile();
                    imageFiles[i].write(newFile);

                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("../main");

    }
}