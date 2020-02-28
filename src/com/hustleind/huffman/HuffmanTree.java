package com.hustleind.huffman;

public class HuffmanTree {
    private final byte ENCODING_TABLE_SIZE = 127;
    private String stringToEncode;
    private BinaryTree huffmanTree;
    private int[]  freqArray;
    private String[] encodingArray;

    public HuffmanTree(String stringToEncode) {
        this.stringToEncode = stringToEncode;
        freqArray = new int[ENCODING_TABLE_SIZE];
        huffmanTree = getHuffmanTree();
        encodingArray = new String[ENCODING_TABLE_SIZE];
        fillEncodingArray(huffmanTree.getRoot(), "", "");
    }

    private BinaryTree getHuffmanTree() {
        PriorityQueue pq = new PriorityQueue();
        //алгоритм описан выше
        for (int i = 0; i < ENCODING_TABLE_SIZE; i++) {
            if (freqArray[i] != 0) {//если символ существует в строке
                Node newNode = new Node((char) i, freqArray[i]);//то создать для него Node
                BinaryTree newTree = new BinaryTree(newNode);//а для Node создать BinaryTree
                pq.insert(newTree);//вставить в очередь
            }
        }

        while (true) {
            BinaryTree tree1 = pq.remove();//извлечь из очереди первое дерево.

            try {
                BinaryTree tree2 = pq.remove();//извлечь из очереди второе дерево

                Node newNode = new Node();//создать новый Node
                newNode.addChild(tree1.getRoot());//сделать его потомками два извлеченных дерева
                newNode.addChild(tree2.getRoot());

                pq.insert(new BinaryTree(newNode));
            } catch (IndexOutOfBoundsException e) {//осталось одно дерево в очереди
                return tree1;
            }
        }
    }

    public BinaryTree getTree() {
        return huffmanTree;
    }

    private void fillFrequenceArray() {
        for (int i = 0; i < stringToEncode.length(); i++) {
            freqArray[(int)stringToEncode.charAt(i)]++;
        }
    }

    public int[] getFrequenceArray() {
        return freqArray;
    }

    void fillEncodingArray(Node node, String codeBefore, String direction) {//заполнить кодировочную таблицу
        if (node.isLeaf()) {
            encodingArray[(int)node.getLetter()] = codeBefore + direction;
        } else {
            fillEncodingArray(node.getLeft(), codeBefore + direction, "0");
            fillEncodingArray(node.getRight(), codeBefore + direction, "1");
        }
    }

    String[] getEncodingArray() {
        return encodingArray;
    }

    public void displayEncodingArray() {//для отладки
        fillEncodingArray(huffmanTree.getRoot(), "", "");

        System.out.println("======================Encoding table====================");
        for (int i = 0; i < ENCODING_TABLE_SIZE; i++) {
            if (freqArray[i] != 0) {
                System.out.print((char)i + " ");
                System.out.println(encodingArray[i]);
            }
        }
        System.out.println("========================================================");
    }
    //-----------------------------------------------------
    String getOriginalString() {
        return stringToEncode;
    }
}
