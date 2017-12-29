package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyOrder;
import model.MyFood;
import model.PageTools;


public class FoodOrderServlet extends HttpServlet {
    MyOrder myOrder = new MyOrder();
    public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("orderId")!=null){
            try {
                myOrder.updateOrder(request.getParameter("orderId"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String curPage = request.getParameter("curPage");
        Integer curPageIndex = 1;
        if (curPage != null) {
            curPageIndex = Integer.parseInt(curPage);
        }
        PageTools list = myOrder.getTableList(curPageIndex);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/detail/orderList.jsp").forward(request, response);
    }

    public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        this.doGet(request, response);
    }

}
