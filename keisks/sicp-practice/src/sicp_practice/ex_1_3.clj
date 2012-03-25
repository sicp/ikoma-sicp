(defn square [x]
  (* x x))

(defn large-two-square [x, y, z]
  (cond (and (<= x y) (<= x z)) (+ (square y) (square z))
        (and (<= y x) (<= y z)) (+ (square x) (square z))
        :else (+ (square x) (square y))))

(large-two-square 4 4 2)

