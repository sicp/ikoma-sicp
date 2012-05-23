(defn square-of-four [tl tr bl br]
  (fn [painter]
    (let [top (beside (tl painter) (tr painter))
          bottom (beside (bl painter) (br painter))]
      (belowe bottom top))))


(defn flipped-pairs [painter]
  (let [combine4 (square-of-four identity flip-evrt
                                 identity flip-vert)]
    (combine4 painter)))

(defn flipped-pairs [painter]
  (let [combine4 (square-of-four flip-horiz identity
                                 rotate180 flip-vert)]
    (combine4 (corner-split painter n))))



;; ex_2.45
(def right-split (split beside below))
(def up-split (split below beside))


(defn split [s t]
  (fn [painter n]
    (if (= n 0)
      painter
      (let [smaller (recur painter (- n 1))]
        (s painter (p smaller smaller))))))
