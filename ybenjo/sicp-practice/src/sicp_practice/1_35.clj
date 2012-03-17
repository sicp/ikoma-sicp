(def tolerance 0.00001)

(defn fixed-point [f first-guess]
  (defn close-enough? [v1 v2]
    (< (Math/abs (- v1 v2)) tolerance))
  (defn retry [guess]
    (let [nxt (f guess)]
      (if (close-enough? guess nxt) nxt
          (retry nxt))))
  (retry first-guess))

(fixed-point (fn [x] (+ 1 (/ 1 x))) 2.0)
; 1.6180327868852458
