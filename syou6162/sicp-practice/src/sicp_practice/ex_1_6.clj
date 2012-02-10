(ns sicp-practice.ex-1-6
  (:use 'sicp-practice.1-1))

;; 問題1.6
(defn new-if [predicate then-clause else-clause]
  (cond predicate then-clause
	:else else-clause))

(new-if (= 2 3) 0 5) ; 5

(new-if (= 1 1) 0 5) ; 0

(defn sqrt-iter [guess x]
  (new-if (good-enough? guess x)
	  guess
	  (sqrt-iter (improve guess x) x)))

(sqrt 9) ;; StackOverflowErrorで死んでしまう
;; なぜか? => else-clauseも評価してしまって無限に再帰してしまう
;; だからifは特殊形式でないといけない(マクロを使えばできるはず)
