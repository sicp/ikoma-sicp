(defn variable? [x] (symbol? x))
(defn same-variable? [v1 v2] (and (variable? v1) (variable? v2) (= v1 v2)))
(defn =number? [exp num] (and (number? exp) (= exp num)))

;; sum
(defn sum? [x] (and (seq? x) (= (second x) '+)))
(defn addend [s] (first s))
(defn augend [s] (first (next (next s))))
;; product
(defn product? [x] (and (seq? x) (= (second x) '*)))
(defn multiplier [p] (first p))
(defn multiplicand [p] (first (next (next p))))
;; exponent
(defn exponentiation? [x] (and (seq? x) (= (second x) '**)))
(defn base [s] (first s))
(defn exponent [s] (first (next (next s))))

(defn make-sum [a1 a2]
  (cond (=number? a1 0) a2
        (=number? a2 0) a1
        (and (number? a1) (number? a2)) (+ a1 a2)
        :else (list a1 '+ a2)))
(defn make-product [m1 m2]
  (cond (or (=number? m1 0) (=number? m2 0)) 0
        (=number? m1 1) m2
        (=number? m2 1) m1
        (and (number? m1) (number? m2)) (* m1 m2)
        :else (list m1 '* m2)))
(defn make-exponentation [base exp]
  (cond (= 0 exp) 1
        (= 1 exp) base
        (and (number? base) (= 0 base)) 0
        (and (number? base) (= 1 base)) 1
        :else (list base '** exp)))

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


(deriv '(x + 3) 'x)
;; 1

(deriv '(x + (3 * (x + (y + 2)))) 'x)
;; 4
