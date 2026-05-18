package model;

import utils.PriceUtil;

import java.util.*;

public class Order {
    private String id;
    private float total;
    private int amount;
    private int status; // 1未付款 2已付款 3已发货 4已完成
    private int paytype; // 1微信 2支付宝 3货到付款
    private String name;
    private String phone;
    private String address;
    private Date datetime;
    private User user;


    // 用于购物车的Map，键为商品ID，值为订单项
    private Map<Integer, OrderItem> itemMap = new HashMap<Integer, OrderItem>();
    private List<OrderItem> itemList = new ArrayList<OrderItem>();

    // 添加商品到购物车
    public void addGoods(Goods g) {
        if (itemMap.containsKey(g.getId())) {
            OrderItem item = itemMap.get(g.getId());
            item.setAmount(item.getAmount() + 1);
        } else {
            OrderItem item = new OrderItem(g.getPrice(), 1, g, this);
            itemMap.put(g.getId(), item);
        }
        amount++;
        total = PriceUtil.add(total, g.getPrice());
    }

    public String getFormattedPrice() {
        return PriceUtil.fenToYuan(this.total);
    }

    // 从购物车删除商品
    public void delete(int goodsId) {
        if (itemMap.containsKey(goodsId)) {
            OrderItem item = itemMap.get(goodsId);
            total = PriceUtil.subtract(total, item.getAmount() * item.getPrice());
            amount -= item.getAmount();
            itemMap.remove(goodsId);
        }
    }

    public Order() {
        super();
    }

    // Getter 和 Setter 方法
    public Map<Integer, OrderItem> getItemMap() { return itemMap; }
    public void setItemMap(Map<Integer, OrderItem> itemMap) { this.itemMap = itemMap; }

    public List<OrderItem> getItemList() { return itemList; }
    public void setItemList(List<OrderItem> itemList) { this.itemList = itemList; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public float getTotal() { return total; }
    public void setTotal(float total) { this.total = total; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public int getPaytype() { return paytype; }
    public void setPaytype(int paytype) { this.paytype = paytype; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Date getDatetime() { return datetime; }
    public void setDatetime(Date datetime) { this.datetime = datetime; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}