;; ex_1_37_a
;;(defn cont-frac [n d k]
;;  (defn frac [i]
;;    (if (> i k)
;;      0
;;      (/ (n_i i) (+ (d_i i) (frac (inc i))))))
;;    (frac 1))


;; ex_1_38

;;d_i = 2*((quotient of i/3)+1) if i = 2 (mod 3)
(defn d_i [i]
  (if (= (mod i 3) 2)
    (* 2 (+ (quot i 3) 1))
    1))

(defn n_i [i] 1.0)

(defn cont-frac [n d k]
  (defn frac [i]
    (if (> i k)
      0
      (/ (n_i i) (+ (d_i i) (frac (inc i))))))
    (frac 1))

(+ (cont-frac n_i d_i 10) 2)
;; 2.7182817182817183
