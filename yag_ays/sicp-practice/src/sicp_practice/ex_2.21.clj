(defn square-list [items]
  (if (empty? items)
    '()
    (cons (#(* % %) (first items)) (square-list (rest items)))))

(defn square-list [items]
  (map #(* % %) items))


(square-list '(1 2 3 4))
