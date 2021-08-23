package com.example.GamerListsAPI.dto;

import java.sql.SQLException;
import java.util.Map;

public class ReturnedObjects {
    boolean flag = false;
    Map<Object, Object> map;
    Exception e;
    SQLException sqlException;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Map<Object, Object> getMap() {
        return map;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }

    public Exception getE() {
        return e;
    }

    public void setE(Exception e) {
        this.e = e;
    }

    public SQLException getSqlException() {
        return sqlException;
    }

    public void setSqlException(SQLException sqlException) {
        this.sqlException = sqlException;
    }
}
