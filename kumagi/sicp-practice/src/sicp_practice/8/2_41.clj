(defn find-three [n s]
  (defn accumulate [op initial seq]
    (if (empty? seq)
      initial
      (op (first seq)
          (accumulate op initial (rest seq)))))
  (defn enumerate-interval [low high]
    (if (> low high)
      nil
      (cons low (enumerate-interval (+ low 1) high))))
  (defn unique-trio [n]
    (accumulate concat []
                (map (fn [i]
                       (map (fn [j]
                              (map (fn [k]
                                     (list i j k))
                                   (enumerate-interval 1 (- 2 1))))
                            (enumerate-interval 2 (- i 1))))
                     (enumerate-interval 3 n))))
  (unique-trio 10)
  (let [n 10
        s 3]
    (filter (fn [trio]
              (do (println trio)
                  (cond (nil? trio) false
                        (= s
                           (+
                            (first trio) (first (rest trio)) (first (rest (rest trio))))) true
                        :else false)))
            (unique-trio n))))
(find-three 10 8)

(let [trio [1 2 3]]
     (+ (first trio) (first (rest trio)) (first (rest (rest trio)))))

(println  (unique-pairs 10))
; => ((2 1) (3 1) (3 2) (4 1) (4 2) (4 3) (5 1) (5 2) (5 3) (5 4) (6 1) (6 2) (6 3) (6 4) (6 5) (7 1) (7 2) (7 3) (7 4) (7 5) (7 6) (8 1) (8 2) (8 3) (8 4) (8 5) (8 6) (8 7) (9 1) (9 2) (9 3) (9 4) (9 5) (9 6) (9 7) (9 8) (10 1) (10 2) (10 3) (10 4) (10 5) (10 6) (10 7) (10 8) (10 9))


; 過去の素数判定アルゴリズムを引っ張り出してきた
(defn prime-test [n times]
  (defn square [x] (* x x))
  (defn expmod [base exp m]
    (cond (= exp 0) 1
          (even? exp) (rem (square (expmod base (/ exp 2) m)) m)
          :else (rem (* base (expmod base (- exp 1) m)) m)))
  (defn fermat-test [n]
    (defn try-it [a]
      (= (expmod a n n) a))
    (try-it (+ 1 (rand-int (- n 1)))))
  (cond (= times 0) true
        (fermat-test n) (prime-test n (- times 1))
        :else false))
(defn prime? [x]
  (prime-test x 100))
; 引っ張り出したのここまで


; 答え
(defn prime-sum-pairs [x]
  (filter
   (fn [pair]
     (prime? (+ (first pair) (first (rest pair)))))
   (unique-pairs x)))

(println (prime-sum-pairs 10))
; => ((2 1) (3 2) (4 1) (4 3) (5 2) (6 1) (6 5) (7 4) (7 6) (8 3) (8 5) (9 2) (9 4) (9 8) (10 1) (10 3) (10 7) (10 9))




