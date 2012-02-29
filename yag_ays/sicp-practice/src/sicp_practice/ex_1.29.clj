(defn cube [x]
  (* x x x))

(defn sum [term a nxt b]
  (if (> a b)
    0
    (+ (term a) (sum term (nxt a) nxt b))))

(defn integral [f a b dx]
  (* (sum f (+ a (/ dx 2.0)) #(+ % dx) b)
     dx))

(integral cube 0 1 0.01)
(integral cube 0 1 0.001)


;; Simpson's rule
(defn simpson [f a b n]
  (let [h    (/ (- b a) n)
        y    (fn [k] (f (+ a (* k h))))
        term (fn [k] (cond (or (= k 0) (= k n)) (y k)
                           (even? k)            (* 2 (y k))
                           :else                (* 4 (y k))))]
    (* (sum term 0 inc n)
       (/ h 3))))

(simpson cube 0 1 100.0)
(simpson cube 0 1 1000.0)
