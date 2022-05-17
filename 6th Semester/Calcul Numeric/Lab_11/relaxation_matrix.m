function [it,res] = relaxation_matrix(A,B,epsilon,omega)
  
  n = length(A);
  
  D = diag(diag(A), n , n);
  U = triu(A,1);
  L = tril(A, -1);
  
  x1 = zeros(n, 1);
  x2 = zeros(n, 1);
  
   
  it = 0;
  cond = 1;
  while cond
    it = it +1;
    
    x2 = inv(D + omega * L) * (((1-omega)*D - omega*U) * x1 + omega * B);
    
   if abs(x2 - x1) < epsilon
        cond = 0;
    endif
        
    x1 = x2;
  endwhile
  res = x2';
  
endfunction
