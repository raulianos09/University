% Exercise 1
% Plot the functions f : [0,1] -> R, f(x) = [e ^ ((10*x)(x-1))] * sin(12*pi*x)
x = 0 : 0.01 : 1;
f = exp(10*x.*(x -1)).*sin(12 * pi * x);
figure;
plot(x,f,'r');


% Exercise 2
t = 0 : 0.01 : 10*pi;
a = input('a = ') ;
b = input('b = ') ;
x = (a + b) * cos(t) - b * cos((a / b + 1) .* t);
y = (a + b) * sin(t) - b * sin((a / b + 1) .* t);
figure;
plot(x,t,'r',y,t,'b');


% Exercise 3
x = 0 : 0.01 : 2* pi;
f1 = cos(x);
f2 = sin (x);
f3 = cos (2*x);
figure;
plot(x,f1,'r',x,f2,'b',x,f3,'g');

% Exercise 4
x1 = -1:0.01:0;
x2 = 0:0.01:1;
f1 = (x1.^3+sqrt(1-x1));
f2 = (x2.^3-sqrt(1-x2));

plot(x1,f1);
hold on;
plot(x2,f2);
hold off;


% Exercise 5
x = 0 : 1 : 50;
f = (mod(x,2) == 0) .* (x/2) + (mod(x,2) == 1) .* (3*x +1) ;
figure;
plot(x,f,'*r');   


% Exercise 6
disp('Ex 6:')
n = input('n = ')
g = 3/2;
for i = 1:n
    g = 1 + 1/g;
endfor
g

% Exercise 7
x = -2 : 0.01 : 2;
y = -4 : 0.01 : 4;
[X,Y] = meshgrid(x,y);

g = exp( -((X - 1/2).^2 + (Y - 1/2).^2) );
mesh(X,Y,g)

  