(ns sicp-practice.ex-1-11)

;; 再帰的プロセス
(defn f [n]
  (if (< n 3)
    n
    (+ (f (- n 1))
       (* 2 (f (- n 2)))
       (* 3 (f (- n 3))))))

;; 反復的プロセス
(defn f-iter [a b c count]
  (cond (= count 0) c
        (= count 1) b
        :else (f-iter (+ a (* b 2) (* c 3)) a b (- count 1))))

(defn f [n]
  (f-iter 2 1 0 n))

(map f (range 10)) ; (0 1 2 4 11 25 59 142 335 796)
