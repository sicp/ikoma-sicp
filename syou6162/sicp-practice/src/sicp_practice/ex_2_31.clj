(ns sicp-practice.ex-2-31)

(defn square [x] (* x x))

(def x (list 1
	     (list 2 (list 3 4) 5)
	     (list 6 7)))

;; mapを使ったバージョン
(defn tree-map0 [f tree]
  (map (fn [x]
	 (if (list? x)
	   (cons (f (first x)) (tree-map0 f (rest x)))
	   (f x)))
       tree))

(tree-map0 square x) ; (1 (4 (9 16) 25) (36 49))


;; 再帰を使ったバージョン
(defn tree-map1 [f tree]
  (cond
   (empty? tree) nil
   (not (list? (first tree))) (cons (f (first tree))
				    (tree-map1 f (rest tree)))
   :else (cons (tree-map1 f (first tree))
	       (tree-map1 f (rest tree)))))

(tree-map1 square x) ; (1 (4 (9 16) 25) (36 49))
