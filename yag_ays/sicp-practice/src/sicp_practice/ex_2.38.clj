;; これまでのaccumulateと同じ
(defn fold-right [op initial s]
  (if (empty? s)
    initial
    (op (first s)
        (accumulate op initial (rest s)))))


(defn fold-left [op initial s]
  (defn iter [result rst]
    (if (empty? rst)
      result
      (iter (op result (first rst))
            (rest rst))))
  (iter initial s))



(fold-right / 1 '(1 2 3))
;; 3/2

(fold-left / 1 '(1 2 3))
;; 1/6

(fold-right list nil '(1 2 3))
;; (1 (2 (3 nil)))

(fold-left list nil '(1 2 3))
;; (((nil 1) 2) 3)



;; Comment
;; fold-leftでさらっと反復プロセスを使った実装をしているけど，
;; ex_2.22で苦労した部分(consの引数や順序など)が解消されているのは，
;; fold-leftが引数に取るop関数が公認インターフェイスとして機能しているからだろうか?
