(ns sicp-practice.ex-1-16)

(use 'clojure.tools.trace)

;; 再帰的定義
;; スペースもステップもO(n)
(defn expt [b n]
  (if (= n 0)
    1
    (* b (expt b (- n 1)))))

(expt 2 3) ; 8

;; 線形再帰的プロセスによる定義
;; ステップはO(n)、スペースはO(1)
(defn expt-iter [b counter product]
  (if (= counter 0)
    product
    (expt-iter b
	       (- counter 1)
	       (* b product))))

(defn expt [b n]
  (expt-iter b n 1))

(expt 2 3) ; 8

;; 再帰的定義を対数ステップで
;; ステップはO(log n)、スペースはO(log n)
(defn sqrt [n]
  (* n n))

(defn fast-expt [b n]
  (cond (= n 0) 1
	(even? n) (sqrt (fast-expt b (/ n 2)))
	:else (* b (fast-expt b (- n 1)))))

(fast-expt 2 3)

;; 反復的プロセスを対数時間で(これが問題)
;; ステップはO(log n)、スペースはO(1)を目標に!

;; a * b^nは一定にして、反復が終わったらaが答えになっているようにする

;; まずnに関して作戦を立てる
;; 1: 対数時間を目指すので、nが偶数のときに2で割っていくようにしないと対数時間にならない
;; 2: nが偶数のときにはnにn-1を入れていくしかない

;; 次にaとbに関して作戦を立てる

;; nが偶数のとき、例えば2^6のとき
;; 2^6 = 1 \times 2^6
;;     = 1 \times (2^2)^{6/2}
;; とすると基底bが二乗になっていく感じで書けば対数時間でできそうと分かる

;; nが奇数のとき、例えば2^7のとき
;; 2^7 = 1 \times 2^7
;;     = 1 \times 2 \times 2^6
;; とすると基底は今度は変わらず、aをb倍していけばよさそうと分かる
;; aを2倍ではなくb倍なのはb = 3とかでやると分かる
;; 3^7 = 1 \times 3^7
;;     = 1 \times 3 \times 2^6

(defn fast-expt-iter [a b n]
  (cond (= n 0) a
	;; 基底を二乗していく!
	(even? n) (fast-expt-iter a (sqrt b) (/ n 2))
	:else (fast-expt-iter (* b a) b (- n 1))))

(defn fast-expt [b n]
  (fast-expt-iter 1 b n))

(fast-expt 2 3)
(fast-expt 2 8)