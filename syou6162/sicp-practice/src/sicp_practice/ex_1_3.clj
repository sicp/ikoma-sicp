(ns sicp-practice.ex-1-3)

;; 問題1.3
(defn problem1-3 [a b c]
  (let [[max-1 max-2] (take-last 2 (sort (list a b c)))]
    (+ (* max-1 max-1) (* max-2 max-2))))
