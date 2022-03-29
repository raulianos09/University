clear;

x = [1 1.5 2 3 4];
y = [0  0.17609  0.30103  0.47712  0.60206];

disp(["lg 2.5 is equal to: ", num2str(newton(x,y,2.5))]);
disp(["lg 3.25 is equal to: ",num2str(newton(x,y,3.25))]);

f =@(x) log10(x);

E = -1;

for i = 10:35
    yy = i / 10;
    E = max(abs(f(yy) - newton(x,y,yy)), E);
endfor

disp(["Maximum interpolation error E = ",num2str(E)]);