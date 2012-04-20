(ns sicp-practice.pictlang.painter
  (:use sicp-practice.pictlang.common
	sicp-practice.ex-2-46 ; vector
	sicp-practice.ex-2-47 ; frame
	))

(defn transform-painter [painter origin corner1 corner2]
  (fn [frame g]
    (let [m (frame-coord-map frame)
	  new-origin (m origin)
	  new-frame (make-frame new-origin
				(sub-vect (m corner1) new-origin)
				(sub-vect (m corner2) new-origin))]
      (painter new-frame g))))

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
