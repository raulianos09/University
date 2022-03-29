%% a. Chebyshev polynomials of the first kind are defined by
%%          Tn(t) = cos(n * arccos(t)) , t =[1;1]

t = -1 : 0.01 : 1;
T1 = cos(acos(t));
T2 = cos(2 * acos(t));
T3 = cos(3 * acos(t));

subplot(2,2,1);
plot(t, T1);
title('Subplot T1');

subplot(2,2,2);
plot(t, T2);
title('Subplot T2');

subplot(2,2,[3,4]);
plot(t, T3);
title('Subplot T3');

