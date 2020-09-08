package com.waylau.java.demo.datastructure;


import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;



/**
 * HuffmanTree Test.
 * 
 * @since 1.0.0 2020年9月8日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HuffmanTreeTest {
    @Order(1)
    @Test
    void test() {
        List<HuffmanTreeNode<String>> list = new ArrayList<HuffmanTreeNode<String>>();
        list.add(new HuffmanTreeNode<String>("A", 0.1));
        list.add(new HuffmanTreeNode<String>("B", 0.13));
        list.add(new HuffmanTreeNode<String>("C", 0.28));
        list.add(new HuffmanTreeNode<String>("D", 0.49));

        HuffmanTreeNode<String> root = HuffmanTree.createTree(list);
        HuffmanTree.encode(root);

        System.out.println(HuffmanTree.breadth(root));
    }
}
