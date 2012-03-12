(defn make-interval [a b] (list a b))
(defn upper-bound [x] (last x))
(defn lower-bound [x] (first x))

(defn make-center-width [c w] (make-interval (- c w) (+ c w)))
(defn center [i] (/ (+ (lower-bound i) (upper-bound i)) 2))
(defn width [i] (/ (- (upper-bound i) (lower-bound i)) 2))


(defn make-center-percent [c p] (let [w (* c (/ p 100))]
                                  (make-interval (- c w) (+ c w))))
(defn center [i] (/ (+ (lower-bound i) (upper-bound i)) 2))
(defn percent [i] (* (/ (/ (- (upper-bound i) (lower-bound i)) 2)
                        (/ (+ (upper-bound i) (lower-bound i)) 2))
                     100.0))
