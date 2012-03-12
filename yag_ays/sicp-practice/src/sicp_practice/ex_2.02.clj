(defn make-point [x y] (list x y))
(defn x-point [x] (first x))
(defn y-point [y] (last y))

(defn make-segment [s e] (list s e))
(defn start-segment [s] (first s))
(defn end-segment [e] (last e))

(defn midpoint-segment [seg]
  (make-point (/ (+ (x-point (start-segment seg)) (x-point (end-segment seg))) 2)
              (/ (+ (y-point (start-segment seg)) (y-point (end-segment seg))) 2)))

(def s (make-segment (make-point 1 2) (make-point 3 4)))
(midpoint-segment s)
