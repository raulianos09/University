function T = romberg_aitken(a,b,f,epsilon)
  
  T1 = repeated_trapezium(a,b,f,1);
  
  i = 2 ;
  while 1
    T2 = [zeros(1,i)];
    T2(1) = repeated_trapezium(a,b,f,2 ^ (i-1));
    for j = 2 : i
       T2(j) = (4^(-j) * T1(j-1) - T2(j-1)) / (4 ^ (-j) -1);
    endfor

    if abs(T2(i) - T1(i-1)) <= epsilon
        T = T2(i);
        return;
    endif
   
    i = i+1; 
    T1 = T2;
  endwhile
endfunction