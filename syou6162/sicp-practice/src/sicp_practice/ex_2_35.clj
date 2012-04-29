(ns sicp-practice.ex-2-35)

(defn count-leaves [tree]
  (if (list? tree)
    (if (empty? tree) 0
	(+ (count-leaves (first tree))
	   (count-leaves (rest tree))))
    1))

(def x (list 1
	     (list 2 (list 3 4) 5)
	     (list 6 7)))

(count-leaves x) ; 7