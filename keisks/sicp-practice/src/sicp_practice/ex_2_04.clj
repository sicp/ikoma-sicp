
(defn cons-alt [x y]
  (fn [m] (m x y)))

(defn car [z]
    (z (fn [p q] p)))

(car (cons-alt 1 2))

(defn cdr [z]
    (z (fn [p q] q)))

(cdr (cons-alt 1 2))

;; (cdr (const-alt 1 2))
;; ((const-alt 1 2) (fn [p q] q))  ;; apply 'cdr'
;; ((fn [m] (m 1 2)) (fn [p q] q)) ;; apply 'const-alt'
;; ((fn [p q] q) 1 2) ;; apply 'fn [m]'
;; (2)
