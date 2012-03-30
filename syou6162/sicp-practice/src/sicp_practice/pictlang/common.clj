(ns sicp-practice.pictlang.common
  (:use seesaw.core
	seesaw.graphics
	sicp-practice.pictlang.point
	sicp-practice.ex-2-46 ; vector
	sicp-practice.ex-2-47 ; frame
	sicp-practice.ex-2-48 ; segment
	))

(def ^:dynamic *width* 500)
(def ^:dynamic *height* 500)

(defn frame-coord-map [frame]
  (fn [v]
    (add-vect
     (origin-frame frame)
     (add-vect (scale-vect (xcor-vect v)
			   (edge1-frame frame))
	       (scale-vect (ycor-vect v)
			   (edge2-frame frame))))))

(def ^:dynamic *my-line-style* (style :foreground :black))

(defn draw-line [p1 p2]
  (fn [frame g]
    (let [l (line
	     (* *width*(x-point p1))
	     (* *height* (y-point p1))
	     (* *width* (x-point p2))
	     (* *height* (y-point p2)))]
      (push g (draw g l *my-line-style*)))))

(defn segments->painter [segment-list]
  (fn [frame g]
    (doseq [segment segment-list] ;; mapだと遅延評価で何も書かれなくなってしまう。(doall (map...))でもいいけど、doseqで
      ((draw-line
	((frame-coord-map frame) (start-segment segment))
	((frame-coord-map frame) (end-segment segment)))
       frame g))))