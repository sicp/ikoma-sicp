(defn accumulate [combiner null-value term a nxt b]
  (if (> a b)
    null-value
    (combiner (term a)
              (accumulate combiner null-value identity (nxt a) nxt b))))

;; #'user/accumulate
;; user=> (accumulate + 0 identity 1 inc 10)
;; 55
;; user=> (accumulate * 1 identity 1 inc 5)
;; 120
