(def x (list (list 1 2) (list 3 4) 0))
(def y (list (list 1 2 5 6) (list 3 4 4 2) (list 4 2) 9))
(def l (list (list 1 2) (list 3 4) 0))
(defn deep-reverse [l]
  (if (empty? l) l
      (let [head (if (list? (first l))
                   (deep-reverse (first l))
                   (first l))
            other (rest l)]
        (concat (deep-reverse other) (list head)))))
(deep-reverse x)
(deep-reverse y)                      ;(((9 (2 4)) (((2 4) 4) 3)) (((6 5) 2) 1))
