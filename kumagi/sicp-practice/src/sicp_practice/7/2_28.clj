(def x (list (list 1 2) (list 3 4)) )
(defn fringe [l]
  (if (empty? l) l
      (let [left (first l)
            right (rest l)]
        (if (list? left)
          (concat (fringe left) (fringe right))
          (cons left (fringe right))))))
(fringe (list x x))

(fringe (list (list 3 3) (list 3 1)))
