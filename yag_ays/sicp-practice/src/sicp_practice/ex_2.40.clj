;; ex_1.22.clj
(defn smallest-divisor [n]
  (find-divisor n 2))

(defn find-divisor [n test-divisor]
  (cond (> (* test-divisor test-divisor) n) n
        (divides? test-divisor n)           test-divisor
        :else (find-divisor n (+ test-divisor 1))))

(defn divides? [a b]
  (= (rem b a) 0))

;; (関数名変更)
(defn prime? [n]
    (= (smallest-divisor n) n))




;; ex_2.33
(defn accumulate [op initial s]
  (if (empty? s)
    initial
    (op (first s)
        (accumulate op initial (rest s)))))

(defn enumerate-interval [low high]
  (if (> low high)
    nil
    (cons low (enumerate-interval (+ low 1) high))))
;; e.g.
(enumerate-interval 1 5) ;; (1 2 3 4 5)
(enumerate-interval 2 10) ;; (2 3 4 5 6 7 8 9 10)




;; P.71~
(defn flatmap [proc sq]
  (accumulate concat nil (map proc sq)))

(defn prime-sum? [pair]
  (prime? (+ (first pair) (second pair))))

(defn make-pair-sum [pair]
  (list (first pair) (second pair) (+ (first pair) (second pair))))

(defn prime-sum-pairs [n]
  (map make-pair-sum
       (filter prime-sum?
               (flatmap (fn [i] (map (fn [j] (list i j))
                                     (enumerate-interval 1 (- i 1))))
                        (enumerate-interval 1 n)))))
;; e.g.
(flatmap (fn [i] (map (fn [j] (list i j))
                      (enumerate-interval 1 (- i 1))))
         (enumerate-interval 1 6))
;; ((2 1) (3 1) (3 2) (4 1) (4 2) (4 3) (5 1) (5 2) (5 3) (5 4) (6 1) (6 2) (6 3) (6 4) (6 5))

(flatmap (fn [i] (list (+ i 1))) '(1 2 3))
;; (2 3 4)



(prime-sum-pairs 6)
;; ((2 1 3) (3 2 5) (4 1 5) (4 3 7) (5 2 7) (6 1 7) (6 5 11))




(defn permutations [s]
  (if (empty? s)
    (list nil)
    (flatmap (fn [x] (map (fn [p] (cons x p))
                          (permutations (rmv x s))))
             s)))

(defn rmv [item sq]
  (filter (fn [x] (not (= x item)))
          sq))


(permutations '(1 2 3))
;; ((1 2 3) (1 3 2) (2 1 3) (2 3 1) (3 1 2) (3 2 1))




;;ex_2.40
(defn union-pairs [n] (flatmap (fn [i] (map (fn [j] (list i j))
                                            (enumerate-interval 1 (- i 1))))
                               (enumerate-interval 1 n)))
(union-pairs 6)
;; ((2 1) (3 1) (3 2) (4 1) (4 2) (4 3) (5 1) (5 2) (5 3) (5 4) (6 1) (6 2) (6 3) (6 4) (6 5))

(defn prime-sum-pairs-with-union-pairs [n]
  (map make-pair-sum
       (filter prime-sum? (union-pairs n))))

(prime-sum-pairs-with-union-pairs 6)
;; ((2 1 3) (3 2 5) (4 1 5) (4 3 7) (5 2 7) (6 1 7) (6 5 11))

;; ただ単にprime-sum-pairsの一部を関数化するというだけの良くわからない問題...
