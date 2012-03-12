(defn square [x]
  (* x x))

(defn tree-map [s t]
  (map (fn [sub-tree] (if (list? sub-tree)
                        (tree-map s sub-tree)
                        (s sub-tree)))
       t))

(defn square-tree [tree]
  (tree-map square tree))

(square-tree (list 1 (list 2 (list 3 4) 5) (list 6 7)))
;; (1 (4 (9 16) 25) (36 49))
