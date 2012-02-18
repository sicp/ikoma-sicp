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
  (cond (and (<= a b) (<= a c)) (+ (* b b) (* c c))
        (and (<= b a) (<= b c)) (+ (* a a) (* c c))
        (and (<= c a) (<= c b)) (+ (* a a) (* b b))))


;; 1.4
;; bが0より大きければa+b，bが0以下ならばa-b

;; 1.5
;; Ans. 正規順序の場合では(p) -> (p)を繰り返すのでtestが評価されない


;; 正規順序の場合
(test 0 (p))
(test 0 (p)) ; (p)を展開して(p)になる
;; 以下無限ループ


;; 作用的順序の場合
(test 0 (p))
(if (= 0 0) 0 (p))
0

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

;; 解説
;; f (n)の1項目をa，2項目をb，3項目をcとすると，f (n+1)の各項a',b',c'は
;; a' <- a+2b+3c
;; b' <- a
;; c' <- b
;; となる．



;; 1.15
(defn cube [x]
  (* x x x))

(defn p [x]
  (- (* 3 x) (* 4 (cube x))))

(defn abs [x]
  (if (> x 0)
    x
    (- x)))

(defn sine [angle]
  (if (<=  (abs angle) 0.1)
    angle
    (p (sine (/ angle 3.0)))))

(sine 12.15)


(use 'clojure.tools.trace)
(dotrace [p] (sine 12.15))
;; TRACE t1857: (p 0.049999999999999996)
;; TRACE t1857: => 0.1495
;; TRACE t1858: (p 0.1495)
;; TRACE t1858: => 0.4351345505
;; TRACE t1859: (p 0.4351345505)
;; TRACE t1859: => 0.9758465331678772
;; TRACE t1860: (p 0.9758465331678772)
;; TRACE t1860: => -0.7895631144708228
;; TRACE t1861: (p -0.7895631144708228)
;; TRACE t1861: => -0.39980345741334


;; 1.16

(defn fast-expt-seq [b n]
  (fast-expt-seq-iter b n 1))

;; 間違い
;; (defn fast-expt-seq-iter [b counter product]
;;   (if (= counter 0)
;;       product
;;       (if (odd? counter)
;;           (fast-expt-seq-iter b
;;                               (- counter 1)
;;                               (* product b))
;;           (fast-expt-seq-iter b
;;                               (/ counter 2)
;;                               (nth (iterate (partial * b) product) (/ counter 2))))))


(defn fast-expt-seq-iter [b counter product]
  (cond (= counter 0) product
        (even? counter) (fast-expt-seq-iter (* b b)
                                            (/ counter 2)
                                            product)
        :else (fast-expt-seq-iter b
                          (- counter 1)
                          (* product b))))

(fast-expt-seq 2 1)
(fast-expt-seq 2 2)
(fast-expt-seq 2 3)
(fast-expt-seq 2 4)
(fast-expt-seq 2 5)

;; 解説
;; e.g. 2^{10} = 4^5 = 4 ¥times 4^4 = 4 ¥times 16^2 = 4 ¥times 256^1
;; ../../img/supplementary_1.16.png

;; 1.17

(defn double [n]
  (+ n n))

(defn halve [n]
  (/ n 2))

(defn fast-prod [a b]
  (cond (= b 0) 0
        (even? b) (double (fast-prod a (halve b)))
        :else (+ a (fast-prod a (- b 1))) ))

(fast-prod 2 2)
(fast-prod 2 3)
(fast-prod 2 4)


;; 1.18
;; double,halveが必要
(defn fast-prod [a b]
  (fast-prod-iter a b 0))

(defn fast-prod-iter [a counter product]
  (cond (= counter 0) product
        (even? counter) (fast-prod-iter (double a) (halve counter) product)
        :else (fast-prod-iter a (- counter 1) (+ product a))))

(fast-prod 2 1)
(fast-prod 2 2)
(fast-prod 2 3)
(fast-prod 2 4)