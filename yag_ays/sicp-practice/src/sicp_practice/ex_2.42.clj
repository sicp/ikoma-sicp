;; ex_2.40
(defn accumulate [op initial s]
  (if (empty? s)
    initial
    (op (first s)
        (accumulate op initial (rest s)))))
(defn enumerate-interval [low high]
  (if (> low high)
    nil
    (cons low (enumerate-interval (+ low 1) high))))
(defn flatmap [proc sq]
  (accumulate concat nil (map proc sq)))



;; ex_2.42.clj
(defn queen [board-size]
  (defn queen-cols [k] (if (= k 0)
                         (list empty-board)
                         (filter (fn [positions] (safe? k positions))
                                 (flatmap (fn [rest-of-queens]
                                            (map (fn [new-row]
                                                   (adjoin-position new-row k rest-of-queens))
                                                 (enumerate-interval 1 board-size)))
                                          (queen-cols (- k 1))))))
  (queen-cols board-size))


(def empty-board nil)
(defn adjoin-position [new-row col rest-of-queens]
  (cons new-row rest-of-queens))


;; http://wiki.drewhess.com/wiki/SICP_exercise_2.42
(defn safe? [column positions]
  (defn next-column-safe? [new-row positions row-offset]
    (if (empty? positions)
      true
      (let [this-row (first positions)]
        (if (or (= this-row new-row)
                (= (+ this-row row-offset) new-row)
                (= (- this-row row-offset) new-row))
          false
          (next-column-safe? new-row (rest positions) (+ 1 row-offset))))))
  (next-column-safe? (first positions) (rest positions) 1))


(queen 4)
;; ((3 1 4 2) (2 4 1 3))

(queen 5)
;; ((4 2 5 3 1) (3 5 2 4 1) (5 3 1 4 2) (4 1 3 5 2) (5 2 4 1 3) (1 4 2 5 3) (2 5 3 1 4) (1 3 5 2 4) (3 1 4 2 5) (2 4 1 3 5))

(queen 6)
;; ((5 3 1 6 4 2) (4 1 5 2 6 3) (3 6 2 5 1 4) (2 4 6 1 3 5))

(queen 7)
;; ((6 4 2 7 5 3 1) (5 2 6 3 7 4 1) (4 7 3 6 2 5 1) (3 5 7 2 4 6 1) (6 3 5 7 1 4 2) (7 5 3 1 6 4 2) (6 3 7 4 1 5 2) (6 4 7 1 3 5 2) (6 3 1 4 7 5 2) (5 1 4 7 3 6 2) (4 6 1 3 5 7 2) (4 7 5 2 6 1 3) (5 7 2 4 6 1 3) (1 6 4 2 7 5 3) (7 4 1 5 2 6 3) (5 1 6 4 2 7 3) (6 2 5 1 4 7 3) (5 7 2 6 3 1 4) (7 3 6 2 5 1 4) (6 1 3 5 7 2 4) (2 7 5 3 1 6 4) (1 5 2 6 3 7 4) (3 1 6 2 5 7 4) (2 6 3 7 4 1 5) (3 7 2 4 6 1 5) (1 4 7 3 6 2 5) (7 2 4 6 1 3 5) (3 1 6 4 2 7 5) (4 1 3 6 2 7 5) (4 2 7 5 3 1 6) (3 7 4 1 5 2 6) (2 5 7 4 1 3 6) (2 4 1 7 5 3 6) (2 5 1 4 7 3 6) (1 3 5 7 2 4 6) (2 5 3 1 7 4 6) (5 3 1 6 4 2 7) (4 1 5 2 6 3 7)  (3 6 2 5 1 4 7) (2 4 6 1 3 5 7))

(queen 8)
;; ((4 2 7 3 6 8 5 1) (5 2 4 7 3 8 6 1) (3 5 2 8 6 4 7 1) (3 6 4 2 8 5 7 1) (5 7 1 3 8 6 4 2) (4 6 8 3 1 7 5 2) (3 6 8 1 4 7 5 2) (5 3 8 4 7 1 6 2) (5 7 4 1 3 8 6 2) (4 1 5 8 6 3 7 2) (3 6 4 1 8 5 7 2) (4 7 5 3 1 6 8 2) (6 4 2 8 5 7 1 3) (6 4 7 1 8 2 5 3) (1 7 4 6 8 2 5 3) (6 8 2 4 1 7 5 3) (6 2 7 1 4 8 5 3) (4 7 1 8 5 2 6 3) (5 8 4 1 7 2 6 3) (4 8 1 5 7 2 6 3) (2 7 5 8 1 4 6 3) (1 7 5 8 2 4 6 3) (2 5 7 4 1 8 6 3) (4 2 7 5 1 8 6 3) (5 7 1 4 2 8 6 3) (6 4 1 5 8 2 7 3) (5 1 4 6 8 2 7 3) (5 2 6 1 7 4 8 3) (6 3 7 2 8 5 1 4) (2 7 3 6 8 5 1 4) (7 3 1 6 8 5 2 4) (5 1 8 6 3 7 2 4) (1 5 8 6 3 7 2 4) (3 6 8 1 5 7 2 4) (6 3 1 7 5 8 2 4) (7 5 3 1 6 8 2 4) (7 3 8 2 5 1 6 4) (5 3 1 7 2 8 6 4) (2 5 7 1 3 8 6 4) (3 6 2 5 8 1 7 4) (6 1 5 2 8 3 7 4) (8 3 1 6 2 5 7 4) (2 8 6 1 3 5 7 4) (5 7 2 6 3 1 8 4) (3 6 2 7 5 1 8 4) (6 2 7 1 3 5 8 4) (3 7 2 8 6 4 1 5) (6 3 7 2 4 8 1 5) (4 2 7 3 6 8 1 5) (7 1 3 8 6 4 2 5) (1 6 8 3 7 4 2 5) (3 8 4 7 1 6 2 5) (6 3 7 4 1 8 2 5) (7 4 2 8 6 1 3 5) (4 6 8 2 7 1 3 5) (2 6 1 7 4 8 3 5) (2 4 6 8 3 1 7 5) (3 6 8 2 4 1 7 5) (6 3 1 8 4 2 7 5) (8 4 1 3 6 2 7 5) (4 8 1 3 6 2 7 5) (2 6 8 3 1 4 7 5) (7 2 6 3 1 4 8 5) (3 6 2 7 1 4 8 5) (4 7 3 8 2 5 1 6) (4 8 5 3 1 7 2 6) (3 5 8 4 1 7 2 6) (4 2 8 5 7 1 3 6) (5 7 2 4 8 1 3 6) (7 4 2 5 8 1 3 6) (8 2 4 1 7 5 3 6) (7 2 4 1 8 5 3 6) (5 1 8 4 2 7 3 6) (4 1 5 8 2 7 3 6) (5 2 8 1 4 7 3 6) (3 7 2 8 5 1 4 6) (3 1 7 5 8 2 4 6) (8 2 5 3 1 7 4 6) (3 5 2 8 1 7 4 6) (3 5 7 1 4 2 8 6) (5 2 4 6 8 3 1 7) (6 3 5 8 1 4 2 7) (5 8 4 1 3 6 2 7) (4 2 5 8 6 1 3 7) (4 6 1 5 2 8 3 7) (6 3 1 8 5 2 4 7) (5 3 1 6 8 2 4 7) (4 2 8 6 1 3 5 7) (6 3 5 7 1 4 2 8) (6 4 7 1 3 5 2 8) (4 7 5 2 6 1 3 8) (5 7 2 6 3 1 4 8))
