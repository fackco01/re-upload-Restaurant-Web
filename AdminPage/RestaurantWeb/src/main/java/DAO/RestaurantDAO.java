package DAO;

import connect.DBUtils;
import java.util.*;
import java.sql.*;
import model.Product;
import model.category;

public class RestaurantDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from dbo.product";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product pdt = new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getFloat(7)
                );
                list.add(pdt);
                System.out.println(pdt);
            }
        } catch (Exception e) {

        }
        System.out.println(list);
        return list;
    }

    public Product getProduct(String txt) {
        String query = "select * from product where Product_id = ?";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, txt);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getFloat(7)
                );
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Product> getProductByCategory(String id) {
        List<Product> pl = new ArrayList<>();
        String query = "select * from product where Category_id = ?";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                pl.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getFloat(7)
                ));
            }
        } catch (Exception e) {

        }
        return pl;
    }

    public List<Product> getRelateProduct(String id, String pid) {
        List<Product> pl = new ArrayList<>();
        String query = "select * from product where Category_id = ? and Product_id != ?";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                pl.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getFloat(7)
                ));
            }
        } catch (Exception e) {

        }
        return pl;
    }

    public List<Product> PageProductByCategory(String id, int n) {
        List<Product> pl = new ArrayList<>();
        String query = "select * from product where Category_id = ? order by Product_id ASC OFFSET ? rows FETCH NEXT 5 ROWS ONLY";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setInt(2, n);
            rs = ps.executeQuery();
            while (rs.next()) {
                pl.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getFloat(7)
                ));
            }
        } catch (Exception e) {

        }
        return pl;
    }

    public List<Product> sortProductCategoryByDate(String id, int n) {
        List<Product> pl = new ArrayList<>();
        String query = "select * from product where Category_id = ? order by DateCreate DESC OFFSET ? rows FETCH NEXT 5 ROWS ONLY";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setInt(2, n);
            rs = ps.executeQuery();
            while (rs.next()) {
                pl.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getFloat(7)
                ));
            }
        } catch (Exception e) {

        }
        return pl;
    }

    public List<Product> sortProductCategoryByPriceLow(String id, int n) {
        List<Product> pl = new ArrayList<>();
        String query = "select * from product where Category_id = ? order by price ASC OFFSET ? rows FETCH NEXT 5 ROWS ONLY";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setInt(2, n);
            rs = ps.executeQuery();
            while (rs.next()) {
                pl.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getFloat(7)
                ));
            }
        } catch (Exception e) {

        }
        return pl;
    }

    public List<Product> sortProductCategoryByPriceHigh(String id, int n) {
        List<Product> pl = new ArrayList<>();
        String query = "select * from product where Category_id = ? order by price DESC OFFSET ? rows FETCH NEXT 5 ROWS ONLY";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setInt(2, n);
            rs = ps.executeQuery();
            while (rs.next()) {
                pl.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getFloat(7)
                ));
            }
        } catch (Exception e) {

        }
        return pl;
    }

    public List<Product> sortProductCategoryByRate(String id, int n) {
        List<Product> pl = new ArrayList<>();
        String query = "select * from product where Category_id= ? order by rating DESC OFFSET ? rows FETCH NEXT 5 ROWS ONLY";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setInt(2, n);
            rs = ps.executeQuery();
            while (rs.next()) {
                pl.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getFloat(7)
                ));
            }
        } catch (Exception e) {

        }
        return pl;
    }

    public List<category> getAllCategory() {
        List<category> list = new ArrayList<>();
        String query = "select * from category";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new category(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Product> getNewProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select top 5 * from product order by DateCreate DESC";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getFloat(7)
                ));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Product> getProductPage(int n) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product order by Product_id ASC OFFSET ? rows FETCH NEXT 5 ROWS ONLY";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, n);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getFloat(7)
                ));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Product> sortProductByDate(int n) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product order by DateCreate DESC OFFSET ? rows FETCH NEXT 5 ROWS ONLY";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, n);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getFloat(7)
                ));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Product> sortProductAscByPrice(int n) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product order by price ASC OFFSET ? rows FETCH NEXT 5 ROWS ONLY";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, n);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getFloat(7)
                ));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Product> sortProductDescByPrice(int n) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product order by price DESC OFFSET ? rows FETCH NEXT 5 ROWS ONLY";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, n);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getFloat(7)
                ));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Product> sortProductDescByRate(int n) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product order by rating DESC OFFSET ? rows FETCH NEXT 5 ROWS ONLY";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, n);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getFloat(7)
                ));
            }
        } catch (Exception e) {

        }
        return list;
    }

    //Admin delete DAO
    public void deleteProduct(String id) {
        String query = "delete from product\n"
                + "where Product_id = ?";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateProduct(String PID, String image, String nameP, String categoryID, int price) {
        String query = "update product set image_product = ?, Name_product = ?, Category_id = ?, price = ?\n"
                + "where Product_id = ?";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, image);
            ps.setString(2, nameP);
            ps.setString(3, categoryID);
            ps.setInt(4, price);
            ps.setString(5, PID);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void newProduct(String PID, String image, String nameP, String categoryID, int price, float rating){
        String query = "insert into product values(?, ?, ?, ?, ?, GETDATE(),?)";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, PID);
            ps.setString(2, image);
            ps.setString(3, nameP);
            ps.setString(4, categoryID);
            ps.setInt(5, price);
            ps.setFloat(6, rating);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
