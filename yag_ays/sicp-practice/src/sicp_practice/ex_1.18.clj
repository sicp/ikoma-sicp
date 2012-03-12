(defn double [n]
  (+ n n))

(defn halve [n]
  (/ n 2))

(defn fast-prod [a b]
  (fast-prod-iter a b 0))

(defn fast-prod-iter [a counter product]
  (cond (= counter 0) product
        (even? counter) (fast-prod-iter (double a) (halve counter) product)
        :else (fast-prod-iter a (- counter 1) (+ product a))))

(fast-prod 2 1)
(fast-prod 2 2)
(fast-prod 2 3)
(fast-prod 2 4)
