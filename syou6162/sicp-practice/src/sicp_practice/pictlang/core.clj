(ns sicp-practice.pictlang.core
  (:use seesaw.core
	seesaw.graphics
	sicp-practice.pictlang.common
	sicp-practice.pictlang.point
	sicp-practice.pictlang.painter
	sicp-practice.pictlang.split
	sicp-practice.pictlang.wave
	sicp-practice.ex-2-46 ; vector
	sicp-practice.ex-2-47 ; frame
	sicp-practice.ex-2-48 ; segment
	))

(def my-frame (make-frame (make-vect 0 0)
			  (make-vect 1 0)
			  (make-vect 0 1)))

(defn polygon-example-1 [c g]
  ((square-limit wave 4) my-frame g))

(def f (frame :title "My first example of Picture Language!!!"
	      :content
	      (canvas :id :canvas
		      :background :white
		      :size [*width* :by *height*]
		      :paint polygon-example-1)))

(defn -main [& args]
  (-> f pack! show!))
