package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "EncodeFilter", urlPatterns = "/*")
public class EncodeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        chain.doFilter(req, resp);
    } //设置ServletRequest对象的字符编码为UTF-8，确保请求参数不会出现乱码。
    //调用FilterChain的doFilter方法，将请求和响应传递给下一个过滤器或目标Servlet处理。

    public void init(FilterConfig config) throws ServletException {

    }
}
