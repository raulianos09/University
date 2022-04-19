function I = trapezium(a,b,f)
  
  % epsilon = (a + b) / 2
  % R = (-(b - a)^3 / 12) * secder_f(epsilon)
  
  I = ((b-a) / 2) * (f(a) + f(b));

endfunction