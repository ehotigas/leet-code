#include <stdio.h>
#include <stdlib.h>

struct Node {
    void *value;
    struct Node *next;
};


struct Node *Node(void *value, struct Node *next) {
    struct Node *node = malloc(sizeof(struct Node *));
    node->next = next;
    node->value = value;
    return node;
}

struct List {
    struct Node *root;
    int size;
};

struct List *List() {
    struct List *list = malloc(sizeof(struct List*));
    list->size = 0;
    list->root = NULL;
    return list;
}

struct Node *findLast(struct List *list, struct Node *ref) {
    if (ref->next == NULL) return ref;
    return findLast(list, ref->next);
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
    if (idx < 0 || idx > list->size - 1) return NULL;
    struct Node *ref = list->root;
    for (int listIdx = 0; listIdx < list->size; listIdx++) {
        if (listIdx == idx) return ref->value;
        ref = ref->next;
    }
    return NULL;
}

void remove(struct List *list, int idx) {
    if (idx < 0 || idx > list->size - 1) return;
}


int main (int argc, char **argv) {
    int value = 12213;
    // void *void_pointer = malloc(sizeof(int*));
    // void_pointer = &value;
    // int *test = void_pointer;
    // printf("%d\n", (*test + 1));
    struct List *list = List();
    add(list, &value);
    int *item = find(list, 0);
    printf("%d\n", *item);
    return 0;
}