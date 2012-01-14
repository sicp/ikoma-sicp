(ns sicp-practice.1-1)

;; 問題1.1
10 ; 10

(+ 5 3 4) ; 12

(- 9 1) ; 8

(/ 6 2) ; 3

(+ (* 2 4) (- 4 6)) ; 6

(def a 3) ; #'user/a

(def b (+ a 1)) ; #'user/b

(+ a b (* a b)) ; 19

(= a b) ; false

(if (and (> b a) (< b (* a b)))
  a
  b) ; 3

(cond (= a 4) 6
      (= b 4) (+ 6 7 a)
      :else 25) ; 16

(+ 2 (if (> b a) b a)) ; 6

(* (cond (> a b) a
	 (< a b) b
	 :else -1)
   (+ a 1)) ; 16

;; 問題1.2
(/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
   (* 3 (- 6 2) (- 2 7))) ; -37/150
;; clojureだと有理数で返ってくるので注意

;; 問題1.3
(defn problem1-3 [a b c]
  (let [[max-1 max-2] (take-last 2 (sort (list a b c)))]
    (+ (* max-1 max-1) (* max-2 max-2))))
