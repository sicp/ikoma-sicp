

;再帰
(defn cont-frac [n d k]
  (defn helper [x]
    (if (= x k) 0
        (+ (/ (n x) (+ (d x) (helper (+ x 1)))))))
  (helper 1))
;反復

(defn cont-frac-iter [n d k]
  (defn iter [result i]
    (if (= i 0) result
        (iter (/ (n i) (+ (d i) result)) (dec i))))
  (iter 0 k))

(defn golden [t]
  (defn one [_] 1.0)
  (cont-frac-iter one one t))

(golden 1) ; 0.5
(println (map golden (range 1 1000)))
