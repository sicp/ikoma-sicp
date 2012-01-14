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
