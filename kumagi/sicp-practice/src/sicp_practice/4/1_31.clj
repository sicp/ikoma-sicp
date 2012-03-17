(defn sum [term a nxt b]
  (if (> a b)
    0
    (+ (term a) (sum term (nxt a) nxt b))))
(defn inc [n] (+ n 1))
(defn cube [x] (* x x x))
(defn sum-cubes [a b]
  (sum cube a inc b))
(sum-cubes 1 10) ; => 3025

(defn identity [n] n)
(defn sum-integers [a b]
  (sum identity a inc b))
(sum-integers 1 10)
(defn pi-sum [a b]
  (defn pi-term [x]
    (/ 1.0 (* x (+ x 2))))
  (defn pi-next [x]
    (+ x 4))
  (sum pi-term a pi-next b))
(* 8 (pi-sum 1 10000)); 100000だとstack over flow
