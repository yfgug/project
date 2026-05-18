package servlet;

import model.Goods;
import model.Order;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goods_buy")
public class GoodsBuyServlet extends HttpServlet {

    private GoodsService gService = new GoodsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = null;

        // 从Session获取购物车(Order对象)
        if(request.getSession().getAttribute("order") != null) {
            order = (Order) request.getSession().getAttribute("order");
        } else {
            order = new Order();
            request.getSession().setAttribute("order", order);
        }

        // 获取商品ID并查询商品信息
        int goodsId = Integer.parseInt(request.getParameter("goodsid"));
        Goods goods = gService.getGoodsById(goodsId);

        // 判断库存，加入购物车
        if(goods.getStock() > 0) {
            order.addGoods(goods);
            response.getWriter().print("ok");
        } else {
            response.getWriter().print("fail");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}