(ns sicp-practice.ex-1-15)

(use 'clojure.tools.trace)


(defn cube [x] (* x x x))

(defn ^:dynamic p [x]
  (- (* 3 x) (* 4 (cube x))))

(defn sine [angle]
  (if (not (> (Math/abs angle) 0.1))
    angle
    (p (sine (/ angle 3.0)))))

(dotrace [p] (sine 12.15))
;; TRACE t2058: (p 0.049999999999999996)
;; TRACE t2058: => 0.1495
;; TRACE t2059: (p 0.1495)
;; TRACE t2059: => 0.4351345505
;; TRACE t2060: (p 0.4351345505)
;; TRACE t2060: => 0.9758465331678772
;; TRACE t2061: (p 0.9758465331678772)
;; TRACE t2061: => -0.7895631144708228
;; TRACE t2062: (p -0.7895631144708228)
;; TRACE t2062: => -0.39980345741334

;; 5回呼び出されている。aは3でずっと割られていくのでO(log_3 a)