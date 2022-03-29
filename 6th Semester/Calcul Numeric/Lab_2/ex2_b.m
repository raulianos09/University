n = 5;
x = -1 : 0.01 : 1;

hold all;
t0 = ones(1 , length(x));
t1 = x;

plot( x,t0);
plot(x, t1);


if n > 2
    for i = 3:n
       t2 = 2 .* x .* t1  -  t0;
       plot(x, t2);
       t0 = t1;
       t1 = t2;
    endfor
endif