clear;
%% Exercise 1.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 1\n");

f =@(x) sin(x);
nodes = 0 : (pi/2) : (2*pi);

values = f(nodes);

%% ---- A ----
printf("- A) -\n");
printf("The value of the function at x = pi/4 is: %d\n" , f(pi/4));
printf("The value of the cubic natural spline at x = pi/4 is: %d\n" , spline(nodes,[0 values 0], pi/4));
printf("The value of the cubic clamped spline at x = pi/4 is: %d\n" , spline(nodes,[1 values 1], pi/4));
printf("\n\n");


%% ---- B ----
printf("- B) -\n");

figure(1);
hold on;
x = 0:0.1:(2*pi);
plot(x, f(x), "r;Actual Function;");
plot(x, spline(nodes,[0 values 0], x), "g;Cubic Natural Spline;");
plot(x, spline(nodes,[1 values 1], x), "b;Cubic Clamped Spline;");
legend('show');
hold off;
printf("View figure 1 for results!");
printf("\n\n");

%%%---------------------------------------------------------------------%%%
clear;
%% Exercise 2.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 2\n");

figure(2);
[x,y] = ginput(5);

%% sort by smallest x coordinate
[x, indices] = sort(x);
y = y(indices);


step = x(1) : 0.01 : x(length(x));


hold on;
plot(x,y,"b*;Random points;");
plot(step,spline(x', [ 0 y' 0],step),"r;Cubic natural spline;");
legend('show');
hold off;

printf("View figure 2 for results!");
printf("\n\n");

%%%---------------------------------------------------------------------%%%
clear;
%% Exercise 3.

printf("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
printf("Exercise 3\n");

time = [0 3 5 8 13];
distance = [0 225 383 623 993];
speed = [75 77 80 74 72];

cubicSpline = spline(time, [75 distance 72]);
cubicSplineDer = fnder(cubicSpline);
printf("The predicted position of the car at t = 10s is: %d\n" , ppval(cubicSpline, 10));
printf("The predicted speed of the car at t = 10s is: %d\n" , ppval(cubicSplineDer,10));

printf("\n\n");