package com.mall.user.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gaolingfeng
 * @date: 2021/2/27 14:17
 * @description:
 */

public class Test {
    public static void main(String[] args) {
        print(getNodeList());
    }

    private static void print(List<Node> list) {
        for (Node node:list){
            System.out.println(node.toString());
        }
    }

    private static List<Node> getNodeList(){
        List<Node> nodeList = new ArrayList<>(10);
        // A-65
        int nameStart = 65;
        for(int j=0;j<5;j++){
            Node node = new Node();
            node.setId(j+1);
            node.setParentId(j);
            String name = String.valueOf((char)(nameStart+j));
            name+=name;
            node.setName(name);
            nodeList.add(node);
        }
        return nodeList;
    }
}

//ShowMeBug
class Node {
    private Integer id;
    private Integer ParentId;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return ParentId;
    }

    public void setParentId(Integer parentId) {
        ParentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", ParentId=" + ParentId +
                ", name='" + name + '\'' +
                '}';
    }
}

