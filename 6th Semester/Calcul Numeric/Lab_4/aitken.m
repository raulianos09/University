function res = aitken(x,y,epsilon,xx)

%sort the 2 vectors
  D = zeros(1, length(x));
  for i = 1 : length(x)
    D(i) = abs(x(i) - xx);
  endfor
  [Dsorted, indices] = sort(D);
  newX = zeros(1, length(x));
  newY = zeros(1, length(y));
  for i = 1: length(x)
    newX(i) = x(indices(i));
    newY(i) = y(indices(i));
  endfor
  
%compute
  f = zeros(length(x), length(x));
  f(:,1) = y(:);
  for i = 2: length(x)
    for j = 1 : i-1
      Determinant = f(j,j) * (x(i) - xx) - f(i,j) * (x(j)-xx);
      f(i, j+1) = (1 / ((x(i) - x(j)))) * Determinant;
    endfor
    
    % stopping condition
    if abs(f(i,i) - f(i-1,i-1)) <= epsilon
        res = f(i,i);
        return;
    endif
  endfor
endfunction