(create-ns 'kumagi')

(defn make-interval [a b]
  (list (min a b) (max a b)))
(defn upper-bound [ibl]
  (first (rest ibl)))
(defn lower-bound [ibl]
  (first ibl))

(def x (make-interval 90 110))
(upper-bound x) ; => 110
(lower-bound x) ; => 90
(def y (make-interval 230 170))
(upper-bound y) ; => 230
(lower-bound y) ; => 170

(defn add-interval [x y]
  (make-interval (+ (lower-bound x) (lower-bound y))
                 (+ (upper-bound x) (upper-bound y))))
(add-interval x y) ; (260 340)
(defn mul-interval [x y]
  (let [p1 (* (lower-bound x) (lower-bound y))
        p2 (* (lower-bound x) (upper-bound y))
        p3 (* (upper-bound x) (lower-bound y))
        p4 (* (upper-bound x) (upper-bound y))]
    (make-interval (min p1 p2 p3 p4)
                   (max p1 p2 p3 p4))))
(mul-interval x y) ; (15300 25300)

(defn div-interval [x y]
  (mul-interval x
                (make-interval (/ 1.0 (upper-bound y))
                               (/ 1.0 (lower-bound y)))))
(div-interval x y)


