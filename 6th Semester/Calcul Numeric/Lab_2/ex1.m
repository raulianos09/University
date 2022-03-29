% subplot(m,n,p)
% m*n matrix, p -> part in the matrix
% plot(...)

x = -1 : 0.01 : 1;

subplot(2,2,1);
l1 = x;
plot(x, l1);
title('Subplot l1');


subplot(2,2,2);
l2 = (3/2)  * (x.^2) - (1/2);
plot(x, l2);
title('Subplot l2');

subplot(2,2,3);
l3 = (5/2)  * (x.^3) - (3/2)  *  x;
plot(x, l3);
title('Subplot l3');

subplot(2,2,4);
l4 = (35/8) * (x.^4) - (15/4) * (x.^2) + (3/8);
plot(x, l4);
title('Subplot l4');

