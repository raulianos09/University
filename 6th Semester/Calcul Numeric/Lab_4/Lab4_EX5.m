
% a)
clear;
f = @(x) 3 .^ x;
x = [-2 -1 0 1 2];
y = f(x);
disp(["Wanted result for A is: ", num2str(neville(x,y,1/2))]);
disp("\n");

% b)
clear;
f = @(x) sqrt(x);
x = [0 1 2 4 5];
y = f(x);
disp(["Wanted result for B is: ", num2str(neville(x,y,3))]);