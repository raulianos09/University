%%sum from 0 to n x^n / n!


x = -1 : 0.01 : 3;
hold all;

for i = 1:6
    taylor = 0;
    for j = 0:i
        taylor = taylor + x.^j / factorial(j);  
    endfor
    plot(x,taylor);
endfor
