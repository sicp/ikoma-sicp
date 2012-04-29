(defn variable? [x] (symbol? x))

(defn same-variable? [v1 v2]
  (and (variable? v1) (variable? v2) (= v1 v2)))

(defn make-sum [a1 a2] (list '+ a1 a2))

(defn make-product [m1 m2] (list '* m1 m2))

(defn sum? [x] (and (seq? x) (= (first x) '+)))

(defn addend [s] (first (next s))) ; cadr

(defn augend [s] (first (next (next s)))) ; caddr

(defn product? [x] (and (seq? x) (= (first x) '*)))

(defn multiplier [p] (first (next p)))

(defn multiplicand [p] (first (next (next p))))


(defn deriv [exp var]
  (cond (number? exp) 0
        (variable? exp) (if (same-variable? exp var) 1 0)
        (sum? exp) (make-sum (deriv (addend exp) var)
                             (deriv (augend exp) var))
        (product? exp) (make-sum (make-product (multiplier exp)
                                               (deriv (multiplicand exp) var))
                                 (make-product (deriv (multiplier exp) var)
                                               (multiplicand exp)))
        :else (println "error : unknown expression type -- DERIV")))


(deriv '(+ x 3) 'x)
;; (+ 1 0)

(deriv '(* x y) 'x)
;; (+ (* x 0) (* 1 y))

(deriv '(* (* x y) (+ x 3)) 'x)
;; (+ (* (* x y) (+ 1 0)) (* (+ (* x 0) (* 1 y)) (+ x 3)))


;;==============================
;; 式を簡約化するためにmake-sumとmake-productを変更

(defn =number? [exp num]
  (and (number? exp) (= exp num)))

(defn make-sum [a1 a2]
  (cond (=number? a1 0) a2
        (=number? a2 0) a1
        (and (number? a1) (number? a2)) (+ a1 a2)
        :else (list '+ a1 a2)))

(defn make-product [m1 m2]
  (cond (or (=number? m1 0) (=number? m2 0)) 0
        (=number? m1 1) m2
        (=number? m2 1) m1
        (and (number? m1) (number? m2)) (* m1 m2)
        :else (list '* m1 m2)))


(deriv '(+ x 3) 'x)
;; 1

(deriv '(* x y) 'x)
;; y



;;==============================
;; ex_2.56

(defn exponentiation? [x]
  (and (seq? x) (= (first x) '**)))

(defn base [s] (first (next s)))

(defn exponent [s] (first (next (next s))))


(defn make-exponentation [base exp]
  (cond (= 0 exp) 1
        (= 1 exp) base
        (and (number? base) (= 0 base)) 0
        (and (number? base) (= 1 base)) 1
        :else (list '** base exp)))


(defn deriv [exp var]
  (cond (number? exp) 0
        (variable? exp) (if (same-variable? exp var) 1 0)
        (sum? exp) (make-sum (deriv (addend exp) var)
                             (deriv (augend exp) var))
        (product? exp) (make-sum (make-product (multiplier exp)
                                               (deriv (multiplicand exp) var))
                                 (make-product (deriv (multiplier exp) var)
                                               (multiplicand exp)))
        (exponentiation? exp) (make-product
                               (make-product (exponent exp)
                                             (make-exponentation (base exp) (dec (exponent exp))))
                               (deriv (base exp) var))
        :else (println "error : unknown expression type -- DERIV")))


(deriv '(** x 3) 'x)
;; (* 3 (** x 2))
