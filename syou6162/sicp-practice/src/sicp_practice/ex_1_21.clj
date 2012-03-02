(ns sicp-practice.ex-1-21)

(defn square [x] (* x x))

(defn divides? [a b]
  (= (rem b a) 0))

(defn find-divisor [n test-divisor]
  (cond (> (square test-divisor) n) n
	(divides? test-divisor n) test-divisor
	:else (find-divisor n (+ test-divisor 1))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(smallest-divisor 10) ; 2
(smallest-divisor 23) ; 23

(defn prime? [n]
  (= n (smallest-divisor n)))

(prime? 10) ; false
(prime? 23) ; true

(smallest-divisor 199) ; 199
(smallest-divisor 1999) ; 1999
(smallest-divisor 19999) ; 7
