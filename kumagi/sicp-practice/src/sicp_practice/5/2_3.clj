(create-ns 'kumagi')
(ns kumagi)

;; point
(defn make-point [x y]
  (list x y))
(defn x-point [point]
  (first point))
(defn y-point [point]
  (first (rest point)))
(defn point-eq [a b]
  (and (= (first a) (first b)) (= (first (rest a)) (first (rest a)))))
(defn print-point [p]
  (newline)
  (print "(" (x-point p) "," (y-point p) ")"))

;; rectangleの表現
;; letが賑やかなのは、どこが左上でどこが右下なのかを大小比較してるから
(defn make-rectangle [start end]
  (let [left-top-x (min (x-point start) (x-point end))
        left-top-y (min (y-point start) (y-point end))
        right-bottom-x (max (x-point start) (x-point end))
        right-bottom-y (max (y-point start) (y-point end))]
    (list (make-point left-top-x left-top-y) (make-point right-bottom-x right-bottom-y))))
(defn rectangle-width [rect]
  (- (x-point (first (rest rect))) (x-point (first rect))))
(defn rectangle-height [rect]
  (- (y-point (first (rest rect))) (y-point (first rect))))

;; 課題
(def rec (make-rectangle
         (make-point 100 300)
         (make-point 250 200)))

(defn perimeter [rect]
  (+ (* 2 (rectangle-width rect))
     (* 2 (rectangle-height rect))))
(defn area [rect]
  (* (rectangle-width rect)
     (rectangle-height rect)))
(rectangle-width rec)
(rectangle-height rec)
(perimeter rec) ; => 500
(area rec) ; => 15000

;; rectangleの別の表現
;; どこが左上・右下の点なのかを聞かれた時まで確定しない
(defn make-rectangle-alt [start end]
  (list start end))
(defn rectangle-width-alt [rect]
  (let [ax (x-point (first rect))
        bx (x-point (first (rest rect)))]
    (- (max ax bx)
       (min ax bx))))
(defn rectangle-height-alt [rect]
  (let [ay (y-point (first rect))
        by (y-point (first (rest rect)))]
    (- (max ay by)
       (min ay by))))

;; 別の表現でも同じ使い方ができるか
(def rec-alt (make-rectangle-alt
         (make-point 100 300)
         (make-point 250 200)))

(defn perimeter-alt [rect]
  (+ (* 2 (rectangle-width-alt rect))
     (* 2 (rectangle-height-alt rect))))
(defn area-alt [rect]
  (* (rectangle-width-alt rect)
     (rectangle-height-alt rect)))

(rectangle-width-alt rec)
(rectangle-height-alt rec)

(perimeter-alt rec-alt) ; => 500
(area-alt rec-alt) ; => 15000
;; できました
