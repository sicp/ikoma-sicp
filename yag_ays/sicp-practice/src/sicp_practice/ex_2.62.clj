(defn union-set [set1 set2]
  (cond (empty? set1) set2
        (empty? set2) set1
        :else (let [x1 (first set1)
                    x2 (first set2)]
                (cond (= x1 x2) (cons x1 (union-set (rest set1) (rest set2)))
                      (> x1 x2) (cons x2 (union-set set1 (rest set2)))
                      (< x1 x2) (cons x1 (union-set (rest set1) set2))))))

(union-set '() '()) ;; ()
(union-set '() '(1)) ;; (1)
(union-set '(1) '()) ;; (1)
(union-set '(1 2 3) '(1 3 5)) ;; (1 2 3 5)
(union-set '(1 2 3) '(4 5 6)) ;; (1 2 3 4 5 6)
(union-set '(4 5 6) '(1 2 3)) ;; (1 2 3 4 5 6)
