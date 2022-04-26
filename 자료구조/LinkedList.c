#include <stdio.h>
#include <stdlib.h>


typedef struct tagNode
    {
        int Data;
        struct tagNode* NextNode;
    } Node;
// 노드생성
Node* SSL_CreateNode(int NewData)
{
    Node* NewNode = (Node*)malloc(sizeof(Node));

    NewNode -> Data = NewData;
    NewNode -> NextNode = NULL;

    return NewNode;
}
// 노드 해제
void SSL_DestroyNode(Node* Node)
{
    free(Node);
}
//노드 추가
void SSL_AppendNode(Node **Head, Node *NewNode)
{
    if((*Head) == NULL)
    {
        (*Head) = NewNode;
    }
    else
    {
        Node *Tail = (*Head);
        while(Tail -> NextNode != NULL)
        {
            Tail = Tail -> NextNode;
        }
        Tail -> NextNode = NewNode;
    }
}

Node* SSL_GetNodeAt(Node* Head, int Location)
{
    Node *Current = Head;

    while(Current != NULL && (--Location) >= 0)
    {
        Current = Current -> NextNode;
    }
    return Current;
}

void SSL_RemoveNode(Node **Head, Node* Remove)
{
    if(*Head == Remove)
    {
        *Head = Remove -> NextNode;
        SSL_DestroyNode(Remove -> NextNode);
    }
    else
    {
        Node *Current = *Head;
        while(Current != NULL && Current -> NextNode != Remove)
        {
            Current = Current -> NextNode;
        }
        if(Current -> NextNode != NULL)//링크드 리스트에서의 삭제는 해당 노드의 앞 과 뒤의 노드를 연결시키는 것
        {
            Current -> NextNode = Remove ->NextNode;
        }
        SSL_DestroyNode(Remove);
    }
}

int SSL_CountNode(Node *Head)
{
    int Count = 1;
    Node *Current = Head;
    while(Current -> NextNode != NULL)
    {
        Current = Current -> NextNode;
        Count++;
    }

    return Count;
}

int main(void)
{
    Node *List = NULL;
    Node *MyNode = NULL;

    SSL_AppendNode(&List, SSL_CreateNode(117));
    SSL_AppendNode(&List, SSL_CreateNode(119));
    SSL_AppendNode(&List, SSL_CreateNode(212));

    MyNode = SSL_GetNodeAt(List, 1);
    printf("%d\n", MyNode->Data);

    SSL_RemoveNode(&List, MyNode);

    MyNode = SSL_GetNodeAt(List, 0);
    printf("%d\n", MyNode->Data);

    int count = SSL_CountNode(List);
    printf("노드의 총 갯수는 => %d", count);
    return 0;
}