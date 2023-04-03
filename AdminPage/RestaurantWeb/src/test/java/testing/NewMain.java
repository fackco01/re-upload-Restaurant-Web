/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testing;

import DAO.LoginDAO;
import DAO.RestaurantDAO;
import java.util.*;
import model.Account;
import model.Product;
import model.category;

public class NewMain {


    public static void main(String[] args) {
        RestaurantDAO dao = new RestaurantDAO();
        List<Product> list = dao.getAllProduct();
        System.out.println(list);
    }
}
