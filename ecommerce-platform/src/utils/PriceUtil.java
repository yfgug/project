package utils;

import java.math.BigDecimal;

public class PriceUtil {
    // 精确加法（处理金额计算）
    public static BigDecimal add(BigDecimal price1, BigDecimal price2) {
        return price1.add(price2);
    }

    // 精确减法（处理金额计算）
    public static BigDecimal subtract(BigDecimal price1, BigDecimal price2) {
        return price1.subtract(price2);
    }

    // 可选：扩展其他价格计算方法
    // public static BigDecimal multiply(...) {...}
}

