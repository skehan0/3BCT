#include <stdio.h>
#include "tests.c"
#include "genericLinkedList.c"


int main(int argc, char* argv[]) {
    // Declare and initialize an integer variable 'x'
    int x = 23;
    // Print the size of 'int' in bytes
    printf("Size of int: %zu bytes\n", sizeof(x));

    // Declare a pointer to 'int' named 'y', initialize it to NULL
    int* y = NULL;
    // Print the size of 'int*' (pointer to int) in bytes
    printf("Size of int*: %zu bytes\n", sizeof(y));

    // Declare and initialize a 'long' variable 'z' with a large value
    long z = 1234567891L;
    // Print the size of 'long' in bytes
    printf("Size of long: %zu bytes\n", sizeof(z));

    // Declare a pointer to 'double' named 'i', initialize it to NULL
    double* i = NULL;
    // Print the size of 'double*' (pointer to double) in bytes
    printf("Size of double*: %zu bytes\n", sizeof(i));

    // Declare a pointer to a pointer to 'char' named 'j', initialize it to NULL
    char** j = NULL;
    // Print the size of 'char**' (pointer-pointer to char) in bytes
    printf("Size of char**: %zu bytes\n", sizeof(j));

    runTests();


    // Custom data elements
    int intValue = 23;
    char strValue[20];
    snprintf(strValue, sizeof(strValue), "%d", x);

    // Create an empty linked list
    listElement* myList = NULL;

    // Wrap the integer as a string for storage
    char intValueStr[32];  // Adjust the buffer size as needed
    snprintf(intValueStr, sizeof(intValueStr), "%d", intValue);

    // Add elements to the list using the push function
    push(&myList, &intValue, sizeof(int), printInt);
    push(&myList, strValue, strlen(strValue) + 1, printStr);

    // Print the length of the list
    printf("\nLength of the list: %d\n", length(myList));

    // Traverse the list to print its elements
    printf("List contents:\n");
    traverse(myList);

    return 0;
}
