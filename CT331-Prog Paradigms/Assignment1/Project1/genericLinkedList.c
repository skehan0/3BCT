#include <stdlib.h>
#include <string.h>
#include <stddef.h>
#include "genericLinkedList.h"

listElement* createEl(void* data, size_t size, PrintFunction printFunction) {
    listElement* e = malloc(sizeof(listElement));
    if (e == NULL) {
        return NULL;
    }

    void* dataPointer = malloc(size);
    if (dataPointer == NULL) {
        free(e);
        return NULL;
    }

    memcpy(dataPointer, data, size);

    e->data = dataPointer;
    e->size = size;
    e->next = NULL;
    e->printFunction = printFunction;

    return e;
}

void traverse(listElement* start) {
    listElement* current = start;
    while (current != NULL) {
        current->printFunction(current->data);
        current = current->next;
    }
}

listElement* insertAfter(listElement* el, void* data, size_t size, PrintFunction printFunction) {
    listElement* newEl = createEl(data, size, printFunction);
    listElement* next = el->next;
    newEl->next = next;
    el->next = newEl;
    return newEl;
}

void deleteAfter(listElement* after) {
    if (after != NULL && after->next != NULL) {
        listElement* delete = after->next;
        listElement* newNext = delete->next;
        after->next = newNext;

        free(delete->data);
        free(delete);
    }
}

int length(listElement* list) {
    int count = 0;
    listElement* current = list;
    while (current != NULL) {
        count++;
        current = current->next;
    }
    return count;
}

void push(listElement** list, void* data, size_t size, PrintFunction printFunction) {
    listElement* newEl = createEl(data, size, printFunction);
    newEl->next = *list;
    *list = newEl;
}

listElement* pop(listElement** list) {
    if (*list == NULL) {
        return NULL;
    }

    listElement* popped = *list;
    *list = popped->next;
    popped->next = NULL;
    return popped;
}

void enqueue(listElement** list, void* data, size_t size, PrintFunction printFunction) {
    listElement* newEl = createEl(data, size, printFunction);
    if (*list == NULL) {
        *list = newEl;
    } else {
        listElement* current = *list;
        while (current->next != NULL) {
            current = current->next;
        }
        current->next = newEl;
    }
}

listElement* dequeue(listElement* list) {
    if (list == NULL) {
        return NULL;
    }

    if (list->next == NULL) {
        listElement* dequeued = list;
        list = NULL;
        dequeued->next = NULL;
        return dequeued;
    }

    listElement* current = list;
    while (current->next->next != NULL) {
        current = current->next;
    }

    listElement* dequeued = current->next;
    current->next = NULL;
    dequeued->next = NULL;
    return dequeued;
}
