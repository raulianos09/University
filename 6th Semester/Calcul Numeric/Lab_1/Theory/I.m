%I. Check the following operations with vectors:

a = [1 2 3] ; %line vector
b = [4; 5; 6] ; %column vector
c = a * b;

d = b' ;% ' is the transpose of the vector
e = a.*d ;% .* multiplies the elements on same positions in the 2 vectors
f = a.^2 ;% each element raised to the second power
g = a.^d ;% each element from vector a is raised to power x where x is the element from d which has the same pos as elem from a
v = 1:6 ;% all elements from 1 to 6 considering default step 1
w = 2:3:10 ;% all elements from 2 to 10 with step 3
y = 10:-1:0 ;% same as above
exp(a); % e ^ (all elements from a)
sqrt(a); % sqrt of all elements from a
m = max(a); % max element from a
[m,k] = max(a); % max element and its position
h = [-2 -9 8];
k = abs(h); % absolute value of all elements from h
mean(a) ; %media aritmetica
geomean(a) ; % media geometrica
sum(a) ; %sum of a
prod(a) ; % product of all elements from a