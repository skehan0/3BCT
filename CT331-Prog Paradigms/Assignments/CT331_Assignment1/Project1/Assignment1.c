#include <stdio.h>

int main() {
    int x = 23;
    printf("Size of int x: %zu bytes\n", sizeof(x));

    int y_value = 43;
    int* y = &y_value;
    printf("Size of int* y: %zu bytes\n", sizeof(y));

    long int z = 96574321;
    printf("Size of long int z: %zu bytes\n", sizeof(z));

    int integer_value = 132;
    double* i = (double*)&integer_value; // This is unusual, use with caution
    printf("Size of double* i: %zu bytes\n", sizeof(i));

    char str[] = "car";
    char* j = str;
    printf("Size of char* j: %zu bytes\n", sizeof(j));

    return 0;
}
