(defn a-plus-abs-b [a b]
    ((if (> b 0) + -) a b))

(a-plus-abs-b 2 4) ;; 6
(a-plus-abs-b 2 -3) ;; 5
(a-plus-abs-b -2 -3) ;; 1
;; f(a, b) = a + abs(b) 
