(ns sicp-practice.ex-2-30)

(defn square [x] (* x x))

(def x (list 1
	     (list 2 (list 3 4) 5)
	     (list 6 7)))

;; mapを使ったバージョン
(defn square-tree0 [tree]
  (map (fn [x]
	 (if (list? x)
	   (cons (square (first x)) (square-tree0 (rest x)))
	   (square x)))
       tree))

(square-tree0 x) ; (1 (4 (9 16) 25) (36 49))

;; 再帰を使ったバージョン
(defn square-tree1 [tree]
  (cond
   (empty? tree) nil
   (not (list? (first tree))) (cons (square (first tree))
				    (square-tree1 (rest tree)))
   :else (cons (square-tree1 (first tree))
	       (square-tree1 (rest tree)))))

(square-tree1 x) ; (1 (4 (9 16) 25) (36 49))

