/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.DAO;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public abstract class DAO<E,K> {
    abstract public void insert(E entity);
    abstract public void update(E entity);
    abstract public void delete(K key);
    // selectAll thì chúng ta không cần tham số gì cả
    // Nhưng nó có giữ liệu trả về nên chúng ta sẽ dùng List
    abstract public List<E> selectAll();
    
    // Lấy theo mã thì chỉ trả về một kết quả
    // nên ta chỉ dùng E
    abstract public E selectByID(K key);
    
    // phương thức này để dành cho lớp con định nghĩa lại
    // có 2 tham số truyền vào 
    // 1: là câu lệnh sql
    // 2: là Object cần thiết để đưa vào dấu ?
    // kết quả trả về phải truyền vào List
    abstract protected List<E> selectBySql(String sql, Object...args);
}
