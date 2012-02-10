(ns sicp-practice.ex-1-1)

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
