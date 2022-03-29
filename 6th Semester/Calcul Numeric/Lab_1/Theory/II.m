a = [[1 2 13] ;[4 5 6] ;[7 8 9]] ;
b = [[4 8 12] ;[-1 0 5] ;[2 3 8]] ;

[m,n] = size(a); % returns size of a
t = b' ; % returns the transpose of b
c = a* b ; % multiply matrices a and b
d = a.*b;
e = a.^2; 
size(a);
length(a);
m = mean(a) ; % line vector with mean on rows
m1 = mean(a,2); % line vector with mean on cols
g = geomean(a); % line vector with geometric mean on rows
s = sum(a) 
p = prod(a);
max(a);
min(a);
diag(a);
m > 2; % compares every elem to 2
a > b; % compares A(ij) with B(ij)
inv(b); % inverse of matricx b
det(b); % determinant of matrix b
f = abs(b); % all absolute values for b
b = [16 15 24]' ;
x = a/b ; % solve system for a and b matrices
triu(a); % completes with 0 below the first diagonal 
tril(a); % completes with 0 above the first diagonal
m = [2 3 5; 7 11 13; 17 19 23];
m(2; 1);
m(:; 1); %all rows of column 1
m(2; :); % all columns of line 2
m(2; 1 : 2); %line 2, all but last column
m(2; 2 : end); %second row, all but first column
m(2 : 3; 2 : 3); %a submatrix


%particular matrices
eye(8); % identity matrix
eye(5; 7); 
zeros(5; 7);  % zeroes of size 5 7 
ones(7; 9) % ones of size 5 7

M = magic(4)