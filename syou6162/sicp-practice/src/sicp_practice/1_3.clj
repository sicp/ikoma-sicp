(ns sicp-practice.1-3)

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

