(def x (list (list 1 2) (list 3 4)))

(defn fringe [items]
  (cond (empty? items)         '()
        (list? (first items))  (concat (fringe (first items)) (fringe (rest items)))
        :else                  (cons (first items) (fringe (rest items)))))

(fringe x)

;; flattenの再実装
(flatten x)
