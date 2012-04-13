(ns sicp-practice.ex-1-46)

;; 割とただただ書くだけの問題
(defn iterative-improve [good-enough? improve]
  (letfn [(check [guess]
		 (let [next-guess (improve guess)]
		   (if (good-enough? guess next-guess)
		     next-guess
		     (check next-guess))))]
    ;; 引数として予測値を取り、予測値が十分になるまで改良する手続きを戻り値として返す
    (fn [initial-guess]
      (check initial-guess))))

(defn average [x y]
  (/ (+ x y) 2))
 
(defn square [x] (* x x))

(def epsilon 0.00001)

(defn sqrt [x]
  (letfn [(good-enough? [guess next-guess]
			(< (Math/abs (- (square next-guess) x)) epsilon))
	  (improve [guess]
		   (average guess (/ x guess)))]
    ((iterative-improve good-enough? improve) x)))

(sqrt 9.0) ; 3.00009155413138
 
(defn fixed-point [f first-guess]
  (letfn [(close-enough? [guess next-guess]
			 (< (Math/abs (- guess next-guess)) epsilon))
	  (improve [guess] (f guess))]
    ((iterative-improve close-enough? improve) first-guess)))

(defn average-damp [f]
  (fn [x] (average x (f x))))
 
(defn fixed-point-sqrt [x]
  (fixed-point (average-damp (fn [y] (/ x y)))
	       1.0))

(fixed-point-sqrt 9.0) ; 3.0
