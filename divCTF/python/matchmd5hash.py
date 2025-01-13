import hashlib

file_name = "dictionary.txt"

# Read the file and store passwords in a list
with open(file_name, "r") as file:
    passwords = file.read().splitlines()  # Reads lines and removes newline characters

# Loop through the passwords
for pw in passwords:  # Fixed typo in the loop variable
    if pw.strip():  # Skip empty lines
        # Compute MD5 hash
        hash_object = hashlib.md5(pw.encode())  # Use MD5 as specified
        hash_hex = hash_object.hexdigest()

        # Check if the hash matches the target
        if hash_hex == '0f4238735916dea9bac9b6a79824223b':  # Fixed missing colon
            print(f"{pw}: {hash_hex}")

