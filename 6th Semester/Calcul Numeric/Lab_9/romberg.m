function T = romberg(a,b,f,epsilon)
  
  i = 1 ;
  T = [];
  while 1
    T = [T zeros(1,i)];
    T(i,1) = repeated_trapezium(a,b,f,2 ^ (i-1));
    for j = 2 : i
       T(i,j) = (4^(-j) * T(i-1,j-1) - T(i , j-1)) / (4 ^ (-j) -1);
    endfor
    i = i+1;
    
    if abs(T(i,i) - T(i-1,i-1)) <= eps
        T = T(i,i);
        return;
    endif
  endwhile
endfunction