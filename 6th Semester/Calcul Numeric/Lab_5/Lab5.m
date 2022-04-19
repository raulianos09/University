clear;
%% Exercise 1.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 1\n");

time = [0 3 5 8 13];
distance = [0 225 383 623 993];
speed = [75 77 80 74 72];

res = hermite(time,distance,speed,10);
printf("The distance computed using hermite interpolation is: %d\n" ,res);
printf("The speed computed using hermite interpolation is: %d\n" ,res);
printf("\n\n");

%%Exercise 2.
clear;

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 2\n");

f = @(x) log(x);

x = [1 2];
fx = [0 0.6931];
dx = [1 0.5];

res = hermite(x,fx,dx,1.5);

%%disp(res);
%%disp(f(1.5));

printf("The value of ln(1.5) computed using hermite interpolation is: %d\n" ,res);
printf("The value of the absolute approximation error is: %d\n" , abs(res - f(1.5)));
printf("\n\n");

%%Exercise 3.
clear;

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 3\n");

x = -5 : 0.5 : 5;
f = @(x) sin(2 * x);
dx = @(x) 2 * cos(2 * x);

xx = linspace(-5,5,15);

hold on;
plot(x, f(x), "r;'Actual Function';")
plot(xx, hermite(x,f(x),dx(x),xx),"b;'Hermite Poly';");
legend("show");
hold off;

printf("View figure 1!\n");
printf("\n\n");


%%% Facultative
%% Exercise 4.
clear;

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 4\n");

f = @(x) x * log(x);

x = [8.3 8.6];
fx = [17.56492 18.50515];
dx = [3.116256 3.151762];

res = hermite(x,fx,dx,8.4);

printf("The value of f(8.4) computed using hermite interpolation is: %d\n" ,res);
printf("The value of the absolute approximation error is: %d\n" , abs(res - f(8.4)));
printf("\n\n");


%%Exercise 5.
clear;

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 5\n");

f = @(x) 3 .* x .* exp(x) - exp(2 .* x);
dx = @(x) 3 .* x .* exp(x) - 2 * exp(2*x) + 3 * exp(x);
printf("- A) -\n");
figure();
%a)

valX = [1 1.05];
valFX = f(valX);
valDX = dx(valX);

res = hermite(valX,valFX,valDX,1.03);

hold on;
xxa = 1 : 0.01 : 1.10;
yya = hermite(valX,valFX,valDX,xxa);
plot(xxa, yya, "go;'Interpolation Poly A';")

printf("The value of f(1.03) computed using hermite interpolation is: %d\n" ,res);
printf("The value of the absolute approximation error is: %d\n" , abs(res - f(1.03)));
printf("\n\n");

%b)
printf("- B) -\n");

valX = [1 1.05 1.07];
valFX = f(valX);
valDX = dx(valX);

res = hermite(valX,valFX,valDX,1.03);

xxb = 1 : 0.01 : 1.10;
yyb = hermite(valX,valFX,valDX,xxa);
plot(xxb, yyb, "b*;'Interpolation Poly B';")

printf("The value of f(1.03) computed using hermite interpolation is: %d\n" ,res);
printf("The value of the absolute approximation error is: %d\n" , abs(res - f(1.03)));
printf("\n\n");


%c)
printf("- C) -\n");
hold on;
x = 1 : 0.0001 : 1.10;
plot(x, f(x), "r;'Actual Function';")

legend("show");
hold off;

printf("View figure 2!\n");
printf("\n\n");


