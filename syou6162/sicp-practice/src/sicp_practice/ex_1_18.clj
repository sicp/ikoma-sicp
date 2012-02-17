(ns sicp-practice.ex-1-18)

(defn double [n] (* n 2))
(defn halve [n] (/ n 2))

(defn my-prod-iter [a b n]
  (cond (= b 0) n
	(even? b) (my-prod-iter (double a) (halve b) n)
	:else (my-prod-iter a (dec b) (+ a n))))

(my-prod-iter 2 3 0)
