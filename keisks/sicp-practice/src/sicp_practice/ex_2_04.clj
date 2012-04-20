
(defn cons-alt [x y]
  (fn [m] (m x y)))

(defn car [z]
    (z (fn [p q] p)))

(car (cons-alt 1 2))

(defn cdr [z]
    (z (fn [p q] q)))

(cdr (cons-alt 1 2))

;;よくわからないので要質問
