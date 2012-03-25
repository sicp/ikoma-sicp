(create-ns 'kumagi')
(ns kumagi)

;; 値とその誤差幅で区間を示す
(defn make-interval [base width]
  (list base width))
(defn bound [base func]
  (defn abs [x]
    (if (< x 0) (* x -1) x))
  (func (first base) (abs (first (rest base)))))
(defn upper-bound [ibl]
  (bound ibl +))
(defn lower-bound [ibl]
  (bound ibl -))
(upper-bound (make-interval 100 10)) ; => 110
(lower-bound (make-interval 100 10)) ; => 90

(def a (make-interval 100 10))
(def b (make-interval 200 5))

(defn add-interval [a b]
  (make-interval (+ (first a) (first b))
                 (+ (second a) (second b))))
(add-interval a b)
(defn sub-interval [a b]
  (make-interval (- (first a) (first b))
                 (+ (second a) (second b))))
(sub-interval a b)

(comment "加算・減算は、値と誤差とをそれぞれ足すだけ
(xbase xwidth) + (ybase ywidth) => (xbase+ybase  xwidth+ywidth)
で簡単に誤差部分はxwidthとywidthを足し合わせるだけなんだけど、
乗算の場合は
(xbase xwidth) * (ybase ywidth) =>
(xbase*ybase xbase*ywidth + xwidth*ybase + xwidth*ywidth)
になっちゃって成り立たない、除算も同様")
