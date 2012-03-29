(ns sicp-practice.seesaw-example
  (:use seesaw.core
	seesaw.graphics
	sicp-practice.pictlang.common
	sicp-practice.ex-2-46 ; vector
	sicp-practice.ex-2-47 ; frame
	sicp-practice.ex-2-48 ; segment
	))

;; ref http://d.hatena.ne.jp/higepon/20060424/1145443723

(def ^:dynamic *width* 500)
(def ^:dynamic *height* 500)

;; point
(defn make-point [x y]
  (list x y))

(defn x-point [p]
  (first p))

(defn y-point [p]
  (second p))

(defn print-point [p]
  (println (str "("
		(x-point p)
		", "
		(y-point p)
		")")))

;;

(defn frame-coord-map [frame]
  (fn [v]
    (add-vect
     (origin-frame frame)
     (add-vect (scale-vect (xcor-vect v)
			   (edge1-frame frame))
	       (scale-vect (ycor-vect v)
			   (edge2-frame frame))))))

(def my-frame (make-frame (make-vect 0 0)
			  (make-vect 1 0)
			  (make-vect 0 1)))

(def segments (list
	       (make-segment (make-point 0.2 0.7) (make-point 0.3 0.9))
	       (make-segment (make-point 0.4 0.7) (make-point 0.3 0.9))
	       (make-segment (make-point 0.6 0.7) (make-point 0.7 0.9))
	       (make-segment (make-point 0.8 0.7) (make-point 0.7 0.9))
	       (make-segment (make-point 0.3 0.5) (make-point 0.4 0.6))
	       (make-segment (make-point 0.6 0.6) (make-point 0.7 0.5))
	       (make-segment (make-point 0.5 0.2) (make-point 0.6 0.4))
	       (make-segment (make-point 0.5 0.2) (make-point 0.4 0.4))
	       (make-segment (make-point 0.45 0.3) (make-point 0.55 0.3))
	       (make-segment (make-point 0.85 0.6) (make-point 0.9 0.4))
	       (make-segment (make-point 0.85 0.2) (make-point 0.9 0.4))))

;; painter

(defn transform-painter [painter origin corner1 corner2]
  (fn [frame g]
    (let [m (frame-coord-map frame)
	  new-origin (m origin)]
      (painter
       (make-frame new-origin
		   (sub-vect (m corner1) new-origin)
		   (sub-vect (m corner2) new-origin))
       g))))

(defn flip-vert [painter]
  (transform-painter painter
                     (make-vect 0.0 1.0)
                     (make-vect 1.0 1.0)
                     (make-vect 0.0 0.0)))

(defn shrink-to-upper-right [painter]
  (transform-painter painter
                     (make-vect 0.5 0.5)
                     (make-vect 1.0 0.5)
                     (make-vect 0.5 0.0)))

(defn rotate90 [painter]
  (transform-painter painter
                     (make-vect 1.0 0.0)
                     (make-vect 1.0 1.0)
                     (make-vect 0.0 0.0)))

(defn squash-inwards [painter painter]
  (transform-painter painter
                     (make-vect 0.0 0.0)
                     (make-vect 0.65 0.35)
                     (make-vect 0.35 0.65)))

(defn rotate270 [painter]
  (transform-painter painter
                     (make-vect 0.0 1.0)
                     (make-vect 0.0 0.0)
                     (make-vect 1.0 1.0)))

(defn flip-horiz [painter]
  (transform-painter painter
                     (make-vect 1.0 0.0)
                     (make-vect 0.0 0.0)
                     (make-vect 1.0 1.0)))

(defn beside [painter1 painter2]
  (let [split-point (make-vect 0.5 0.0)
	paint-left (transform-painter painter1
				      (make-vect 0.0 0.0)
				      split-point
				      (make-vect 0.0 1.0))
	paint-right (transform-painter painter2
				       split-point
				       (make-vect 1.0 0.0)
				       (make-vect 0.5 1.0))]
    (fn [frame g]
      (paint-left frame g)
      (paint-right frame g))))

(defn below [painter1 painter2]
  (rotate90 (beside (rotate270 painter1) (rotate270 painter2))))

(defn up-split [painter n]
  (if (= n 0)
      painter
      (let [smaller (up-split painter (- n 1))]
        (below painter (beside smaller smaller)))))

(defn right-split [painter n]
  (if (= n 0)
      painter
      (let [smaller (right-split painter (- n 1))] 
        (beside painter (below smaller smaller)))))

(defn corner-split [painter n]
  (if (= n 0)
      painter
      (let [up (up-split painter(- n 1))
	    right (right-split painter (- n 1))
	    top-left (beside up up)
	    bottom-right (below right right)
	    corner (corner-split painter (- n 1))]
	(beside (below painter top-left)
		(below bottom-right corner)))))

(defn square-limit [painter n]
  (let [quarter (corner-split painter n)
	half (beside (flip-horiz quarter) quarter)]
    (below (flip-vert half) half)))

(def my-line-style (style :foreground :black))

(defn draw-line [p1 p2]
  (fn [frame g]
    (push g
	  (draw g
		(line
		 (* *width*(x-point p1))
		 (* *height* (y-point p1))
		 (* *width* (x-point p2))
		 (* *height* (y-point p2)))
		my-line-style))))
;;

(defn segments->painter [segment-list]
  (fn [frame g]
    (doseq [segment segment-list]
      ((draw-line
	((frame-coord-map frame) (start-segment segment))
	((frame-coord-map frame) (end-segment segment)))
       frame g))))

(def monar (segments->painter segments))

(defn polygon-example-1 [c g]
  ((square-limit monar 4) my-frame g))

(def f (frame :title "My first example of Picture Language!!!"
	      :content
	      (canvas :id :canvas
		      :background :white
		      :size [*width* :by *height*]
		      :paint polygon-example-1)))

(defn -main [& args]
  (-> f pack! show!))
