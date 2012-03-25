(ns kumagi)

(defn make-segment [start end]
  (list start end))
(defn start-segment [segment]
  (first segment))
(defn end-segment [segment]
  (first (rest segment)))

(start-segment (make-segment 10 100)) ; => 10
(end-segment (make-segment 10 100)) ; => 100

(defn make-point [x y]
  (list x y))
(defn x-point [point]
  (first point))
(defn y-point [point]
  (first (rest point)))

(defn print-point [p]
  (newline)
  (print "(" (x-point p) "," (y-point p) ")"))

(print-point (make-segment 23 45))


; 後からpointが3次元上の点を抽象化するのに備えて点と点の中点を求めるのを抽象化
(defn mid-point [a b]
  (make-point (/ (+ (x-point a) (x-point b)) 2)
              (/ (+ (y-point a) (y-point b)) 2)))

(defn midpoint-segment [seg]
  (mid-point (start-segment seg) (end-segment seg)))
(print-point (midpoint-segment
              (make-segment
               (make-point 100 50)
               (make-point 200 80)))) ; ( 150 , 65 )
