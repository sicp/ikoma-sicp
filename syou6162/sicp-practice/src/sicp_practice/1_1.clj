(ns sicp-practice.1-1)

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
