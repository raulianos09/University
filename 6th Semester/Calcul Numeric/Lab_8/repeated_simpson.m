function I = repeated_simpson(a,b,f,n)
  
  xk = linspace(a,b,n);
  S1 = 0;
  for i = 2 : n
    S1 = S1 + f((xk(i) + xk(i-1)) / 2);
  endfor
  
  S2 = sum(f(xk)) - f(b);
  
  I = ((b-a) / (6*n)) * (f(a) + f(b) + 4 * S1 + 2 * S2);
endfunction
