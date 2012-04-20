(ns sicp-practice.ex-2-12
  (:use sicp-practice.2-7))

(defn center [i]
  (/ (+ (lower-bound i) (upper-bound i)) 2.0))

(defn make-center-percent [c p]
  (make-interval (* c (- 1 (/ p 100.0))) (* c (+ 1 (/ p 100.0)))))

(make-center-percent (center (make-interval 1 5)) 0.1) ; (2.997 3.0029999999999997)

(defn width [i]
  (/ (- (upper-bound i) (lower-bound i)) 2))

(defn percent [i]
  (* (/ (width i) (center i)) 100.0))

(percent (make-interval 3.35 3.65)) ; 4.285714285714283
