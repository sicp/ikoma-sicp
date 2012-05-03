(ns sicp-practice.pictlang.split
  (:use sicp-practice.pictlang.painter
	sicp-practice.ex-2-44 ;; up-split
	))

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
