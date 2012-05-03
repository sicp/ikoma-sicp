(ns sicp-practice.ex-2-48
  (:use sicp-practice.pictlang.painter))

(defn up-split [painter n]
  (if (= n 0)
    painter
    (let [smaller (up-split painter (- n 1))]
      (below painter (beside smaller smaller)))))