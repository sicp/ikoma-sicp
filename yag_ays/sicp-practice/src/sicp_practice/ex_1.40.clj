(def tolerance 0.00001)
(defn fixed-point [f first-guess]
  (defn close-enough? [v1 v2]
    (< (Math/abs (- v1 v2)) tolerance))
  (defn my-try [guess]
    (let [nxt (f guess)]
      (if (close-enough? guess nxt)
        nxt
        (my-try nxt))))
  (my-try first-guess))

(def dx 0.00001)
(defn deriv [g]
  (fn [x] (/ (- (g (+ x dx)) (g x))
             dx)))
(defn cube [x] (* x x x))
((deriv cube) 5) ;; 75.00014999664018


(defn newton-transform [g]
  (fn [x] (- x (/ (g x) ((deriv g) x)))))
(defn newton-method [g guess]
  (fixed-point (newton-transform g) guess))

(defn sqrt [x] (newton-method (fn [y] (- (* y y) x))
                              1.0))
(sqrt 2) ;; 1.4142135623822438
(sqrt 3) ;; 1.7320508075688852



(defn cubic [a b c]
  (fn [x] (+ (* x x x) (* a x x) (* b x) c)))

(newton-method (cubic 1 1 1) 1) ;; -0.9999999999997796
