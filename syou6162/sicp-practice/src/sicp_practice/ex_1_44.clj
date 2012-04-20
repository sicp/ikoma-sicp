(ns sicp-practice.ex-1-44
  (:use [incanter core charts]))

(defn repeated [f t]
  (if (zero? t)
    identity
    (comp f (repeated f (dec t)))))

(def dx 0.5)

(defn smooth [f]
  (fn [x] (/ (+ (f (- x dx))
                (f x)
                (f (+ x dx)))
             3)))

(defn n-fold-smooth [f n]
  ((repeated smooth n) f))

(defn my-third-func [x]
  (+ (* (/ 1 4) x x x)
     (* (/ 3 4) x x)
     (* (- (/ 3 2)) x)
     -2))

(let [x-start -3
      x-end 3]
  (doto (function-plot (n-fold-smooth my-third-func 1) x-start x-end)
    (add-function (n-fold-smooth my-third-func 2) x-start x-end)
    (add-function (n-fold-smooth my-third-func 3) x-start x-end)
    (add-function (n-fold-smooth my-third-func 4) x-start x-end)
    (add-function (n-fold-smooth my-third-func 5) x-start x-end)
    view))
