#include <stdio.h>
#include <stdlib.h>

typedef struct tagNode
{
  int Data;
  struct tagNode* PrevNode; //이전 노드
  struct tagNode* NextNode; //다음 노드
} Node;

//새로운 노드 만들기
Node* DDL_CreateNode(int NewData)
{
  Node *NewNode = (Node*)malloc(sizeof(Node));
  NewNode -> Data = NewData;
  NewNode -> PrevNode = NULL;
  NewNode -> NextNode = NULL;
}

void DDL_DestroyNode(Node *Node)
{
  free(Node);
}

void DDL_AppendNode(Node **Head, Node *NewNode)
{
  if((*Head) == NULL)
  {
    *Head = NewNode;
  }
  else
  {
    Node *Tail = (*Head);
    while(Tail ->NextNode != NULL)
    {
      Tail = Tail -> NextNode;
    }
    Tail -> NextNode = NewNode;
    NewNode -> PrevNode = Tail;
  }
}

Node* DDL_GetNodeAt(Node *Head, int Location)
{
  Node *Current = Head;

  while(Current != NULL && --Location >= 0)
  {
    Current = Current -> NextNode;
  }
  return Current;
}

void DDL_RemoveNode(Node **Head, Node *Remove)
{
  if(*Head == Remove)
  {
    *Head = Remove -> NextNode;
    
    if((*Head) != NULL)
      (*Head) -> PrevNode = NULL;
    
    Remove -> PrevNode = NULL;
    Remove -> NextNode = NULL;
  }
  else
  {
    Node *Temp = Remove;

    Remove -> PrevNode -> NextNode = Temp -> NextNode;

    if(Remove -> NextNode != NULL)
      Remove -> NextNode -> PrevNode = Temp -> PrevNode;

    Remove -> NextNode == NULL;
    Remove -> PrevNode == NULL;
  }
}
