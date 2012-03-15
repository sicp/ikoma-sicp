; まず prime を実装する

(defn divides? [a b]
  (= (rem b a) 0))

(defn find-divisor [n test-divisor]
  (cond ( > (* test-divisor test-divisor) n) n
        (divides? test-divisor n) test-divisor
        :else (find-divisor n (+ test-divisor 1))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))

; ここどうかいいか分からなかった
(time (take 3 (filter prime? (iterate (partial + 2) 1001))))
(time (take 3 (filter prime? (iterate (partial + 2) 10001))))
(time (take 3 (filter prime? (iterate (partial + 2) 100001))))
(time (take 3 (filter prime? (iterate (partial + 2) 1000001))))

(defn sqrt [x]
  (* x x))

; Fermat test を実装する
(defn expmod [base exp m]
  (cond (= exp 0) 1
        (even? exp) (rem (sqrt (expmod base (/ exp 2) m)) m)
        :else (rem (* base (expmod base (- exp 1) m)) m)))

(defn fermat-test [n]
  (defn try-it [a]
    (= (expmod a n n) a))
  (try-it (+ 1 (rand-int (- n 1)))))

(defn fast-prime? [n times]
    (cond (= times 0) true
          (fermat-test n) (fast-prime? n (- times 1))
          :else false))
  
; ここどう値を渡したらいいのかわかってない
; (time (take 3 (filter fast-prime? (iterate (partial + 2) 1001))))
; (time (take 3 (filter fast-prime? (iterate (partial + 2) 10001))))
; (time (take 3 (filter fast-prime? (iterate (partial + 2) 100001))))
; (time (take 3 (filter fast-prime? (iterate (partial + 2) 1000001))))
