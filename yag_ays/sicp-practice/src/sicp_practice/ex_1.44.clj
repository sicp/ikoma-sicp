(defn repeated [f t]
  (if (zero? t)
    identity
    (comp f (repeated f (dec t)))))


(def dx 0.00001)
(defn smooth [f]
  (fn [x] (/ (+ (f (- x dx))
                (f x)
                (f (+ x dx)))
             3)))

(defn n-fold-smooth [f n]
  (repeated smooth n) f)
