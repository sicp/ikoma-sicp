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

;; 両替の計算
;; メインのアイディアは"場合で分けて残りを再帰で解く"
(defn first-denomination [kinds-of-coins]
  (cond (= kinds-of-coins 1) 1
	(= kinds-of-coins 2) 5
	(= kinds-of-coins 3) 10
	(= kinds-of-coins 4) 25
	(= kinds-of-coins 5) 50))

(defn ^:dynamic cc [amount kinds-of-coins]
  (cond (= amount 0) 1
	(or (< amount 0) (= kinds-of-coins 0)) 0
	:else (+ (#'cc amount
		     (- kinds-of-coins 1))
		 (#'cc (- amount
			(first-denomination kinds-of-coins))
		     kinds-of-coins))))

(defn count-charge [amount]
  (cc amount 5))

(count-charge 100) ; 292

;; 1セントと5セントで10セントを両替する例
(with-redefs [first-denomination (fn [kinds-of-coins]
				   (cond (= kinds-of-coins 1) 1
					 (= kinds-of-coins 2) 5))]
  (cc 10 2)) ; 3
;; 5セント×2、5セント×1 + 1セント×5、1セント×10の3通り

;; フェルマーテストの回数を増やしていくと正しい割合が増えていくことを確認する

(use 'sicp-practice.ex-1-21)

(defn expmod [base exp m]
 (cond (= exp 0) 1
       (even? exp) (rem (square (expmod base (/ exp 2) m)) m)
       :else (rem (* base (expmod base (- exp 1) m)) m)))

(defn fermat-test [n]
  (letfn [(try-it [a]
		  (= (expmod a n n) a))]
    (try-it (+ 1 (rand-int (- n 1))))))

(defn fast-prime? [n times]
  (cond (= times 0) true
	(fermat-test n) (fast-prime? n (- times 1))
	:else false))

(def x 19999) ; 素数ではない => フェルマーテストだと(確率は低いが)間違える可能性がある
(prime? x) ; false

;; frequenciesは回数のtableを返してくれる便利な関数です

(frequencies (map (fn [_] (fermat-test x)) (range 1000))) ; {false 999, true 1}
(frequencies (map (fn [_] (fermat-test x)) (range 10000))) ; {false 9978, true 22}
;; これらのandを取っていくので、間違える可能性は非常に低くなっていくことが分かる

(frequencies (map (fn [_] (fast-prime? x 1)) (range 1000))) ; {false 997, true 3}
(frequencies (map (fn [_] (fast-prime? x 2)) (range 1000))) ; {false 1000}
