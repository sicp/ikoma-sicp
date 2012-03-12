(defn subsets [s]
  (if (empty? s)
    (list nil)
    (let [rst (subsets (rest s))]
      (concat rst (map #(cons (first s) %) rst)))))

(subsets (list 1 2 3))
;; (nil (3) (2) (2 3) (1) (1 3) (1 2) (1 2 3))



;; 解説

;; 要素が1つの場合
(subsets '(1))
(concat '(nil) (map #(cons 1 %) '(nil)))
;; (nil (1))

;; 要素が2つの場合
(subsets '(1 2))
(concat (subsets '(2)) (map #(cons (first '(1 2)) %) (subsets '(2))))
(concat '(nil (2)) (map #(cons 1 %) '(nil (2))))
(concat '(nil (2)) '((1) (1 2)))
;; (nil (2) (1) (1 2))

;; 要素が3つの場合
(subsets '(1 2 3))
(concat (subsets '(2 3)) (map #(cons (first '(1 2 3)) %) (subsets '(2 3))))
(concat '(nil (3) (2) (2 3)) (map #(cons 1 %) '(nil (3) (2) (2 3))))
(concat '(nil (3) (2) (2 3)) '((1) (1 3) (1 2) (1 2 3)))
;; (nil (3) (2) (2 3) (1) (1 3) (1 2) (1 2 3))

;; concatの前半で(rest s)の集合を作る．concatの後半で(rest s)の全ての集合に(first s)を付加する．
