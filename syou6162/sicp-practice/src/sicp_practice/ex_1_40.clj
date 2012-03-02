(ns sicp-practice.ex-1-40
  (:use sicp-practice.1-3))

(defn cubic [a b c]
  (fn [x]
    (+ (* x x x)
       (* a x x)
       (* b x)
       c)))

; x^3 - x = 0の解はx = 0, 1, -1

(newtons-method (cubic 0 -1 0) 2.0) ; 1.0000012503431261
(newtons-method (cubic 0 -1 0) -2.0) ; -1.000001220291342
(newtons-method (cubic 0 -1 0) 0.1) ; -1.750287706382605E-18
