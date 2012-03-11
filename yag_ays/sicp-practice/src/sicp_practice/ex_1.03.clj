(defn problem1-3 [a b c]
  (cond (and (<= a b) (<= a c)) (+ (* b b) (* c c))
        (and (<= b a) (<= b c)) (+ (* a a) (* c c))
        (and (<= c a) (<= c b)) (+ (* a a) (* b b))))
