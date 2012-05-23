; ex 1-3
(defn ex1-3[x y z]
  (- (+ (square x) (square y) (square z))
     (cond
      (and (> y x) (> z x)) x
      (and (> x y) (> z y)) y
      :else z
      )
     )
  )