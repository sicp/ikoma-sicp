(defn up-split [painter n]
  (if (= n 0)
    painter
    (let [smaller (up-split painter (- n 1))]
      (below painter (beside smaller smaller)))))

(defn right-split [painter n]
  (if (= n 0)
    painter
    (let [smaller (right-split painter (-n 1))]
      (beside painter (below smaller smaller)))))

;;right-splitとup-splitは，汎用分割演算の具体化として表すことが出来る.
;;(define right-split (split beside below))
;;(define up-split (split below beside))
;;の許仙が， すでに定義したものと同じ振舞いの手続きright-split とup-split を作り出すような性質を持つ手続き
;;split を定義せよ.

(defn split [fn1 fn2]
  (fn [painter n]
    (if (= n 0)
      painter
      (let [smaller (recur painter (- n 1))]
        (fn1 painter (fn2 smaller smaller))))))
