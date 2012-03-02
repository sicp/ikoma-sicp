(defn fib-iter [ a b p q count]
  (cond (= count 0) b
        (even? count)
        (fib-iter a
                  b
                  (+ (* p p) (* q q))
                  (+ (* q q) (* 2 p q))
                  (/ count 2))
        :else (fib-iter (+ (* b q) (* a q) (* a p))
                        (+ (* b p) (* a q))
                        p
                        q
                        (- count 1))))

(defn fib [n]
  (fib-iter 1 0 0 1 n))

;; 解説
;; p' = p^2 + q^2
;; q' = q^2 + 2pq

;; P.22のfib実装と値が同じになるか確かめる
(defn fib-linear [n]
  (fib-linear-iter 1 0 n))

(defn fib-linear-iter [a b count]
  (if (= count 0)
    b
    (fib-linear-iter (+ a b) a (dec count))))


(= (map #(fib-linear %) (range 1 100)) (map #(fib %) (range 1 100)))
