#include <stdio.h>
#include <stdlib.h>
#include "genericLinkedList.h"

void printStr(void* data) {
    printf("string: %s\n", (char*)data);
}

// Custom print functions for various data types
void printInt(void* data) {
    printf("int: %d\n", *(int*)data);
}

void runTests(){
  printf("Tests running...\n");
  listElement* l = createEl("Test String (1).", 30, printStr);
  //printf("%s\n%p\n", l->data, l->next);
  //Test create and traverse
  traverse(l);
  printf("\n");

  //Test insert after
  listElement* l2 = insertAfter(l, "another string (2)", 30, printStr);
  insertAfter(l2, "a final string (3)", 30, printStr);
  traverse(l);
  printf("\n");

  // Test delete after
  deleteAfter(l);
  traverse(l);
  printf("\n");


   // MY CODE
   // Test length
   int listLength = length(l);
   printf("Length of the list: %d\n", listLength);

   // Test push
   push(&l, "pushed string (4)", 30, printStr);
   traverse(l);
   printf("\n");

   // Test pop
   listElement* poppedElement = pop(&l);
   if (poppedElement) {
       printf("Popped element: %s\n", (char*)poppedElement->data);
       free(poppedElement->data);
       free(poppedElement);
   }

   // Test enqueue
   enqueue(&l, "enqueued string (5)", 30, printStr);
   traverse(l);
   printf("\n");

   // Test dequeue
   listElement* dequeuedElement = dequeue(l);
   if (dequeuedElement) {
       printf("Dequeued element: %s\n", (char*)dequeuedElement->data);
       free(dequeuedElement->data);
       free(dequeuedElement);
   }

   // Update length after manipulations
   listLength = length(l);
   printf("Updated length of the list: %d\n", listLength);

   printf("\nTests complete.\n");
}

