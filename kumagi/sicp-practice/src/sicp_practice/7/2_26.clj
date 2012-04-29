
(def x (list 1 2 3))
(def y (list 4 5 6))
; appendはconcatらしい
(concat x y); (1 2 3 4 5 6)

(cons x y); ((1 2 3) 4 5 6)

(list x y); ((1 2 3)(1 2 3))

