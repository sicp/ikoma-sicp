; An answer for 1.32
(defn accumulate [combiner null-value term a nxt b]
  (if (> a b)
    null-value
    (combiner (term a)
              (accumulate combiner null-value term (nxt a) nxt b))))

; An implementation of filtered-accumulate
(defn filtered-accumulate [combiner null-value term a nxt b filter]
  (if (filter a)
    (if (> a b)
      null-value
      (combiner (term a)
         (filtered-accumulate combiner null-value term (nxt a) nxt b filter)))
    (filtered-accumulate combiner null-value term (nxt a) nxt b filter)))

; quated from: http://prog-tips.posterous.com/clojure
(defn prime? [m]
  (loop [n 2]
    (if (<= n (Math/sqrt m))
      (cond (= (mod m n) 0) false
             n  (recur (inc n)))
        true )))
; (println (filter prime? (range 100)))
; (0 1 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97)


;; An answer for a.
(defn sum-primes [a b]
  (filtered-accumulate + 0 identity a inc b prime?))
;; #'user/sum-primes
;; user=> (sum-primes 1 10)
;; 18


(defn gcd [x y]
 (cond
  (zero? x) y
  (zero? y) x
  :else (recur y (mod x y))))

;; An answer for b.
(defn my-product [a b]
  (defn my-match? [i]
    (if (= 1 (gcd i b))
      true
      false))
  (filtered-accumulate * 1 identity a inc b my-match?))
; cannot compile it... why?
