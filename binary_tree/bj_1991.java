package binary_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


class Node { //노드 클래스 
    char data;
    Node left_node; Node right_node;
    public Node(char s)
    {
        this.data = s;
    }
}

class tree
{
    Node root;

    void make_tree(char data, char left, char right) // 트리 생성, 루트 지정 및 좌 우 노드, 
    {
        if(root == null) //트리의 루트도 없을대 최초로 ㅇ트리를 생성하는 부분
        {
            if(data!='.')root = new Node(data);
            if(left!='.')root.left_node = new Node(left);
            if(right!='.')root.right_node = new Node(right);
        }
        //노드를 찾으러 내려가야 함
        else search(root, data, left, right);
    }

    void search(Node root, char data, char left, char right)
    {
        if(root == null)
        {
            return;
        }
        else if(root.data == data) //해당 노드의 데이터가 찾고있는 데이터와 일치(알맞은 노드 => 레프트 라이트 적용)
        {
            if(left!='.')root.left_node = new Node(left);
            if(right!='.')root.right_node = new Node(right);
        }
        else
        {
            search(root.left_node, data, left, right);
            search(root.right_node, data, left, right);
        }
    }

    void preOrder(Node root)
    {
        System.out.print(root.data);
        if(root.left_node!=null) preOrder(root.left_node);
        if(root.right_node!=null) preOrder(root.right_node);
    }
    void inOrder(Node root)
    {
        if(root.left_node!=null) inOrder(root.left_node);
        System.out.print(root.data);
        if(root.right_node!=null) inOrder(root.right_node);
    }
    void postOrder(Node root)
    {
        if(root.left_node!=null) postOrder(root.left_node);
        if(root.right_node!=null) postOrder(root.right_node);
        System.out.print(root.data);
    }
}

public class bj_1991 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree T = new tree();
        for(int i=0; i<n; i++)
        {
            char[] s = br.readLine().replaceAll(" ", "").toCharArray();
            T.make_tree(s[0], s[1], s[2]);
        }
        T.preOrder(T.root);
        System.out.println();
        T.inOrder(T.root);
        System.out.println();
        T.postOrder(T.root);
    }
}
