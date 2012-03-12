(defn scale-tree [tree factor]
  (cond (empty? tree) nil
        (not (list? tree)) (* tree factor)
        :else (cons (scale-tree (first tree) factor)
                    (scale-tree (rest tree) factor))))


(defn scale-tree [tree factor]
  (map (fn [sub-tree] (if (list? sub-tree)
                        (scale-tree sub-tree factor)
                        (* sub-tree factor)))
       tree))

(scale-tree (list 1 (list 2 (list 3 4) 5) (list 6 7))
            10)
;; (10 (20 (30 40) 50) (60 70))


;; square-list
(defn square-list [tree]
  (cond (empty? tree) nil
        (not (list? tree)) (* tree tree)
        :else (cons (square-list (first tree))
                    (square-list (rest tree)))))


(defn square-list [tree]
  (map (fn [sub-tree] (if (list? sub-tree)
                        (square-list sub-tree)
                        (* sub-tree sub-tree)))
       tree))


(square-list (list 1 (list 2 (list 3 4) 5) (list 6 7)))
;; (1 (4 (9 16) 25) (36 49))
