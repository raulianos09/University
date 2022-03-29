function [H] = hermite(x , fx , dx, x0)
  
  table = divided_difference_table(x,fx,dx);
  table = table(1,:);
 
  doubleX = repelem(x,2);
  
  H = zeros(1, length(x0));
  
  for ih = 1 : length(H)
    H(ih) = table(1);
    for i = 2 : length(doubleX)
      product = table(i);
      for j = 1: (i-1)
        product = product * (x0(ih) - doubleX(j));
      endfor
      H(ih) = H(ih) + product;
    endfor
  endfor
  
  
endfunction