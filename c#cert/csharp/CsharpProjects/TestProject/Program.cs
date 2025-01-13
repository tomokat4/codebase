Random random = new Random();
int daysUntilExpiration = 1;
int discountPercentage = 0;

// Your code goes here

if (( daysUntilExpiration <= 10) && (daysUntilExpiration > 5)) {
    Console.WriteLine("Your subscription will expire soon. Renew now!");
}

else if (( daysUntilExpiration <= 5) && daysUntilExpiration > 1) {
    Console.WriteLine($"Your subscription expires in {daysUntilExpiration} days. \n Renew now and save 10%!");
}

else if ( daysUntilExpiration == 1) {
    Console.WriteLine("Your subscription expires within a day! \n Renew now and save 20%!");
}

else if ( daysUntilExpiration == 0) {
    Console.WriteLine("Your subscription has expired.");
}