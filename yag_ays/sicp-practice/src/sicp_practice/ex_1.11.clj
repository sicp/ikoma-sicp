;; 再帰的プロセス
(defn f [n]
  (if (< n 3)
    n
    (+ (f (- n 1))
       (* 2 (f (- n 2)))
       (* 3 (f (- n 3))))))


;; 反復的プロセス
(defn f [n]
  (f-iter 2 1 0 n))

(defn f-iter [a b c count]
  (cond (= count 0) c
        (= count 1) b
        :else (f-iter (+ a (* b 2) (* c 3)) a b (- count 1))))

;; example
(f 1)
(f 2)
(f 3)
(f 4)
(f 5)

;; 解説
;; f (n)の1項目をa，2項目をb，3項目をcとすると，f (n+1)の各項a',b',c'は
;; a' <- a+2b+3c
;; b' <- a
;; c' <- b
;; となる．
