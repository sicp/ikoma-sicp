(defn smallest-divisor [n]
  (find-divisor n 2))

(defn find-divisor [n test-divisor]
  (cond (> (* test-divisor test-divisor) n) n
        (divides? test-divisor n)           test-divisor
        :else (find-divisor n (+ test-divisor 1))))

(defn divides? [a b]
  (= (rem b a) 0))


(smallest-divisor 199)
(smallest-divisor 1999)
(smallest-divisor 19999)