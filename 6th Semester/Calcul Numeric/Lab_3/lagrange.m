function res = lagrange(x, y, x0)
    numerator = 0;
    denominator = 0; 
    for i = 1 : length(x)
        if x0 == x(i)
            res = y(i);
            return;
        endif
        
        %% compute value of Ai
        ai = 1;
        for j = 1 : length(x)
            if j != i
                ai = ai * (x(i) - x(j));
            endif
        endfor
        ai = 1 / ai;
        
        %compute value of numerator
        numerator = numerator + ai * y(i) ./ (x0 - x(i));
        %compute value of denominator
        denominator = denominator + ai ./ (x0 - x(i));
     endfor
     
     %compute the value of the interpolation
     res = numerator / denominator;
endfunction