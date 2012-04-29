;; ex_2.38
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



(defn rev-fold-right [s]
  (fold-right #(concat %2 (list %)) nil s))
(rev-fold-right '(1 2 3 4 5))

(defn rev-fold-left [s]
  (fold-left #(cons %2 %) nil s))
(rev-fold-left '(1 2 3 4 5))
