(def x (list 1 2 3))
(def y (list 4 5 6))

;; append
(defn append [list1 list2]
  (if (empty? list1)
    list2
    (cons (first list1) (append (rest list1) list2))))
(append x y)
;; (1 2 3 4 5 6)


;; cons
(cons x y)
;; ((1 2 3) 4 5 6)


;; list
(list x y)
;; ((1 2 3) (4 5 6))
