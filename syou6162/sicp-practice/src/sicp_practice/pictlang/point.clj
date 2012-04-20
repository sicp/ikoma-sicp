(ns sicp-practice.pictlang.point)

;; point
(defn make-point [x y]
  (list x y))

(defn x-point [p]
  (first p))

(defn y-point [p]
  (second p))

(defn print-point [p]
  (println (str "("
		(x-point p)
		", "
		(y-point p)
		")")))