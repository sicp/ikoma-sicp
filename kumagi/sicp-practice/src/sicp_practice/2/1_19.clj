;; Tは
;; a <- a + b
;; b <- a
;; Tpqはこう
;; a <- bq + aq + ap
;; b <- bp + aq
;; 2回作用させると
;; a <- (bp + aq)q + (bq + aq + ap)q + (bq + aq + ap)p
;;    = bpq + aq^2 + bq^2 + aq^2 + apq + bpq + apq + ap^2
;;    = b(pq + q^2 + pq) + a(q^2 + q^2 + pq + pq + p^2)
;; p'+q' = 2q^2 + 2pq + p^2 ... [1]
;; q'=q^2 + 2pq  ....[2]
;; b <- (bp + aq)p + (bq + aq + ap)q
;;    = bp^2 + apq + bq^2 + aq^2 + apq
;;    = b(p^2 + q^2) + a(pq + q^2 + pq)
;; p' = p^2 + q^2  ....[3]
;; q' = q^2 + 2pq  ... [4]
;;
;; [3][4]を足してp'+q'=p^2 + q^2 + q^2 + 2pq = 2q^2 + p^2 + 2pq == [1] 一致
;; この[3][4]を入れればいい

(defn fib-iter [a b p q count]
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
(defn naive_fib [n]
  (cond (= n 0) 0
        (= n 1) 1
        :else (+ (naive_fib (- n 1))
                 (naive_fib (- n 2)))))

(defn timed_fib [n]
  (print (str n " "))
  (time (fib n)))
(defn timed_naive_fib [n]
  (print (str n " "))
  (time (naive_fib n)))

(println (map timed_fib (range 350)))
(println (map timed_naive_fib (range 35)))


