clear;

f = @(x) (1 + cos(pi * x)) ./ (1+x) ; 


hold all;
% plot the function;
x = 0 : 0.01 : 10 ;
plot(x , f(x) , "r;Actual Function;");


x = linspace(0,10,21); %% 21 points from 0 10 interval
y = f(x); %% value of function in those 21 points

xx = linspace(0,10,50); %% interpolation points
L = [];
for i = 1 : length(xx)
  L = [L , lagrange(x,y,xx(i))];
endfor
plot(xx, L , "b;Interpolated function;");
legend("show");