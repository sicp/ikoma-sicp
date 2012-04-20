(defn square [x] (* x x))
(defn square-list [items]
  (if (= items '())
    nil
    (cons (square (first items)) (square-list (rest items)))))
(square-list [3 4 5 6 7])
(defn square-list2 [items]
  (map square items))
(square-list2 [3 4 5 6 7])

(= [] '())

(map square [1 2 3])
