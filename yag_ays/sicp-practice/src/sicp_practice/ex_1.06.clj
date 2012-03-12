(defn new-if [predicate then-clause else-clause]
  (cond predicate then-clause
        :else else-clause))

(new-if (= 2 3) 0 5) ;; 5
(new-if (= 1 1) 0 5) ;; 0


(defn square [x]
  (* x x))

(defn good-enough? [guess x]
  (< (Math/abs (- (square guess) x))
     0.001))

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))


(defn sqrt-iter [guess x]
  (new-if (good-enough? guess x)
          guess
          (sqrt-iter (improve guess x)
                     x)))

(sqrt-iter 1.0 9)
;; No message.
;;   [Thrown class java.lang.StackOverflowError]
