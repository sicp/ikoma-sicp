(defn smallest-divisor [n]
  (find-divisor n 2))

(defn find-divisor [n test-divisor]
  (cond (> (* test-divisor test-divisor) n) n
        (divides? test-divisor n)           test-divisor
        :else                               (find-divisor n (+ test-divisor 1))))

(defn divides? [a b]
  (= (rem b a) 0))

(defn search-for-primes [n]
  (= (smallest-divisor n) n))


;; next function (nxt)
(defn nxt [n]
  (if (= n 2)
    3
    (+ n 2)))

(defn find-divisor-nxt [n test-divisor]
  (cond (> (* test-divisor test-divisor) n) n
        (divides? test-divisor n)           test-divisor
        :else                               (find-divisor-nxt n (nxt test-divisor))))
(defn smallest-divisor-nxt [n]
  (find-divisor-nxt n 2))
(defn search-for-primes-nxt [n]
  (= (smallest-divisor-nxt n) n))


;; runtime
(time (take 3 (filter search-for-primes (iterate (partial + 2) 1001))))
(time (take 3 (filter search-for-primes (iterate (partial + 2) 10001))))
(time (take 3 (filter search-for-primes (iterate (partial + 2) 100001))))
(time (take 3 (filter search-for-primes (iterate (partial + 2) 1000001))))

;; runtime (using nxt function)
(time (take 3 (filter search-for-primes-nxt (iterate (partial + 2) 1001))))
(time (take 3 (filter search-for-primes-nxt (iterate (partial + 2) 10001))))
(time (take 3 (filter search-for-primes-nxt (iterate (partial + 2) 100001))))
(time (take 3 (filter search-for-primes-nxt (iterate (partial + 2) 1000001))))
