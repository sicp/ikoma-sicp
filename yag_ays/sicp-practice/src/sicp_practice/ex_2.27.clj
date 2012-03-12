(def x (list (list 1 2) (list 3 4))) ;; ((1 2) (3 4))

(defn rev [items]
  (if (empty? items)
    '()
    (concat (rev (rest items)) (list (first items)))))

(defn deep-rev [items]
  (cond (empty? items)        '()
        (list? (first items)) (concat (deep-rev (rest items)) (list (deep-rev (first items))))
        :else                 (concat (deep-rev (rest items)) (list (first items)))))


(rev x) ;; ((3 4) (1 2))
(deep-rev x) ;; ((4 3) (2 1))
