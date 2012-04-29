(defn append [x y]
  (if (empty? x) y
      (cons (first x) (append (rest x) y))))

; flatten 使いたくないので何か解決策を考える
(defn fringe [x]
  (if (empty? x) (list )
      (if (list? (first x)) (concat (fringe (first x)) (fringe (rest x)))
          (cons (first x) (fringe (rest x))))))
