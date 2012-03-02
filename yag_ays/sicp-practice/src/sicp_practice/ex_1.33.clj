(defn filtered-accumulate [fil combiner null-value term a nxt b]
  (if (> a b)
    null-value
    (if (fil a)
      (combiner (term a) (filtered-accumulate fil combiner null-value term (nxt a) nxt b))
      (filtered-accumulate fil combiner null-value term (nxt a) nxt b))))

(defn filtered-accumulate-iter [fil combiner null-value term a nxt b]
  (defn iter [c result]
    (if (> c b)
      result
      (iter (nxt c) (if (fil c)
                      (combiner (term c) result)
                      result))))
  (iter a null-value))

;; e.g.
(filtered-accumulate > + 0 identity 1 inc 10)
(filtered-accumulate-iter > + 0 identity 1 inc 10)

;; ex_1.21
(defn smallest-divisor [n]
  (find-divisor n 2))
(defn find-divisor [n test-divisor]
  (cond (> (* test-divisor test-divisor) n) n
        (divides? test-divisor n)           test-divisor
        :else (find-divisor n (+ test-divisor 1))))
(defn divides? [a b]
    (= (rem b a) 0))
(defn prime? [n]
  (= n (smallest-divisor n)))



;; Exercise a.
(defn sum-of-squares-of-the-prime-numbers [a b]
  (filtered-accumulate prime? + 0 #(* % %) a inc b))
(sum-of-squares-of-the-prime-numbers 1 10)

;; using filtered-accumulate-iter(fai) pattern
(defn sum-of-squares-of-the-prime-numbers-fai [a b]
  (filtered-accumulate-iter prime? + 0 #(* % %) a inc b))
(sum-of-squares-of-the-prime-numbers-fai 1 10)



;; Exercise b.
(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (rem a b))))

(defn product-relative-prime [n]
  (filtered-accumulate #(= (gcd n %) 1) * 1 identity 1 inc n))
(product-relative-prime 4)
(product-relative-prime 8)
(product-relative-prime 9)

(defn product-relative-prime-fai [n]
  (filtered-accumulate-iter #(= (gcd n %) 1) * 1 identity 1 inc n))
(product-relative-prime-fai 4)
(product-relative-prime-fai 8)
(product-relative-prime-fai 9)

;; My answer was validated with the following page.
;; http://wiki.drewhess.com/wiki/SICP_exercise_1.33


