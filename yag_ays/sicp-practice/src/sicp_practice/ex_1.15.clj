(defn cube [x]
  (* x x x))

(defn p [x]
  (- (* 3 x) (* 4 (cube x))))

(defn abs [x]
  (if (> x 0)
    x
    (- x)))

(defn sine [angle]
  (if (<=  (abs angle) 0.1)
    angle
    (p (sine (/ angle 3.0)))))

(sine 12.15)


(use 'clojure.tools.trace)
(dotrace [p] (sine 12.15))
;; TRACE t1857: (p 0.049999999999999996)
;; TRACE t1857: => 0.1495
;; TRACE t1858: (p 0.1495)
;; TRACE t1858: => 0.4351345505
;; TRACE t1859: (p 0.4351345505)
;; TRACE t1859: => 0.9758465331678772
;; TRACE t1860: (p 0.9758465331678772)
;; TRACE t1860: => -0.7895631144708228
;; TRACE t1861: (p -0.7895631144708228)
;; TRACE t1861: => -0.39980345741334
