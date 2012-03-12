(defn double [n]
  (+ n n))

(defn halve [n]
  (/ n 2))

(defn fast-prod [a b]
  (cond (= b 0) 0
        (even? b) (double (fast-prod a (halve b)))
        :else (+ a (fast-prod a (- b 1))) ))

(fast-prod 2 2)
(fast-prod 2 3)
(fast-prod 2 4)
