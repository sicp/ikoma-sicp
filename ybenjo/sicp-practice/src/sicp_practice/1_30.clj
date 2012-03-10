; 線形再帰する sum
(defn sum [term a next b]
  (if (> a b)
    0
    (+ (term a) (sum term (next a) next b))))

(defn sum-integers [a b]
  (sum identity a inc b))

(defn sum-new [term a next b]
  (defn iter [a result]
    (if (> a b)
      result
      (iter (next a) (+ (term a) result))))
  (iter a 0))

(defn sum-integers-new [a b]
  (sum-new identity a inc b))
