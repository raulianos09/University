clear;

f = @(x) exp(sin(x));

x = linspace(0,6,13);
y = f(x);

yy = [];
for i = 1 : length(x)
  yy = [yy , newton(x,y,x(i))];
endfor

hold all;
title("Problem 3");
plot(x,y,"r*;Given function;");
xxx = 0:0.01:6;
plot(xxx, f(xxx),"g");
plot(x,yy,"b;Newton interpolated F;");