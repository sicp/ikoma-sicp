(ns sicp-practice.ex-1-17)

;; bに線形ステップ数の掛け算
(defn my-prod [a b]
  (if (= b 0)
    0
    (+ a (my-prod a (dec b)))))

(my-prod 2 3)

;; 対数ステップ数の掛け算を作る
(defn double [n] (* n 2))
(defn halve [n] (/ n 2))

(defn my-prod-iter [a b]
  (cond (= b 0) 0
	(even? b) (double (my-prod-iter a (halve b)))
	:else (+ a (my-prod-iter a (dec b)))))

(my-prod-iter 2 3)
