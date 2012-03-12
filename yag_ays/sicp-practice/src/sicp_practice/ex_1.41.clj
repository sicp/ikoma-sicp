(defn dbl [x] (fn [y] (x (x y))))

((dbl inc) 1)

(((dbl (dbl dbl)) inc) 5) ;; 21


;; ((dbl inc) 5)             ;; 7
;; (((dbl dbl) inc) 5)       ;; 9
;; (((dbl (dbl dbl)) inc) 5) ;; 21
