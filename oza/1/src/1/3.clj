(defn square [x] (* x x))
(defn maxare [x y] (if-let [result (>= x y)] (square x) (square y)))
