(ns sicp-practice.ex-1-28
  (:use [sicp-practice.ex-1-21]))

(defn expmod [base exp m]
 (cond (= exp 0) 1
       (even? exp) (let [n (expmod base (/ exp 2) m)
			 x (rem (square n) m)]
		     (if (and (not (= n 1)) (not (= n (- m 1))) (= x 1))
		       0 x))
       :else (rem (* base (expmod base (- exp 1) m)) m)))

(defn miller-rabin-test [n]
  (letfn [(try-it [n a] (= (expmod a (- n 1) n) 1))
	  (helper [n a] (cond (= a 0) true ;; fast-prime?のパクリ
			      (try-it n a) (try-it n (- a 1))
			      :else false))]
    (helper n (dec n))))

(map #(vector % (miller-rabin-test %)) (range 3 20))
; ([3 true] [4 false] [5 true] [6 false] [7 true] [8 false] [9 false] [10 false] [11 true] [12 false] [13 true] [14 false] [15 false] [16 false] [17 true] [18 false] [19 true])