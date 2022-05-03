%%%---------------------------------------------------------------------%%%
clear;
%% Exercise 1.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 1\n");

f = @(x)  exp(-(x.^2));
a = 1;
b = 1.5;

%% ---- A ----
printf("- A) -\n");
printf("Approx with rectangle formula: %f", rectangle(a,b,f));
printf("\n\n");


%% ---- B ----
printf("- B) -\n");
figure(1);
x = a : 0.001 : b;
hold on;
plot(x,f(x), "r;Function F;");

plot([a a b b],[0 f((a+b)/2) f((a+b)/2) 0],"b;Rectangle;");
legend("show");
title("Exercise 1 - B)");
hold off;

printf("Check figure 1 for results!");
printf("\n\n");

%% ---- C ----
printf("- C) -\n");
printf("Expected result is: %f\n", 0.1094);
printf("Approx with rectangle repeated formula for n = 150: %f\n", repeated_rectangle(a,b,f,150));
printf("Approx with rectangle repeated formula for n = 500: %f\n", repeated_rectangle(a,b,f,500));
printf("\n");

%%%---------------------------------------------------------------------%%%

clear;
%% Exercise 2.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 2\n");

f = @(x) 2 ./ (1 + x.^2)
a = 0;
b = 1; 
eps = 10 ^ (-4);

%% ---- A ----
printf("- A) -\n");
printf("Approx with rectangle formula: %f", romberg(a,b,f,eps));
printf("\n");


printf("\n");
