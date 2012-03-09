(defn cons-1 [x y]
  (defn dispatch [m]
    (cond (= m 0) x
          (= m 1) y
          :else (println "Argument not 0 or 1 -- CONS")))
  dispatch)

(defn car-1 [z] (z 0))
(defn cdr-1 [z] (z 1))
(defn err-1 [z] (z 2))

(cons-1 1 2)

(car-1 (cons-1 1 2))
(cdr-1 (cons-1 1 2))
(err-1 (cons-1 1 2))


;; Alternative procedural representation of pairs
(defn cons-2 [x y] (fn [m] (m x y)))
(defn car-2 [z] (z (fn [p q] p)))
(defn cdr-2 [z] (z (fn [p q] q)))

(cons-2 1 2)          ;; (fn [m] (m 1 2)
(car-2 (cons-2 1 2))  ;; ((fn [p q] p) 1 2) => 1
(cdr-2 (cons-2 1 2))  ;; ((fn [p q] q) 1 2) => 2
