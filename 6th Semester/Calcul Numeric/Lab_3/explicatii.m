#lagrange interpolation

# xi, i  = 0,m - interpolation nodes;
# f(xi) = 
# P - polynomial (smallest degree)
# P(xi) = f(xi)
# (Lm f)(x) = [sum from i=0 to m] li(x) * fi(x)
# li(x) = (x - x0) * ... * (x - (xi-1))*(x - (xi+1))* ... * (x-xm) / 
#         (xi - x0) * ... * (xi - (xi-1))*(xi - (xi+1))* ... * (xi-xm)



## barycentryc form: (Lmf)(x) = {[sum from i=0 to m] (Ai / (x-xi)) * f(xi) }/[sum from i=0 to m] (Ai / (x-xi)

# Ai = 1 / [Product fron j = 0 to m] (xi-xj)



%% problem 1: result integer
%% problem 2: aproximate in 3 nodes
%% problem 3: 21 equally spaced points in [0,10]