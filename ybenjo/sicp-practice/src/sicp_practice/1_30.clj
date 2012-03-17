; 線形再帰する sum
(defn sum [term a nxt b]
  (if (> a b)
    0
    (+ (term a) (sum term (nxt a) nxt b))))

(defn sum-integers [a b]
  (sum identity a inc b))

(defn sum-new [term a nxt b]
  (defn iter [a result]
    (if (> a b)
      result
      (iter (nxt a) (+ (term a) result))))
  (iter a 0))

(defn sum-integers-new [a b]
  (sum-new identity a inc b))
