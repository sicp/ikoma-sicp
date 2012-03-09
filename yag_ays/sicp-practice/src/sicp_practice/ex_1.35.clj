(ns sicp-practice.ex_1.35
  (:use [clojure.contrib.generic.math-functions :only (abs sin cos)]))

(def tolerance 0.00001)

(defn fixed-point [f first-guess]
  (defn close-enough? [v1 v2]
    (< (abs (- v1 v2)) tolerance))
  (defn my-try [guess]
    (let [nxt (f guess)]
      (if (close-enough? guess nxt)
        nxt
        (my-try nxt))))
  (my-try first-guess))

(fixed-point cos 1.0)
(fixed-point (fn [y] (+ (sin y) (cos y))) 1.0)


;; golden ratio
;; ¥phi^2 = ¥phi + 1 ¥¥
;; ¥phi = 1 + ¥frac {1} {¥phi}

(fixed-point (fn [x] (+ 1 (/ 1 x))) 1.0)
;; 1.6180327868852458
