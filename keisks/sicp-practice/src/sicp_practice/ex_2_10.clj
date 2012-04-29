(defn make-interval [a b]
  (list a b))

(defn upper-bound [x]
  (last x))

(defn lower-bound [x]
  (first x))

(defn mul-interval [x y]
  (let [p1 (* (lower-bound x) (lower-bound y))
        p2 (* (lower-bound x) (upper-bound y))
        p3 (* (upper-bound x) (lower-bound y))
        p4 (* (upper-bound x) (upper-bound y))]
    (make-interval (min p1 p2 p3 p4)
                   (max p1 p2 p3 p4))))

(defn div-interval [x y]
  (mul-interval x
                (make-interval (/ 1.0 (upper-bound y))
                               (/ 1.0 (lower-bound y)))))


;some examples

(def x1 (make-interval 2 5))
(def y1 (make-interval 3 9))
(def x2 (make-interval -5 -2))
(def y2 (make-interval -9 -3))

(mul-interval x1 y1) ; (6, 45)
(mul-interval x2 y2) ; (6, 45)
(mul-interval x1 y2) ; (-45, -6)
(mul-interval x2 y1) ; (-45, -6)

(div-interval x1 y1)
(div-interval x2 y2)
(div-interval x1 y2)
(div-interval x2 y1)
;(0.2222222222222222 1.6666666666666665)$
;(0.2222222222222222 1.6666666666666665)$
;(-1.6666666666666665 -0.2222222222222222)$
;(-1.6666666666666665 -0.2222222222222222)$

(def x3 (make-interval -2 5))
(def y3 (make-interval -9 3))

(div-interval x3 y3)
;(-0.6666666666666666 1.6666666666666665)

(defn zero-span? [x]
    (and (neg? (lower-bound x)) (pos? (upper-bound x))))

(defn div-interval-ben [x y]
  (if (zero-span? y)
    (println "Interval spans zero")
    (mul-interval x
                  (make-interval (/ 1.0 (upper-bound y))
                                 (/ 1.0 (lower-bound y))))))

(div-interval-ben x3 y3)
;Interval spans zero
