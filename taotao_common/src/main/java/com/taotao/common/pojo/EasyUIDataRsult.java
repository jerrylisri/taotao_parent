package com.taotao.common.pojo;

import java.io.Serializable;
import java.util.List;
//如果要在不同系统中传递对象,必须实现序列化
public class EasyUIDataRsult implements Serializable{


    private Long total;
    private List<?> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
