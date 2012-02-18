(defn square [x]
  (* x x))
(defn average [x y]
  (/ (+ x y) 2))
(defn abs [x]
  (if (< 0 x) x
      ( * x -1)))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))
(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x)
               x)))

;; ここから解答

(println 'before)
(println (sqrt-iter 9999999999.1 10000000000)) ; => 100000.0 あれ、何か問題おきます？
(println (sqrt-iter 1 0.000001)) ; => 0.03135649010771716 だけど二乗すると0.0009832294718753643でおよそ3ケタ間違ってる


(defn good-enough?2 [guess x]
  (< (abs (- (improve guess x) guess)) (* guess 0.001)))

(defn sqrt-iter2 [guess x]
  (if (good-enough?2 guess x)
    guess
    (sqrt-iter2 (improve guess x)
               x)))
(println 'after)
(println (sqrt-iter2 1.1 10000000000))   ; => 100001.95765324772 なんか悪化してる…guessの値と差分とを比べてるので仕方ない気がする
(println (sqrt-iter2 1 0.000001)) ; => 0.0010000001533016628で、2乗すると1.0000003066033492e-06 多分あってる
(println (sqrt-iter 1.1 100000000000000000000000000000000000000000000.0))



