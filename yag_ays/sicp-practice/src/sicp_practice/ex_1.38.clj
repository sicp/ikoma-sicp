(defn cont-frac-iter [n d k]
  (defn frac-iter [i result]
    (if (= i 0)
      result
      (frac-iter (dec i) (/ (n i) (+ (d i) result)))))
  (frac-iter k 0))

(defn d-i [i]
  (if (= (rem i 3) 2)
    (* 2 (+ 1 (quot i 3)))
    1))

(defn n-i [_] 1.0)


;; approximate e
(+ (cont-frac-iter n-i d-i 100) 2)

;; 2.7182818284590455
