clear; 

f = @(x) 1 ./ (1 + x.^2);

referenceX = -5 : 0.1 : 5;
referenceY = f(referenceX);

E = -1 ;

for n = 2 : 2 : 8
    i = 0:n;
    x = (i .* 10) ./ n -5;
    y = f(x);
    yy = [];
    
    for k = 1 : length(x)
      yy = [yy,lagrange(referenceX,referenceY,x(k))];
    endfor
    
    E = max(E , max(abs(y - yy)));
endfor

disp(["The maximum interpolation error is: ", num2str(E)]);