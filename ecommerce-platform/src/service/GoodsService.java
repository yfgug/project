package service; // 请根据您的实际包名进行修改

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import model.Page;

// 请根据您的项目实际包路径调整以下引入
import dao.GoodsDao;
import model.Goods;
import model.Page;

public class GoodsService {

    private GoodsDao gDao = new GoodsDao();

    public List<Map<String,Object>> getGoodsList(int recommendType) {
        List<Map<String,Object>> list = null;
        try {
            list = gDao.getGoodsList(recommendType);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,Object>> getScrollGood() {
        List<Map<String,Object>> list = null;
        try {
            list = gDao.getScrollGood();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public List<Goods> selectGoodsByTypeID(int typeID, int pageNumber, int pageSize) {
        List<Goods> list = null;
        try {
            list = gDao.selectGoodsByTypeID(typeID, pageNumber, pageSize);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public Page getGoodsPage(int typeID, int pageNumber) {
        Page p = new Page();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
            totalCount = gDao.getCountOfGoodsByTypeID(typeID);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.SetPageSizeAndTotalCount(8, totalCount);
        List list = null;
        try {
            list = gDao.selectGoodsByTypeID(typeID, pageNumber, 8);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public Page getRecommendPage(int type, int pageNumber) {
        Page p = new Page();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
            totalCount = gDao.getRecommendCountOfGoodsByTypeID(type);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.SetPageSizeAndTotalCount(8, totalCount);
        List list = null;
        try {
            list = gDao.selectGoodsbyRecommend(type, pageNumber, 8);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public Goods getGoodsById(int id) {
        Goods g = null;
        try {
            g = gDao.getGoodsById(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return g;
    }

    public Page getSearchGoodsPage(String keyword, int pageNumber) {
        Page p = new Page();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
            totalCount = gDao.getSearchCount(keyword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.SetPageSizeAndTotalCount(8, totalCount);
        List list = null;
        try {
            list = gDao.selectSearchGoods(keyword, pageNumber, 8);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }
}