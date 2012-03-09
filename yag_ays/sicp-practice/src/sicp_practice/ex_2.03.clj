;; point
(defn make-point [x y] (list x y))
(defn x-point [x] (first x))
(defn y-point [y] (last y))

;; segment
(defn make-segment [s e] (list s e))
(defn start-segment [s] (first s))
(defn end-segment [e] (last e))

;; rectangle
(defn make-rectangle [r1 r2 r3] (list (make-segment r1 r2) (make-segment r1 r3)))


(defn segment-length [seg]
  (let [x (- (x-point (start-segment seg)) (x-point (end-segment seg)))
        y (- (y-point (start-segment seg)) (y-point (end-segment seg)))]
    (Math/sqrt (+ (* x x) (* y y)))))

(defn rectangle-width [r] (segment-length (first r)))
(defn rectangle-height [r] (segment-length (last r)))


(defn make-perimeter [r] (+ (* (rectangle-width r) 2)
                            (* (rectangle-height r) 2)))
(defn make-area [r] (* (rectangle-width r) (rectangle-height r)))



;; point (1 2)
;; segment ((1 2) (3 4))
;; rectangle (((1 2) (3 4)) ((1 2) (5 6)))

;; point -> segment -> rect --(segment-length)--> rect-(width|height) -> make-(perimeter|area)



