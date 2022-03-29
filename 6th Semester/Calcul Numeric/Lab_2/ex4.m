x = 1 : 0.25 : 2.5; # x = 1 : i*h , i = 1:6, h = 0.25
f = @(x) sqrt(5*x.^2+1); # defined function 
n = length(x);
m = [f(x)' , zeros(n,n-1)];
for j = 2:n
  for i = 1: n-j+1
    m(i,j) = m(i+1,j-1) - m(i,j-1);
  endfor
endfor
m = [x', m]