function T2 = romberg(a,b,f,epsilon)
  T1 = ((b-a) / 2) * (f(a) + f(b));
  T2 = (1/2) * T1 + (b-a) * f( a + (b-a)/2 );
  
  k = 1;
  while  abs(T2 - T1) > epsilon
    T1 = T2;
    
    k = k+1;
    
    sum = 0;
    for i = 1 : (2 ^(k-1))
      sum = sum + f(a + ((2 * i - 1) / (2^k))*(b-a) );
    endfor
    
    T2 = (1/2) * T1 + ((b - a) / (2 ^ k)) * sum;
    
  endwhile
  
endfunction
