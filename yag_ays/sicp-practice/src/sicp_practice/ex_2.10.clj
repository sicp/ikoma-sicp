(defn make-interval [a b] (list a b))
(defn upper-bound [x] (last x))
(defn lower-bound [x] (first x))

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

(div-interval '(1.0 2.0) '(0.1 1.1))
(div-interval '(1.0 2.0) '(-0.1 0.9))


;; Ben Bitdiddle's advice
(defn zero-span? [x]
  (and (neg? (lower-bound x)) (pos? (upper-bound x))))

(defn div-interval-ben [x y]
  (if (zero-span? y)
    (println "Interval span zero")
    (mul-interval x
                (make-interval (/ 1.0 (upper-bound y))
                               (/ 1.0 (lower-bound y))))))

(div-interval-ben '(1.0 2.0) '(0.1 1.1))
(div-interval-ben '(1.0 2.0) '(-0.1 0.9))
