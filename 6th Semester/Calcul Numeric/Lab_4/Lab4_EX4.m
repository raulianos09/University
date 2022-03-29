clear;

x = [25 36 49 64 81 100 121 144 169 196 225];
y = [5 6 7 8 9 10 11 12 13 14 15];

printf("The estimated value of sqrt(115) is: %f \n", aitken(x,y,0.001,115));