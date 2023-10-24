#ifndef GENERIC_LINKED_LIST_H
#define GENERIC_LINKED_LIST_H

#include <stddef.h>

// Define a function pointer type for printing data
typedef void (*PrintFunction)(void* data);


typedef struct listElementStruct {
    void* data;
    size_t size;
    struct listElementStruct* next;
    PrintFunction printFunction; // Function pointer for printing data
} listElement;

listElement* createEl(void* data, size_t size, PrintFunction printFunction);
void traverse(listElement* start);
listElement* insertAfter(listElement* el, void* data, size_t size, PrintFunction printFunction);
void deleteAfter(listElement* after);
int length(listElement* list);
void push(listElement** list, void* data, size_t size, PrintFunction printFunction);
listElement* pop(listElement** list);
void enqueue(listElement** list, void* data, size_t size, PrintFunction printFunction);
listElement* dequeue(listElement* list);

#endif
