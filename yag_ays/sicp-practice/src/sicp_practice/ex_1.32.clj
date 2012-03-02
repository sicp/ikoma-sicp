(defn accumulate [combiner null-value term a nxt b]
  (if (> a b)
    null-value
    (combiner (term a) (accumulate combiner null-value term (nxt a) nxt b))))

(defn accumulate-iter [combiner null-value term a nxt b]
  (defn iter [c result]
    (if (> c b)
      result
      (iter (nxt c) (combiner (term c) result))))
  (iter a 1))

(accumulate + 0 identity 1 inc 10)
(accumulate * 1 identity 1 inc 10)

(accumulate-iter + 0 identity 1 inc 10)
(accumulate-iter * 1 identity 1 inc 10)


;; (defn sum-recur [term a nxt b]
;;   (if (> a b)
;;     0
;;     (+ (term a) (sum-recur term (nxt a) nxt b))))
;; (defn product-recur [term a nxt b]
;;   (if (> a b)
;;     1
;;     (* (term a) (product-recur term (nxt a) nxt b))))
;; (sum-recur identity 1 inc 10)
;; (product-recur identity 1 inc 10)
