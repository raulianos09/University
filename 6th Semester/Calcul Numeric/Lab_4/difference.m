function m = difference(x,f)
n = length(x);
m = [f' , zeros(n,n-1)];
for j = 2:n
  for i = 1 : n-j+1
  m(i,j) = (m(i+1,j-1) - m(i,j-1)) / ( x(i+j-1) - x(i));
  endfor
endfor
m =[x', m];

endfunction