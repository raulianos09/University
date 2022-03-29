clear;

x = [1 2 3 4 5];
y = [22 23 25 30 28];

%% a)
disp(["The quantity of potatoes expected from 2.5 pounds of fertilizer is: " , num2str(newton(x,y,2.5))]);


%% b)
xx = 1:0.01:5;
yy = [];

for i = 1:length(xx)
  yy = [yy  newton(x,y,xx(i))];
endfor

hold all;
plot(x,y,"r*;Given Values;");
plot(xx,yy,"b;Newton Values;");
legend("show");