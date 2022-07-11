package com.openaudio.oa.util;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Objects;

/**
 * 分页工具类
 */
public class PageUtils {

    //本地线程 --
    private static final ThreadLocal<Page<?>> PAGE_HOLDER = new ThreadLocal<>();

    //设置当前page
    public static void setCurrentPage(Page<?> page) {
        PAGE_HOLDER.set(page);
    }

    public static Page<?> getPage() {
        Page<?> page = PAGE_HOLDER.get();
        if(Objects.isNull(page)){
            setCurrentPage(new Page<>());
        }
        return PAGE_HOLDER.get();
    }

    //获取当前页
    public static Long getCurrent() {
        return getPage().getCurrent();
    }

    //获取页码条数
    public static Long getSize() {
        return getPage().getSize();
    }

    //获取有限制的当前页码条数
    public static Long getLimitCurrent() {
        return (getCurrent() - 1) * getSize();
    }

    //移除
    public static void remove() {
        PAGE_HOLDER.remove();
    }

}
