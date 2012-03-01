(defn cube [x]
  (* x x x))

(defn sum [term a nxt b]
  (if (> a b)
    0
    (+ (term a) (sum term (nxt a) nxt b))))

(defn integral [f a b dx]
  (* (sum f (+ a (/ dx 2.0)) #(+ % dx) b)
     dx))

(integral cube 0 1 0.01)  ;; 0.24998750000000042
(integral cube 0 1 0.001) ;; 0.249999875000001


;; Simpson's rule
(defn simpson [f a b n]
  (def h (/ (- b a) n))
  (defn y [k] (f (+ a (* k h))))
  (defn term [k] (cond (or (= k 0) (= k n)) (y k)
                           (even? k)            (* 2 (y k))
                           :else                (* 4 (y k))))
  (* (sum term 0 inc n)
       (/ h 3)))

(simpson cube 0 1 100.0)  ;; 0.24999999999999992
(simpson cube 0 1 1000.0) ;; 0.2500000000000003


;; (sum term 0 inc n)
;; (+ (term 0) (sum term (inc 0) inc n))
;; (+ (term 0) (+ (term 1) (sum term (inc 1) inc n)))
;; (+ (term 0) (+ (term 1) (+ (term 2 (sum term (inc 2) inc n)))))
;; ...
