%%%---------------------------------------------------------------------%%%
clear;
%% Exercise 1.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 1\n");

f = @(x)  2 ./ (1 + x.^2);

%% ---- A ----
printf("- A) -\n");
printf("Approx with trapezium formula: %f", trapezium(0,1,f));
printf("\n\n");


%% ---- B ----
printf("- B) -\n");
figure(1);
x = 0 : 0.001 : 1;
hold on;
plot(x,f(x), "r;Function F;");
plot([0 0 1 1],[0 f(0) f(1) 0],"b;Given trapezium;");
legend("show");
title("Exercise 1 - B)");
hold off;

printf("Check figure 1 for results!");
printf("\n\n");

%% ---- C ----
printf("- C) -\n");
printf("Approx with simpson's formula: %f", simpson(0,1,f));
printf("\n\n");

%%%---------------------------------------------------------------------%%%

clear;
%% Exercise 2.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 2\n");
f = @(x,y) log(x + 2 .* y);
printf("Expected result is: 0.4295545\n");
printf("Approx with double integral trapezium formula: %f", trapezium_for_double_integrals(1.4 ,2, 1 , 1.5 ,f));
printf("\n\n");

%%%---------------------------------------------------------------------%%%

clear;
%% Exercise 3.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 3\n");

r = 110;
p = 75;

f = @(x) (1 - (p/r)^2 .* sin(x)) .^ (1/2);
H = @(n) (60*r) / (r^2 - p^2) * repeated_trapezium(0,2*pi,f,n);

printf("Expected result is: 6.3131\n");
printf("Approx with repeated trapezium formula for n = 3: %f\n", H(3));
printf("Approx with repeated trapezium formula for n = 30: %f\n", H(30));
printf("\n");

%%%---------------------------------------------------------------------%%%

clear;
%% Exercise 4.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 4\n");

f = @(x) x .* log(x);
f_2nd_der = @(x) 1 ./ x;

M2F = max(abs(f_2nd_der(1:0.001:2)));

%% in order to find n find the smallest solution for the inequality: 
%% ((b-a)^3 * M2F) / 12N^2  < eps  |    b-a > 0  && M2F >= 0 
%% => 1 / 12 N^2 < eps / ((b-a)^3 * M2F)  | /12
%% => 1 / N^2 < (12 * eps) / ((b-a)^3 * M2F)
%% => N^2 > ((b-a)^3 * M2F) / (12 * eps)

a = 1;
b = 2;
eps = 0.001;

n = 1;
while n^2 < ((b-a)^3 * M2F) / (12 * eps)
  n = n+1;
endwhile  

printf("The obtained value of n is: %d\n" ,n);
printf("Expected result is: 0.636294368858383\n");
printf("Approx with repeated trapezium formula: %f\n", repeated_trapezium(1,2,f,n));


printf("\n\n");

%%%---------------------------------------------------------------------%%%

clear;
%% Exercise 5.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 5\n");

f = @(x) 1 ./ ( 4 + sin(20 .* x));

printf("Expected result is: 0.8111579\n");
printf("Approx with repeated simpson's formula for n = 10: %f\n", repeated_simpson(0,pi,f,10));
printf("Approx with repeated simpson's formula for n = 30: %f\n", repeated_simpson(0,pi,f,30));


printf("\n");

%%%---------------------------------------------------------------------%%%

clear;
%% Exercise 6.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 6\n");

f = @(t) exp(-t.^2);
err = @(x,n) (2 / sqrt(pi)) * repeated_simpson(0,x,f,n);

printf("Expected result is: 0.520499876\n");
printf("Approx with repeated simpson's formula for n = 4: %f\n", err(0.5,4));
printf("The error for this result is: %f\n", abs(0.520499876 - err(0.5,4)));
printf("Approx with repeated simpson's formula for n = 10: %f\n", err(0.5,10));
printf("The error for this result is: %f\n", abs(0.520499876 - err(0.5,10)));

printf("\n");





