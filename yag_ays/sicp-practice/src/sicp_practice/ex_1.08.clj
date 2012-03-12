(defn cube [x]
  (* x x x))

(defn good-enough? [guess x]
  (< (Math/abs (- (cube guess) x))
     0.001))

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (/ (+ (/ x (* guess guess))
        (* 2 guess))
     3))

(defn cbrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (cbrt-iter (improve guess x)
               x)))

(cbrt-iter 1.0 27)
;; 3.0000005410641766
