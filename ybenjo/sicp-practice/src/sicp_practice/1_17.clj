(defn double [x] (+ x x)
  )

(defn halve [x](/ x 2)
  )

; a * b = 2a * b/2 = 2 * (2a * b/4) = 2 * 2 * (2a * b/8) = ... ? 
(defn fast-* [a b](cond (= b 0) 0
                        (even? b) (double (fast-* a (halve b) ))
                        :else (+ a (fast-* a (- b 1)))
                        )
  )
