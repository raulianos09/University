function m = divided_difference_table(x,fx,dx)

n = 2 * length(x);
m = zeros(n);

m (:,1) = repelem(fx,2);
m(1:2:n-1,2) = dx;

temp = zeros(1,length(x)-1);

for i = 1 : (length(x)-1)
    temp(i) = (fx(i+1) - fx(i)) / (x(i+1) - x(i));
endfor

m(2:2:n-2,2) = temp(:);

x = repelem(x,2);



for j = 3:n
  for i = 1 : n-j+1
  m(i,j) = (m(i+1,j-1) - m(i,j-1)) / ( x(i+j-1) - x(i));
  endfor
endfor


endfunction