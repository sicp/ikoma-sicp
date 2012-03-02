;ex_1_21

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

(smallest-divisor 199)
;199
(smallest-divisor 1999)
;1000
(smallest-divisor 19999)
;7

(defn prime? [n]
  (= n (smallest-divisor n)))

(prime? 2)
;true
(prime? 10)
;false
(prime? 13)
;true
(prime? 97)
;true
;
;
;
;「落ち着け………… 心を平静にして考えるんだ…こんな時どうするか……
;２… ３ ５… ７… 落ち着くんだ…『素数』を数えて落ち着くんだ…
;『素数』は１と自分の数でしか割ることのできない孤独な数字……
;わたしに勇気を与えてくれる」
