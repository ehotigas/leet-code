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
}


struct Queue {
    struct Node *root;
    int size;
};


struct Queue *Queue() {
    struct Queue *queue = malloc(sizeof(struct Queue));
    queue->root = NULL;
    queue->size = 0;
}

int isEmpty(struct Queue *queue) {
    return queue->size == 0;
}


void add(struct Queue *queue, void *value) {
    struct Node *node;
    if (isEmpty(queue)) node = Node(value, NULL);
    else node = Node(value, queue->root);
    queue->root = node;
    queue->size++;
}

void *pop(struct Queue *queue) {
    if (isEmpty(queue)) return NULL;
    struct Node *ref = queue->root;
    while (ref->next != NULL) ref = ref->next;
    void *value = value
}

// pop
// peek
