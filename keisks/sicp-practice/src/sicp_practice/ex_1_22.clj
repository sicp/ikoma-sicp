;ex_1_22

(defn divides? [a b]
  (= (rem b a) 0))

(defn square [x]
  (* x x))

(defn find-divisor [n test-divisor]
  (cond (> (square test-divisor) n) n
        (divides? test-divisor n) test-divisor
        :else (find-divisor n (+ test-divisor 1))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))

;time, iterate, partial, どれも知らなかったのですが便利ですね。
(time (take 3 (filter prime? (iterate (partial + 2) 1001))))
;"Elapsed time: 0.03 msecs"
;(1009 1013 1019)

(time (take 3 (filter prime? (iterate (partial + 2) 10001))))
;"Elapsed time: 0.045 msecs"
;(10007 10009 10037)

(time (take 3 (filter prime? (iterate (partial + 2) 100001))))
;"Elapsed time: 0.028 msecs"
;(100003 100019 100043)

(time (take 3 (filter prime? (iterate (partial + 2) 1000001))))
;"Elapsed time: 0.029 msecs"
;(1000003 1000033 1000037)
