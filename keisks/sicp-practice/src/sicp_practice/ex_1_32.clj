;; sum 
(defn sum [term a nxt b]
  (if (> a b)
    0
    (+ (term a)
       (sum term (nxt a) nxt b))))

(sum identity 1 inc 10)
;;55

;; product (ex_1_31_a)
(defn product [term a nxt b]
  (if (> a b)
    1
    (* (term a)
       (product term (nxt a) nxt b))))

(product identity 1 inc 5)
;;120

;; factorial (ex_1_31_a)
(defn factorial [x]
  (product identity 1 inc x))

(factorial 5)
;;120


;; accmulate (ex_1_32_a)
(defn accmulate [combiner null-value term a nxt b]
  (if (> a b)
    null-value
    (combiner (term a)
              (accmulate combiner (nxt a) nxt b))))

;; use + as combiner, and it becomes SUM
;; use * as combiner, and it becomes PRODUCT
(accumulate + 0 identity 1 inc 10)
;;55
(accumulate * 1 identity 1 inc 5)
;;120
;;
;; accmulate_iterative (ex_1_32_b)
(defn accumulate_iter [combiner null-value term a nxt b]
  (defn iter [c result]
    (if (> c b)
      result
      (iter (nxt c) (combiner (term c) result))))
  (iter a null-value))

(accumulate_iter + 0 identity 1 inc 10)
;;55
(accumulate_iter * 1 identity 1 inc 5)
;;120
