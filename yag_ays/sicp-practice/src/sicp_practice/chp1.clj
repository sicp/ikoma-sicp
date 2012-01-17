;; 1.1
10

(+ 5 3 4)

(- 9 1)

(/ 6 2)

(+ (* 2 4) (- 4 6))

(def a 3)

(def b (+ a 1))

(+ a b (* a b))

(= a b)

(if (and (> b a) (< b (* a b)))
  b
  a)

(cond (= a 4) 6
      (= b 4) (+ 6 7 a)
      :else 25)

(+ 2 (if (> b a) b a))

(* (cond (> a b) a
         (< a b) b
         :else -1)
   (+ a 1))


;; 1.2
(/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
   (* 3 (- 6 2) (- 2 7)))

;; 1.3
(defn problem1-3 [a b c]
  (cond (and (<= a b) (<= a c)) (* b c)
        (and (<= b a) (<= b c)) (* a c)
        (and (<= c a) (<= c b)) (* a b)))


;; 1.4
;; bが0より大きければa+b，bが0以下ならばa-b

;; 1.5
;; 作用的順序の場合では(p) -> (p)を繰り返すのでtestが評価されない

;; 1.6

;; 1.7

;; 1.8

;; 1.9
;; pattern-1
(defn plus [a b]
  (if (= a 0)
    b
    (inc (plus (dec a) b))))

;; (plus 4 5)
;; (inc (plus (dec 4) 5))
;; (inc (inc (plus (dec 3) 5)))
;; (inc (inc (inc (plus (dec 2) 5))))
;; (inc (inc (inc (inc (plus (dec 1) 5)))))
;; (inc (inc (inc (inc 5))))
;; (inc (inc (inc 6)))
;; (inc (inc 7))
;; (inc 8)
;; 9
;; 再帰的


;; pattern-2
(defn plus [a b]
  (if (= a 0)
    b
    (plus (dec a) (inc b))))

;; (plus 4 5)
;; (plus 3 6)
;; (plus 2 7)
;; (plus 1 8)
;; (plus 0 9)
;; 9
;; 反復的


;; 1.10
(defn A [x y]
  (cond (= y 0) 0
        (= x 0) (* 2 y)
        (= y 1) 2
        :else (A (- x 1)
                 (A x (- y 1)))))

(A 1 10)
(A 2 4)
(A 3 3)

(defn f [n] (A 0 n))
(defn g [n] (A 1 n))
(defn h [n] (A 2 n))


;; 1.11
;; 再帰的プロセス
(defn f [n]
  (if (< n 3)
    n
    (+ (f (- n 1))
       (* 2 (f (- n 2)))
       (* 3 (f (- n 3))))))


;; 反復的プロセス
(defn f [n]
  (f-iter 2 1 0 n))

(defn f-iter [a b c count]
  (cond (= count 0) c
        (= count 1) b
        :else (f-iter (+ a (* b 2) (* c 3)) a b (- count 1))))

;; example
(f 1)
(f 2)
(f 3)
(f 4)
(f 5)

