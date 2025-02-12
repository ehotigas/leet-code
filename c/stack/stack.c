#include <stdio.h>
#include <stdlib.h>


struct Node {
    void *value;
    struct Node *next;
};

struct Node *Node(void *value, struct Node *next) {
    struct Node *node = malloc(sizeof(struct Node));
    node->value = value;
    node->next = next;
    return node;
}


struct Stack {
    struct Node *root;
    int size;
};


struct Stack *Stack() {
    struct Stack *stack = malloc(sizeof(struct Stack));
    stack->root = NULL;
    stack->size = 0;
    return stack;
}

int isEmpty(struct Stack *stack) {
    return stack->size == 0;
}

void push(struct Stack *stack, void *value) {
    struct Node *node;
    if (isEmpty(stack)) node = Node(value, NULL);
    else node = Node(value, stack->root);
    stack->root = node;
    stack->size++;
}

void *pop(struct Stack *stack) {
    if (isEmpty(stack)) return NULL;
    struct Node *node = stack->root;
    void *value = node->value;
    stack->root = node->next;
    free(node);
    stack->size--;
    return value;
}

void *peek(struct Stack *stack) {
    if (isEmpty(stack)) return NULL;
    return stack->root->value;
}


void printIntegerStack(struct Stack *stack) {
    struct Node *current = stack->root;
    printf("Stack (size=%d): ", stack->size);
    while (current) {
        printf("%d -> ", *(int *)current->value);
        current = current->next;
    }
    printf("NULL\n");
}