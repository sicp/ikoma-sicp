(defn variable? [x]
  (symbol? x))

(defn =number? [v1 v2]
  (and (number? v1) (= v1 v2)))

(defn same-variable? [v1 v2]
  (and (variable? v1) (variable? v2) (= v1 v2)))

(defn make-sum [a b]
  (cond (=number? a 0) b
        (=number? b 0) a
        (and (number? a) (number? b)) (+ a b)
        :else (list '+ a b)))

(defn sum? [x]
  (and (list? x) (= (first x) '+)))

(defn addend [s]
  (second s))

(defn augend [s]
  (first (next (next s))))

(defn make-product [a b]
  (cond (or (=number? a 0) (=number? b 0)) 0
        (=number? a 1) b
        (=number? b 1) a
        (and (number? a) (number? b)) (* a b)
        :else (list '* a b)))

(defn product? [x]
  (and (list? x) (= (first x) '*)))

(defn multiplier [x]
  (second x))

(defn multiplicand [x]
  (first (next (next x))))

(defn make-exponentiation [a b]
  (cond (=number? b 0) 1
        (=number? b 1) a
        :else (list '** a b)
        ))

(defn exponentiation? [x]
  (and (list? x) (= (first x) '**)))

(defn base [x]
  (second x))

(defn exponent [x]
  (first (next (next x))))

(defn deriv [exp var]
  (cond (number? exp) 0
        (variable? exp) (if (same-variable? exp var) 1 0)
        (sum? exp) (make-sum (deriv (addend exp) var)
                             (deriv (augend exp) var))
        (product? exp) (make-sum (make-product (multiplier exp)
                                     (deriv (multiplicand exp) var))
                                 (make-product (deriv (multiplier exp) var)
                                               (multiplicand exp)))
        (exponentiation? exp) (make-product (deriv (base exp) var)
                                            (make-product (exponent exp)
                                                          (make-exponentiation (base exp)
                                                                               (dec (exponent exp)))))
        :else (println "error!")))


; x^2 -> 2x
; user=> (deriv '(** x 2) 'x)
; (* 2 x)

; (x^3 + 2x)^3 -> 3(3x^2 + 2)(x^3 + 2x)^2
; user=> (deriv '(** (+ (** x 3) (* 2 x)) 3) 'x)
; (* (+ (* 3 (** x 2)) 2) (* 3 (** (+ (** x 3) (* 2 x)) 2)))

