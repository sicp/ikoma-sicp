(defn same-parity [a & b]
  (defn fil [f s result]
    (if (empty? s)
      result
      (fil f (rest s) (if (f (first s))
                        (concat result (list (first s)))
                        result))))
  (if (even? a)
    (cons a (fil even? b '()))
    (cons a (fil odd? b '()))))

(same-parity 1 2 3 4 5 6 7)
(same-parity 2 3 4 5 6 7)
