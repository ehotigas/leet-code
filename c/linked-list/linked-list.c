#include <stdio.h>
#include <stdlib.h>

struct Node {
    void *value;
    struct Node *next;
};


struct Node *Node(void *value, struct Node *next) {
    struct Node *node = malloc(sizeof(struct Node));
    node->next = next;
    node->value = value;
    return node;
}

struct List {
    struct Node *root;
    int size;
};

struct List *List() {
    struct List *list = malloc(sizeof(struct List));
    list->size = 0;
    list->root = NULL;
    return list;
}

struct Node *findLast(struct List *list, struct Node *ref) {
    if (ref->next == NULL) return ref;
    return findLast(list, ref->next);
}

struct Node *findNode(struct List *list, int idx) {
    if (idx >= list->size || idx < 0) return NULL;
    
    struct Node *ref = list->root;
    for (int indexRef = 0; indexRef < idx; indexRef++) {
        ref = ref->next;
    }
    return ref;
}

void add(struct List *list, void *value) {
    if (list->root == NULL) {
        list->root = Node(value, NULL);
        list->size++;
        return;
    }
    struct Node *lastNode = findLast(list, list->root);
    lastNode->next = Node(value, NULL);
    list->size++;
}

void *find(struct List *list, int idx) {
    if (idx >= list->size || idx < 0) return NULL;
    return findNode(list, idx)->value;
}

void delete(struct List *list, int idx) {
    if (list->size == 0) return;
    if (idx == 0) {
        struct Node *node = list->root;
        if (list->size > 1) {
            list->root = list->root->next;
        }
        else {
            list->root = NULL;
        }
        free(node);
        list->size--;
        return;
    }
    if (idx == list->size - 1) {
        free(findNode(list, idx));
        findNode(list, idx - 1)->next = NULL;
        list->size--;
        return;
    }
    struct Node *beforeNode = findNode(list, idx - 1);
    struct Node *node = beforeNode->next;
    struct Node *afterNode = node->next;
    beforeNode->next = afterNode;
    free(node);
    list->size--;
}

void printIntegerArray(struct List *list) {
    
    printf("[");
    struct Node *ref = list->root;
    for (int idx = 0; idx < list->size; idx++) {
        int *value = ref->value;
        printf("%d", *value);
        if (idx != list->size - 1) {
            printf(", ");
        }
    }
    printf("]\n");
}


int main (int argc, char **argv) {
    int value = 12213;
    // void *void_pointer = malloc(sizeof(int*));
    // void_pointer = &value;
    // int *test = void_pointer;
    // printf("%d\n", (*test + 1));
    struct List *list = List();
    add(list, &value);
    add(list, &value);
    add(list, &value);
    printIntegerArray(list);
    // int *item = find(list, 0);
    // printf("%d\n", *item);
    return 0;
}