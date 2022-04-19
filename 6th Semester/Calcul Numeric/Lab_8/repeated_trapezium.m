function I = repeated_trapezium(a,b,f,n)
  
  xk = linspace(a,b,n-1);
  S = sum(f(xk));
  I = ((b-a) / (2*n)) * (f(a) + f(b) + 2 * S);
  
endfunction