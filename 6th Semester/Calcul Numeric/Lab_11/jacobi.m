function [it,res] = jacobi(A,B,epsilon)
  
  n = length(B);
  x1 = zeros(1, n);
  x2 = zeros(1, n);
  
  it = 0;
  cond = 1;
  
  while cond
    it = it + 1;
    
    for i = 1 : n
     
     sum = 0;
     for j = 1:n
       if i ~= j
          sum = sum + A(i,j) * x1(j);
       endif
     endfor
     
     x2(i) = (B(i) - sum) / A(i,i);
     
    endfor

    if abs(x2 - x1) < epsilon
        cond = 0;
    endif
        
    x1 = x2;
  endwhile
  res = x2;
  
endfunction