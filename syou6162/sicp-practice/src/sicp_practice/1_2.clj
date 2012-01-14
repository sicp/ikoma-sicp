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
