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

(defn sub-interval [x y]
	(make-interval (- (lower-bound x) (upper-bound y))
								 (- (upper-bound x) (lower-bound y))))
(sub-interval x y) ; (-140 -60)
(sub-interval y x) ; (60 140)
