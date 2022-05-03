function I = adaptive_quadrature(a,b,f,eps)
  I1 = simpson(a,b,f);
  I2 = simpson(a,(a+b)/2, f) + simpson((a+b)/2,b, f);
  
  if abs(I1 - I2) < 15 * eps
    I = I2;
    return;
  else
    I = adaptive_quadrature(a, (a+b)/2 , f, eps / 2) + adaptive_quadrature( (a+b)/2, b ,f ,eps/2);
  endif


endfunction
