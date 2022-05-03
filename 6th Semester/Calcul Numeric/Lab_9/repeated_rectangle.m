function I = repeated_rectangle(a,b,f,n)
  
  xk = zeros(1,n);
  xk(1) = a + ((b-a)/(2*n));

  for i = 2:n
    xk(i) = xk(1) + (i-1) * ((b-a)/n);
  endfor
  
  I = ((b-a) / n) * sum(f(xk));
  

endfunction

