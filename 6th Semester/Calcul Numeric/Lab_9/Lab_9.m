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

f = @(x) 2 ./ (1 + x.^2);
a = 0;
b = 1; 
eps = 10 ^ (-4);

%% ---- A ----
printf("- A) -\n");
printf("Approx with Romberg's algorithm for the trapezium formula: %f", romberg_trapezium(a,b,f,eps));
printf("\n");

%% ---- B ----
printf("- B) -\n");
printf("Approx with Romberg's algorithm for the trapezium formula in Aitken's form: %f", romberg_aitken(a,b,f,eps));
printf("\n");

printf("\n");

%%%---------------------------------------------------------------------%%%

clear;
%% Exercise 3.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 3\n");

x = 1 : 0.001 : 3;
f = @(x) (100 ./ (x .^ 2)) .* sin( 10 ./ x);
eps = 10 ^ (-4);

printf("Approx with quadrature algorithm for Simpson's formula: %f\n", adaptive_quadrature(1,3,f,eps));
printf("Approx with repeated Simpson's formula for n = 50: %f\n", repeated_simpson(1,3,f,50));
printf("Approx with repeated Simpson's formula for n = 100: %f\n", repeated_simpson(1,3,f,100));
printf("Exact value is: %f\n", -1.4260247818);

printf("\n");

