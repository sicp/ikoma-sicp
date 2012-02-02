(ns sicp-practice.1-2)

;; 1.2.1 線形再帰と反復
;; 線形再帰のバージョン
(defn factorial [n]
  (if (= n 1)
    1
    (* n (factorial (- n 1)))))

(factorial 5) ; 120

;; 線形反復のバージョン

(defn fact-iter [product counter max-count]
  (if (> counter max-count)
    product
    (fact-iter (* counter product)
	       (+ counter 1)
	       max-count)))

(defn factorial [n]
  (fact-iter 1 1 n))

(factorial 5) ; 120

;; 余談的な感じの末尾再帰の階乗
;; clojureだとloop&recur使うのが普通です
(defn my-fact [n]
  (loop [counter 1
	 result 1]
    (if (= counter (inc n))
      result
      (recur (inc counter) (* result counter)))))

(my-fact 5) ; 120

;; 問題1.9

(use 'clojure.tools.trace)

(defn ^:dynamic my-plus1 [a b]
  (if (= a 0)
    b
    (inc (#'my-plus1 (dec a) b))))

(my-plus1 10 5) ; 15
;; 再帰的な様子
(dotrace [my-plus1] (my-plus1 10 5))

(defn ^:dynamic my-plus2 [a b]
  (if (= a 0)
    b
    (#'my-plus2 (dec a) (inc b))))

;; 反復的な様子...のはずが再帰的になってしまう
(dotrace [my-plus2] (my-plus2 10 5))
;; 証拠
;; (my-plus2 10000 5000)
;; StackOverflowError

(defn ^:dynamic my-plus3 [a b]
  (if (= a 0)
    b
    (recur (dec a) (inc b))))
(my-plus3 10000 5000)
(dotrace [my-plus3] (my-plus3 10 5)) ;; traceはしてくれない

;; 1.2.2 木構造再帰
(defn fib-recur [n]
  (cond (= n 0) 0
	(= n 1) 1
	:else (+ (fib-recur (- n 1))
		 (fib-recur (- n 2)))))

(defn fib-iter [a b count]
  (if (= count 0)
    b
    (fib-iter (+ a b) a (- count 1))))

(defn fib [n]
  (fib-iter 1 0 n))

