(defn square [n]
  (* n n))

(defn expmod [base exp m]
  (cond (= exp 0) 1
        (even? exp) (rem (square (expmod base (/ exp 2) m))
                         m)
        :else (rem (* base (expmod base (- exp 1) m))
                   m)))

(expmod 8 17 17)

(defn fermat-test [n]
  (defn try-it [a]
    (= (expmod a n n) a))
  (try-it (+ 1 (rand-int (- n 1)))))

(fermat-test 17)

(defn fast-prime? [n times]
  (cond (= times 0) true
        (fermat-test n) (fast-prime? n (- times 1))
        :else false))
(map (fn [n] (fast-prime? n 1)) (range 1 2000000)) ;; コレぐらいの数じゃへこたれない

;; 問25 これは正しいか。大丈夫か。
(defn fast-expt [b n]
  (cond (= n 0) 1
        (even? n) (square (fast-expt b (/ n 2)))
        :else (* b (fast-expt b (- n 1)))))

(defn expmod2 [base exp m]
  (rem (fast-expt base exp) m ))

;; 答え、正しいが大丈夫じゃない。こちらのほうが数式としての定義に近いが、(fast-expt)の答えが膨大になった場合に桁溢れしたり(bignumとしてどうにかやりくりした場合)速度が落ちたりする
;; 大丈夫な方の答えは常にmでremした結果を返しているので、最大でもmの2乗を超える事はない
(fast-prime? 17 10) ;; => ok
;(fast-prime? 18 10) ;; => ng
;; clojureはint桁溢れした。
