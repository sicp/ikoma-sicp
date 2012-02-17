(ns sicp-practice.ex-1-12)

(defn pascal [row col]
  (if (or (= row col) (= col 1) (= row 1)) 1 ; (= row col)は右端の例
      (+ (pascal (- row 1) col)
         (pascal (- row 1) (- col 1)))))

(pascal 5 3) ; 6
