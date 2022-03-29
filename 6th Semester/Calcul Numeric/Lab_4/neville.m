function res = neville(x,y,xx)
   Q = zeros(length(x), length(x));
   Q(:,1) = y;
   for i = 2 : length(x)
      for j = 2 : i
          numerator = ((x(i) - xx) * Q(i-1,j-1)) + (xx - x(i-j+1) * Q(i,j-1));
          denominator = x(i) - x(i-j+1);
          Q(i,j) = numerator / denominator;
      endfor
   endfor
          disp(Q);
          res = Q(length(x), length(x));
endfunction