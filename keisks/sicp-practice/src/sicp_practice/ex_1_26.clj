;squareの代わりにexpmodを2回計算しているため、
;expmodの計算回数は
;1 + 2 + 4 + 8 + ... + 2^{(lon_2 n)-1} 
;= 2^(log_2 n) - 1
;= n - 1
;になる。
;
;よってorder of growthはΘ (n)
;
