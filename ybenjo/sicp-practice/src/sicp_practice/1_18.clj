(defn double [x] (+ x x)
  )

(defn halve [x] (/ x 2)
  )

; a * b = 2a * b/2 = 2 * (2a * b/4) = 2 * 2 * (2a * b/8) = ... ? 
(defn iter-* [a b c](cond (= b 0) c
                          (even? b) (double (iter-* a (halve b) c))
                          :else (iter-* a (- b 1) (+ c a))
                          )
  )

(defn lin* [a b](iter-* a b 0))

