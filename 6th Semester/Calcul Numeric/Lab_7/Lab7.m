clear;
%% Exercise 1.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 1\n");

time = 1:7;
temp = [13 15 20 14 15 13 10];

m = length(time);
a = (m * sum(time .* temp) - sum(time)*sum(temp)) / (m * sum(time .^2) - (sum (time))^2);
b = (sum(time.^2) * sum(temp) - sum(time .* temp) * sum(time)) / (m * sum(time.^2) - sum(time)^2);

phi = @(x) a * x + b;

E = 0;
for i = 1 : m
  E = E + (temp(i) - phi(time(i))) ^ 2;
endfor

printf("The temperature at time = 8:00 is: %d\n" , phi(8));
printf("The minimum value E(a,b) for the obtained a and b is: %d\n", E);

figure(1);
hold on;
plot(time, temp , "r*;Given Points;");
plot(0:0.1:8 , phi(0:0.1:8), "b;Least Squares Function;");
legend("show");

printf("View figure 1 for results!");
printf("\n\n");

%%%---------------------------------------------------------------------%%%
clear;
%% Exercise 2.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 2\n");

temp = [0 10 20 30 40 60 80 100];
pressure = [0.0061 0.0123 0.0234 0.0424 0.0738 0.1992 0.4736 1.0133];


%% ---- A ----
printf("- A) -\n");

p1 = polyfit(temp, pressure, 8);
p2 = polyfit(temp, pressure, 4);

printf("The value for polynomial of degree 8 for T=45 is: %f\n" , polyval(p1,45));
printf("The approximation error for this polynomial is: %f\n" , abs(0.095848 - polyval(p1,45)));
printf("\n\n");
printf("The value for polynomial of degree 4 for T=45 is: %f\n" , polyval(p2,45));
printf("The approximation error for this polynomial is: %f\n" , abs(0.095848 - polyval(p2,45)));

printf("\n\n");


%% ---- B ----
printf("- B) -\n");

x = 1:0.1:100;
figure(2);
hold on;
plot(temp, pressure, "kx;interpolation points;");
plot(x, polyval(p1,x), "r;P1 (degree 8 poly);");
plot(x, polyval(p2,x), "g;P2 (degree 4 poly);");
plot(temp, polyval(p1,temp), "bo;approximants for P1;")
plot(temp, polyval(p2,temp), "yo;approximants for P2;")
legend("show");
hold off;
printf("View figure 2 for results!");
printf("\n\n");

%%%---------------------------------------------------------------------%%%
clear;
%% Exercise 3.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 3\n");

figure(3);
axis([0 3 0 5]);
[x y] = ginput(10);

%% sort by smallest x coordinate
[x, indices] = sort(x);
y = y(indices);

step = x(1) : 0.01 : x(length(x));

p = polyfit(x, y, 2);

hold on;
plot(x,y, "kx;Selected points;");
plot(step, polyval(p,step), "r;P (polynomial of degree 2);");
legend("show");
hold off;
printf("View figure 3 for results!");
printf("\n\n");
