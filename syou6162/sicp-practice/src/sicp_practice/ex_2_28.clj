(ns sicp-practice.ex-2-28)

;; 最初はaccumulatorっぽく実装できるかなと思ったけど、なんかうまく行かなかった。。。

(defn fringe [xs]
  (let [car (first xs)
	cdr (rest xs)]
    (cond
     (empty? xs) '()
     (list? car) (concat (fringe car) (fringe cdr))
     :else (cons car (fringe cdr)))))

(def x (list (list 1 2) (list 3 4)))
(fringe x) ; (1 2 3 4)
(fringe (list x x)) ; (1 2 3 4 1 2 3 4)
