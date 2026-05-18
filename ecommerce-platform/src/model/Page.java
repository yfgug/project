package model;

import java.util.List;

public class Page<T> {
    private int pageNumber;     // 当前页码
    private int pageSize;       // 每页数据量
    private int totalCount;     // 总数据量
    private int totalPage;      // 总页数
    private List<T> list;       // 当前页数据

    // 核心计算方法
    public void setPageSizeAndTotalCount(int pageSize, int totalCount) {
        this.pageSize = pageSize;
        this.totalCount = totalCount;

        // 计算总页数（向上取整）
        totalPage = (int) Math.ceil((double) totalCount / pageSize);
        // 处理页码越界
        if (pageNumber > totalPage) pageNumber = totalPage;
        if (pageNumber < 1) pageNumber = 1;
    }

    // 缺失的setter方法
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    // Getter方法
    public int getPageNumber() { return pageNumber; }
    public int getPageSize() { return pageSize; }
    public int getTotalCount() { return totalCount; }
    public int getTotalPage() { return totalPage; }
    public List<T> getList() { return list; }
}
