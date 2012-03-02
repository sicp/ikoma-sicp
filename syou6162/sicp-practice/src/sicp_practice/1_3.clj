(ns sicp-practice.1-3
  (:use [clojure.contrib.generic.math-functions :only (sin cos)]))

;; 引数としての手続き

(defn sum [term a next b]
  (if (> a b)
    0
    (+ (term a)
       (sum term (next a) next b))))

(defn sum-cubes [a b]
  (sum #(* % % %) a inc b))

(sum-cubes 1 10)

(defn sum-integers [a b]
  (sum (fn [x] x) a inc b))

(sum-integers 1 10)

(defn pi-sum [a b]
  (sum #(/ 1.0 (* % (+ % 2))) a #(+ % 4) b))

(* 8 (pi-sum 1 1000))

(defn integral [f a b dx]
  (* (sum f (+ a (/ dx 2.0)) #(+ % dx) b)
     dx))

(integral #(* % % %) 0 1 0.01)
(integral #(* % % %) 0 1 0.001)

;; 1.3.3 一般的方法としての手続き

(defn average [x y] (/ (+ x y) 2))

(def eps 0.001)

(defn close-enough? [x y]
  (< (Math/abs (- x y)) eps))

(defn search [f neg-point pos-point]
  (let [midpoint (average neg-point pos-point)]
    (if (close-enough? neg-point pos-point)
      midpoint
      (let [test-value (f midpoint)]
	(cond (pos? test-value) (search f neg-point midpoint)
	      (neg? test-value) (search f midpoint pos-point)
	      :else midpoint)))))

(defn half-interval-method [f a b]
  (let [a-value (f a)
	b-value (f b)]
    (cond (and (neg? a-value) (pos? b-value)) (search f a b)
	  (and (neg? b-value) (pos? a-value)) (search f b a)
	  :else (throw (Exception. (str "Values are not of opposite sign" a b))))))

(half-interval-method sin 2.0 4.0) ; 3.14111328125

(half-interval-method (fn [x] (- (* x x x) (* 2 x) 3))
		      1.0
		      2.0) ; 1.89306640625

(defn fixed-point [f first-guess]
  (letfn [(close-enough? [v1 v2]
			 (< (Math/abs (- v1 v2)) eps))
	  (my-try [guess]
		  (let [my-next (f guess)]
		    (if (close-enough? guess my-next)
		      my-next
		      (my-try my-next))))]
    (my-try first-guess)))

(fixed-point cos 1.0) ; 0.7387603198742113

(fixed-point (fn [y] (+ (sin y) (cos y)))
	     1.0) ; 1.259003859740025
