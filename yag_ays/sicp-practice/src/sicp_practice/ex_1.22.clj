(defn smallest-divisor [n]
  (find-divisor n 2))

(defn find-divisor [n test-divisor]
  (cond (> (* test-divisor test-divisor) n) n
        (divides? test-divisor n)           test-divisor
        :else (find-divisor n (+ test-divisor 1))))

(defn divides? [a b]
  (= (rem b a) 0))

(defn search-for-primes [n]
  (= (smallest-divisor n) n))


;; runtime
(time (take 3 (filter search-for-primes (iterate (partial + 2) 1001))))
(time (take 3 (filter search-for-primes (iterate (partial + 2) 10001))))
(time (take 3 (filter search-for-primes (iterate (partial + 2) 100001))))
(time (take 3 (filter search-for-primes (iterate (partial + 2) 1000001))))
