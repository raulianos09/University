clear;

years = [1930 1940 1950 1960 1970 1980];
population = [123203 131669 150697 179323 203212 226505];

disp(["Population in 1955 is: ",num2str(lagrange(years,population,1955),'%.0f')]);
disp(["Population in 1995 is: ",num2str(lagrange(years,population,1995),'%.0f')]);