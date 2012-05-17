(defn queen [board-size]
  (defn queen-cols [k] (if (= k 0)
                         (list empty-board)
                         (filter (fn [positions] (safe? k positions))
                                 (flatmap (fn [rest-of-queens]
                                            (map (fn [new-row]
                                                   (adjoin-position new-row k rest-of-queens))
                                                 (enumarate-interval 1 board-size)))
                                          (queen-cols (- k 1))))))
  (queen-cols board-size))


(def empty-board nil)
(defn adjoin-position [new-row col rest-of-queens]
  (cons new-row rest-of-queens))



(defn safe? [col positions])
;; not answered yet...
