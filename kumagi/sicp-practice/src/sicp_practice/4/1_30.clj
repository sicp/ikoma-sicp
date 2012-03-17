(defn sum-iter [term a nxt b]
  (defn iter [a result]
    (if (> a b) result
        (iter (nxt a) (+ result (term a)))))
  (iter a 0))
(defn inc [n] (+ n 1))
(defn cube [x] (* x x x))
(defn sum-cubes [a b]
  (sum-iter cube a inc b))
(sum-cubes 1 10) ; => 3025
