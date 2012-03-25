(ns kumagi)
(defn square [x] (* x x))

(defn compose [f g]
  (fn [x] (f (g x))))
((compose square inc) 6) ; => 49 ok!
