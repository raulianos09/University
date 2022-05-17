function [it ,res] = relaxation(A,B,epsilon,omega)
 n = length(B);
  
  x1 = zeros(1,n);
  x2 = zeros(1,n);
  
   
  it = 0;
  cond = 1;
  
  while cond
    it = it + 1;
    
    for i = 1 : n
     
     sum1 = 0;
     for j = 1: (i-1)
          sum1 = sum1 + A(i,j) * x2(j);
     endfor
     
     sum2 = 0;
     for j = (i+1) : n
          sum2 = sum2 + A(i,j) * x1(j);
     endfor
     
     x2(i) = (omega / A(i,i)) * (B(i) - sum1 - sum2) + (1 - omega) * x1(i);
     
    endfor

    if abs(x2 - x1) < epsilon
        cond = 0;
    endif
        
    x1 = x2;
  endwhile
  res = x2;


endfunction
