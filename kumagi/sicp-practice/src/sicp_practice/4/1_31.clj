(defn sum [term a nxt b]
	(if (> a b)
		0
		(+ (term a) (sum term (nxt a) nxt b))))
(defn cube [x] (* x x x))
(defn sum-cubes [a b]
	(sum cube a inc b))
(sum-cubes 1 10) ; => 3025

(defn sum-integers [a b]
	(sum identity a inc b))
(sum-integers 1 10)
(defn pi-sum [a b]
	(defn pi-term [x]
		(/ 1.0 (* x (+ x 2))))
	(defn pi-next [x]
		(+ x 4))
	(sum pi-term a pi-next b))
(* 8 (pi-sum 1 10000)); 100000だとstack over flow

;; sumの掛け算版のproductをかけ。再帰版と反復版の両方

; 再帰版。単位元が1になるぐらいで難しくない
(defn product-rec [term a nxt b]
	(if (> a b)
		1.0
		(* (term a) (product-rec term (nxt a) nxt b))))
; 反復版。1.30とほぼ同じ
(defn product-itr [term a nxt b]
  (defn itr [a result]
    (if (> a b) result
        (itr (nxt a) (* result (term a)))))
  (itr a 1))
(defn factorial [n]
  (product-itr #(+ % 0) 1 #(+ % 1) n))
(factorial 5)


; pi = 4 * (2/3) * (4/3) * (4/5) * (6/5) ...
(defn pow [n] (* n n))
(defn pi [a]
  (if (even? a) ; 偶数奇数で切り分け。2項ずつを相手にしていく
    (* 4.0 ; 偶数なら        (2*4)/(3^2) * (4*6)/(5^2) * (6*8)/(7^2)...
       (product-itr #(/ (* % (+ % 2)) (pow (+ % 1))) 2.0 #(+ % 2) a))
    (* 4.0 ; 奇数なら(2/3) * (4^2)/(3*5) * (6^2)/(5*7) * (8^2)/(7*9)...
       (/ 2 3)
       (product-itr #(/ (pow %) (* (- % 1) (+ % 1))) 4.0 #(+ % 2) a))))
;(println  (map #(println (pi %)) (range 10000)))
(println (map pi (range 100)))
