(defn divides? [a b]
  (= (rem b a) 0))

(defn find-divisor [n test-divisor]
  (cond (> (* test-divisor test-divisor) n) n
        (divides? test-divisor n)           test-divisor
        :else (find-divisor n (+ test-divisor 1))))

(defn smallest-divisor [n]
  (find-divisor n 2))

user=> (user/smallest-divisor 199)
199
user=> (user/smallest-divisor 1999)
1999
user=> (user/smallest-divisor 19999)
7


