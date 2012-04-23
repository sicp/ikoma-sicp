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
