#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function to calculate little-endian representation
char *find_little_endian(const char *word) {
    size_t word_len = strlen(word);
    char *little_endian = (char *)malloc((2 * word_len + 1) * sizeof(char));

    for (size_t i = word_len; i-- > 0;) {
        snprintf(&little_endian[(word_len - 1 - i) * 2], 3, "%02X", (unsigned char)word[i]);
    }

    little_endian[2 * word_len] = '\0';
    return little_endian;
}

// Function to calculate big-endian representation
char *find_big_endian(const char *word) {
    size_t length = strlen(word);
    char *big_endian = (char *)malloc((2 * length + 1) * sizeof(char));

    for (size_t i = 0; i < length; i++) {
        snprintf(&big_endian[i * 2], 3, "%02X", (unsigned char)word[i]);
    }

    big_endian[2 * length] = '\0';
    return big_endian;
}

// Helper function to convert a hexadecimal string to an integer
unsigned long hex_to_int(const char *hex_str) {
    return strtoul(hex_str, NULL, 16);
}

int main() {
    char input[256];

    // Prompt user for input
    printf("Enter a word: ");
    if (fgets(input, sizeof(input), stdin) == NULL) {
        fprintf(stderr, "Error reading input.\n");
        return 1;
    }

    // Remove newline character from input if present
    input[strcspn(input, "\n")] = '\0';

    // Calculate little-endian and big-endian representations
    char *little_endian = find_little_endian(input);
    char *big_endian = find_big_endian(input);

    printf("Little-endian: %s\n", little_endian);
    printf("Big-endian: %s\n", big_endian);

    // Convert hexadecimal strings to integers
    unsigned long little_endian_value = hex_to_int(little_endian);
    unsigned long big_endian_value = hex_to_int(big_endian);

    // Calculate the product
    unsigned long product = little_endian_value * big_endian_value;

    printf("Product: %lu\n", product);

    // Free allocated memory
    free(little_endian);
    free(big_endian);

    return 0;
}

