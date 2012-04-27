(defn fringe [x]
  (cond
    (empty? x) x
    (list? (first x)) (concat (fringe (first x)) (fringe (rest x)))
    :else  (cons (first x) (fringe (rest x)))))

(def x (list 0 (list (list 1 2) 3) (list 4 5) 6))

(fringe x)
;(0 1 2 3 4 5 6)
