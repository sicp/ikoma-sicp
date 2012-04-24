(defn equal? [x y]
  (cond (and (seq? x) (seq? x)) (cond (and (empty? x) (empty? y)) true
                                      (not= (first x) (first y)) false
                                      :else (equal? (rest x) (rest y)))
        (or (seq? x) (seq? y)) false
        :else (= x y)))

(defn element-of-set? [x set]
  (cond (empty? set) false
        (equal? x (first set)) true
        :else (element-of-set? x (rest set))))

(defn adjoin-set [x set]
  (if (element-of-set? x set)
    set
    (cons x set)))

(defn intersection-set [set1 set2]
  (cond (or (empty? set1) (empty? set2)) '()
        (element-of-set? (first set1) set2) (cons (first set1)
                                                  (intersection-set (rest set1) set2))
        :else (intersection-set (rest set1) set2)))

(element-of-set? 1 '(1 2 3)) ;; true
(element-of-set? 4 '(1 2 3)) ;; false

(adjoin-set 1 '(1 2 3)) ;; (1 2 3)
(adjoin-set 4 '(1 2 3)) ;; (4 1 2 3)

(intersection-set '(1 2 3) '(1 3 5)) ;; (1 3)
(intersection-set '(1 2 3) '(4 5 6)) ;; ()


;; ex_2.59

(defn union-set [set1 set2]
  (cond (empty? set1) set2
        (empty? set2) set1
        (element-of-set? (first set1) set2) (union-set (rest set1) set2)
        :else (cons (first set1) (union-set (rest set1) set2))))

(union-set '() '()) ;; ()
(union-set '() '(1)) ;; (1)
(union-set '(1) '()) ;; (1)
(union-set '(1 2 3) '(1 3 5)) ;; (2 1 3 5)
(union-set '(1 2 3) '(4 5 6)) ;; (1 2 3 4 5 6)
