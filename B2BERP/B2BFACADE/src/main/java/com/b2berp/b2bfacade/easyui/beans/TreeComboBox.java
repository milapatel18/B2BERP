/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b2berp.b2bfacade.easyui.beans;

import java.util.List;

/**
 *
 * @author Milap Patel
 */
public class TreeComboBox {

    private int id;
    private String text;
    private List<TreeComboBox> children;
    private String state = "open";

    public TreeComboBox() {
    }

    public TreeComboBox(int id, String text, List<TreeComboBox> children) {
        this.id = id;
        this.text = text;
        this.children = children;
    }

    public List<TreeComboBox> getChildren() {
        return children;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public void setChildren(List<TreeComboBox> children) {
        this.children = children;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
