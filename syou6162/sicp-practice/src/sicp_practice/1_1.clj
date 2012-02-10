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

;; 1.1.7 例: Newton法による平方根

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn square [x] (* x x))

(defn good-enough? [guess x]
  (< (Math/abs (- (square guess) x)) 0.001))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

(sqrt 9) ; 3.00009155413138

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

;; 1.1.8 ブラックボックス抽象としての手続き

;; Clojureの場合、defの中でdefしても外に見えてしまう&遅いので代わりにletfnを使うのが普通です
;; ref http://d.hatena.ne.jp/fatrow/20100213/1266074787

;; あるいは(defn- xxx)とやると名前空間の中のみで有効な関数が作れます

(defn sqrt-1-1-8 [x]
  (letfn [(average [x y]
		   (/ (+ x y) 2))
	  (improve [guess x]
		   (average guess (/ x guess)))
	  (square [x] (* x x))
	  (good-enough? [guess x]
			(< (Math/abs (- (square guess) x)) 0.001))
	  (sqrt-iter [guess x]
		     (if (good-enough? guess x)
		       guess
		       (sqrt-iter (improve guess x) x)))]
    (sqrt-iter 1.0 x)))

;; 問題1.10
(defn A [x y]
  (cond (= y 0) 0
	(= x 0) (* 2 y)
	(= y 1) 2
	:else (A (- x 1)
		 (A x (- y 1)))))

(A 1 10) ; 1024
(A 2 4) ; 65536
(A 3 3) ; 65536

;; 以下のf、g、hの簡潔的な数学的定義を述べよ

;; condの2つ目のケースにすぐ行くので2*nと分かる
(defn f [n] (A 0 n))
(map f (range 10)) ; (0 2 4 6 8 10 12 14 16 18)

;; (A 1 n) => (A 0 (A 1 (- n 1))) => (* 2 (A 1 (- n 1)))
;; => (* 2 (A 0 (A 1 (- n 2)))) => (* 2 (* 2 (A 1 (- n 2)))) => ...
;; 2^n
(defn g [n] (A 1 n))
(map g (range 10)) ; (0 2 4 8 16 32 64 128 256 512)

;; 2^2^...^2
;; (A 2 n) => (A 1 (A 1 (- n 1)) => (2^(A 1 (- n 1)) => (2^(2^{n-1}) => 2^n
(defn h [n] (A 2 n))
(map h (range 5)) ; (0 2 4 16 65536)
