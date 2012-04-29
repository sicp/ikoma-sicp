(defn append [x y]
  (if (empty? x) y
      (cons (first x) (append (rest x) y))))

(defn square [x]
  (* x x))

(defn push [x y]
  (append x (list y)))

(defn square-list [items]
  (if (empty? items) (list )
      (if (list? (first items)) (cons (square-list (first items)) (square-list (rest items)))
          (cons (square (first items)) (square-list (rest items))))))