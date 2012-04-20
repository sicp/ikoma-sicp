(ns sicp-practice.ex_1_44)

;; ex_1_42
(defn square [x] (* x x))

(defn compose [f g]
  (fn [x] (f (g x))))

;; test
((compose square inc) 4)
;; square(inc (4)) = 25


;; ex_1_43
;; repeat is reserved in Clojure
(defn repeat_f [f n]
  (if (= n 1)
    (fn [x] (f x))
    (compose f (repeat_f f (- n 1)))))

;; test
((repeat_f square 2) 5)
;; 625


;; ex_1_44
(def dx 0.00001)

(defn smooth [f]
  (fn [x] (/ (+ (f (+ x dx))
                (f x)
                (f (- x dx)))
             3)))

(defn n_fold_smooth [f n]
    ((repeat_f smooth n) f))

