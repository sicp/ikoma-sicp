(ns oza
  (:use clojure.contrib.generic.math-functions))

(defn expmod [base exp m]
  (cond (= exp 0) (1)
        (even? exp)
          (rem (sqrt (expmod base (/ exp 2) m))
              m)
        :else
          (rem (* base (expmod base (- exp 1) m))
               m)))

(defn fermat-test [n]
  (defn tryit [a]
     (= (expmod a n n) a))
  (tryit (+ 1 (rand (- n 1)))))

(defn fast-prime? [n times]
  (cond (= times 0) (true)
        (fermat-test n) (fast-prime? n (- times 1))
        :else (false)))
