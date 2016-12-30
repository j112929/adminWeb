package com.jzl.po.user;


import com.appcore.model.AbstractObject;

/**
 * 【】持久化对象 数据库表：user
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-12
 * 
 */
public class User extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 
    private Integer id;
    // 
    private String name;

    /** 获取  */
    public Integer getId() {
        return id;
    }

    /** 设置  */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取  */
    public String getName() {
        return name;
    }

    /** 设置  */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("User");
        sb.append("{id=").append(id);
        sb.append(", name=").append(name);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof User) {
            User user = (User) obj;
            if (this.getId().equals(user.getId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String pkStr = "" + this.getId();
        return pkStr.hashCode();
    }

}