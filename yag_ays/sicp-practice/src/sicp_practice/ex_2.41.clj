;; ex_2.40
(defn accumulate [op initial s]
  (if (empty? s)
    initial
    (op (first s)
        (accumulate op initial (rest s)))))
(defn enumerate-interval [low high]
  (if (> low high)
    nil
    (cons low (enumerate-interval (+ low 1) high))))
(defn flatmap [proc sq]
  (accumulate concat nil (map proc sq)))


;; ex_2.41
(defn union-setofthree [n] (flatmap (fn [i] (flatmap (fn [j] (map (fn [k] (list i j k))
                                                                  (enumerate-interval 1 (- j 1))))
                                                     (enumerate-interval 1 (- i 1))))
                                    (enumerate-interval 1 n)))

(union-setofthree 4)
;; ((3 2 1) (4 2 1) (4 3 1) (4 3 2))



(defn validataion [s n]
  (defn sum? [lst]
    (= (apply + lst)
       s))
  (filter sum? (union-setofthree n)))

(validataion 8 4)
;; ((4 3 1))
(validataion 9 4)
;; ((4 3 2))

;; 述語に値を渡す方法が思いつかなかったので，関数内でsum?を定義している
