(create-ns 'kumagi')
(ns kumagi)

;; 何乗なのかを求める関数
(defn cnt [target a]
  (if (= (rem target a) 0) (+ 1 (cnt (/ target a) a)) 0))

;; 答え
(defn cons-alt [a b]
  (defn pow [x n]
    (if (= n 1) x
        (* x (pow x (- n 1)))))
  (* (pow 2 a) (pow 3 b)))
(defn car [x]
  (cnt x 2))
(defn cdr [x]
  (cnt x 3))
(def x (cons-alt 12 8))
(car x) ; => 12
(cdr x) ; => 8
