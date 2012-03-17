; \pi/ 4 = 2/3 * 4/3 * 4/5 * 6/5 * 6/7 * 8/7....

; (a)
; まずは与えられた範囲内での積を返す関数
(defn product [term nxt a b]
  (defn each-prod [a ans]
    (if (> a b)
      ans
      (each-prod (nxt a) (* ans (term a)))))
  (each-prod a 1))


(defn factorial [x]
  (product identity inc 1 x))

(defn sqrt [x]
  (* x x))

; integer overflow
; (defn pi [lim]
;   (* (/ (sqrt (product 2 lim (fn [x] (+ x 2))))  (sqrt (product 1 lim (fn [x] (+ x 2)))) ) 2))

; (b)

(defn product_2 [term nxt a b]
  (if (> a b)
    1
    (* (term a) (product_2 term nxt (nxt a) b))))

(defn factorial_2 [x]
  (product_2 identity inc 1 x))


