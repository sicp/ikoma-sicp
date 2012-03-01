(defn product-recur [term a nxt b]
  (if (> a b)
    1
    (* (term a) (product-recur term (nxt a) nxt b))))

(defn product-iter [term a nxt b]
  (defn iter [c result]
    (if (> c b)
      result
      (iter (nxt c) (* (term c) result))))
  (iter a 1))

(defn factorial [n]
  (product-recur identity 1 inc n))

;; (defn factorial [n]
;;   (product-iter identity 1 inc n))


(factorial 10)
;; 3628800
;; (= (factorial 10) (apply * (range 1 11)))


(defn pi [n]
  (defn fact-interval [m]
    (if (even? m)
      (+ m 2)
      (+ m 3)))
  (* (product-recur #(/ (fact-interval %) (inc (fact-interval (dec %)))) 0 inc n)
     4.0))

;; n = iteration counts
(pi 1000)
