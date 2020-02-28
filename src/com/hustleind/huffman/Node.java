package com.hustleind.huffman;

public class Node implements Comparable<Node> {
    private char letter;
    private int frequency;
    private Node left, right;

    public Node(char letter, int frequency, Node left, Node right) {
        this.letter = letter;
        this.frequency = frequency;
    }

    public Node(char letter, int frequency) {
        this.letter = letter;
        this.frequency = frequency;
        left = right = null;
    }

    public Node() {
    }

    public void addChild(Node newNode) {//добавить потомка
        if (left== null)//если левый пустой=> правый тоже=> добавляем в левый
            left = newNode;
        else {
            if (left.getFrequency() <= newNode.getFrequency()) //в общем, левым потомком
                right = newNode;//станет тот, у кого меньше частота
            else {
                right = left;
                left = newNode;
            }
        }

        frequency += newNode.getFrequency();//итоговая частота
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getFrequency() {
        return frequency;
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public int compareTo(Node node) {
        return this.frequency - node.frequency;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

}
