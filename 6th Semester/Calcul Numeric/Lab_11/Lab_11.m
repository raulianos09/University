%%%---------------------------------------------------------------------%%%
clear;
%% Exercise 1.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 1\n");

A = [ 3  -1  0  0  0  0 ;
     -1   3 -1  0  0  0 ;
      0  -1  3 -1  0  0 ;
      0   0 -1  3 -1  0 ;
      0   0  0 -1  3 -1 ;
      0   0  0  0 -1  3 ;
    ];
    
B = [2;
     1;
     1;
     1;
     1;
     2;
    ];

epsilon = 10 ^ (-3);

%% JACOBI
[it, res] = jacobi(A,B,epsilon);
printf("The solution using jacobi iterative method was obtained in %d steps and is: \n", it);
disp(res);
printf("\n");

%% GAUSS - SEIDEL
[it, res] = gauss_seidel(A,B,epsilon);
printf("The solution using Gauss-Seidel iterative method was obtained in %d steps and is: \n", it);
disp(res);
printf("\n");

%% RELAXATION
[it, res] = relaxation(A,B,epsilon,1.1);
printf("The solution using relaxation iterative method was obtained in %d steps and is: \n", it);
disp(res);
printf("\n");


printf("\n");

%%%---------------------------------------------------------------------%%%
clear;
%% Exercise 2.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 2\n");

A = [
      3  1  1;
     -2  4  0;
     -1  2 -6; 
    ];
    
B = [
     12;
      2;
      5;
    ];
    
epsilon = 10 ^ (-5); 
   
 %% JACOBI MATRIX
[it, res] = jacobi_matrix(A,B,epsilon);
printf("The solution using jacobi matrix method was obtained in %d steps and is: \n", it);
disp(res);
printf("\n");

%% GAUSS - SEIDEL MATRIX
[it, res] = gauss_seidel_matrix(A,B,epsilon);
printf("The solution using Gauss-Seidel matrix method was obtained in %d steps and is: \n", it);
disp(res);
printf("\n");

%% GAUSS - SEIDEL MATRIX
[it, res] = relaxation_matrix(A,B,epsilon,0.9);
printf("The solution using relaxation matrix method was obtained in %d steps and is: \n", it);
disp(res);
printf("\n");
   
printf("\n");










