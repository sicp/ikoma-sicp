(ns sicp-practice.ex-2-32)

;; 羃集合を作る関数
;; テキストでは穴埋めっぽい感じになってるけど、それ以外のところもちゃんと説明できたほうがよさそう
(defn subsets [s]
  (if (empty? s)
    (list nil)
    (let [cdr (subsets (rest s))]
      (concat cdr (map #(cons (first s) %) cdr)))))

(subsets '(1 2 3)) ; (nil (3) (2) (2 3) (1) (1 3) (1 2) (1 2 3))