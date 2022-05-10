%%%---------------------------------------------------------------------%%%
clear;
%% Exercise 1.
printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 1\n\n");


A = [10 7 8 7; 7 5 6 5; 8 6 10 9; 7 5 9 10];
b = [32; 23; 33; 31];

%% ---- A ----
printf("- A) -\n");

printf("System solution is: \n");
res = linsolve(A, b)
printf("It's conditioning number is: %f\n", cond(A));
printf("\n");


%% ---- B ----
printf("- B) -\n");

b2 = [32.1;22.9;33.1;30.9];
printf("System solution is: \n");
res2 = linsolve(A, b2)

printf("The input relative error is: %f\n", norm(b-b2) / norm(b) );
printf("The output relative error is: %f\n", norm(res-res2)/ norm(res)); 
printf("output relative error / input relative error  is: %f\n", (norm(b-b2) / norm(b)) / (norm(res-res2)/ norm(res)) );
printf("\n");


%% ---- B ----
printf("- C) -\n");

A2 = [10 7 8.1 7.2; 7.08 5.04 6 5; 8 5.98 9.89 9; 6.99 4.99 9 9.98];
printf("System solution is: \n");
res3 = linsolve(A2, b)

printf("The input relative error is: %f\n", norm(A-A2) / norm(A) );
printf("The output relative error is: %f\n", norm(res-res3)/ norm(res)); 
printf("output relative error / input relative error  is: %f\n", (norm(A-A2) / norm(A)) / (norm(res-res3)/ norm(res)) );
printf("\n");

%%%---------------------------------------------------------------------%%%
clear;
%% Exercise 2.
printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 2\n\n");

tk = @(k) 1 ./ k;
for n = 10 : 15
  k = 1 : n;
  printf("The conditioning number for the Vandermonde matrix for the points tk = 1/k for k = 1,%d is : %f\n", n, cond(vander(tk(k))));

endfor
printf("\n");

%% k = 1:10;
%% format long g
%% disp(vander(tk(k)))



%%%---------------------------------------------------------------------%%%
clear;
%% Exercise 3.
printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 3\n\n");

% A * x = B

A = [1 1 1 1; 2 3 1 5; -1 1 -5 3; 3 1 7 -2];
B = [10 ;31 ;-2 ;18];

printf("The solution for the given system computed using the gauss method is:");
gauss(A, B)

printf("\n");