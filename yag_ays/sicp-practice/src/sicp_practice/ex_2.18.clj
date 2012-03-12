(def squares (list 1 4 9 16 25))
(def odds (list 1 3 5 7))


;; reverseの再実装
;; (reverse squares)
(defn rev [items]
  (if (empty? items)
    '()
    (concat (rev (rest items)) (list (first items)))))

(rev squares)
