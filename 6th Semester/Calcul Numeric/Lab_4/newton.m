function res = newton( x , y , xx)
    
    newtonPoly = y(1);
    m = length(x);
    D = difference(x,y);
    
    for i = 1 : m-1
      product = 1;
      
      for j = 1 : i
          product = product  * (xx - x(j));
      endfor
      
      product = product * D(1 , i+2);
      newtonPoly = newtonPoly + product;   
      
    endfor
    
    res = newtonPoly;
endfunction