; 1.12
; Calculate elem of Pascal's triangle


(defn pascal [row pos] (
                       if (or (= pos 1) (= row pos)) 1
                           (+ (pascal (- row 1) pos) (pascal (- row 1) (- pos 1)) )
                           )
  )
