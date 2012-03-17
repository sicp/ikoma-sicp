(defn square [x] (* x x))

(defn repeated [f t]
  (if (zero? t)
    (fn [x] x)
    (comp f (repeated f (dec t)))))

((repeated square 2) 5) ;; 625


;; (comp square (repeated square 1))
;; (comp square (comp square (repeated square 0)))
;; (comp square (comp square (fn [x] x)))
;; (comp square (fn [x] (square x)))
;; (fn [x] (square (square x)))


;; (fn [x] x)はidentityでも良い
(defn repeated [f t]
  (if (zero? t)
    identity
    (comp f (repeated f (dec t)))))
