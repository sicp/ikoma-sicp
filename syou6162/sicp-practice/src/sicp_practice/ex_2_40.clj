(ns sicp-practice.ex-2-40)

;; 写像の入れ子

;; (defn enumerate-interval [low high]
;;   (if (> low high)
;;     nil
;;     (cons low (enumerate-interval (inc low) high))))

(defn enumerate-interval [low high]
  (range low (inc high)))

(enumerate-interval 1 10) ; (1 2 3 4 5 6 7 8 9 10)

(defn flatmap [proc seq]
  (reduce concat (map proc seq)))

(defn prime? [n]
  (cond
   (> 2 n) false
   (== 2 n) true
   (even? n) false
   (not-any? zero? (map #(rem n %) (range 3 (inc (Math/sqrt n))))) true
   :else false))

(defn prime-sum? [pair]
  (prime? (+ (first pair) (second pair))))

(defn make-sum-pair [pair]
  (list (first pair) (second pair) (+ (first pair) (second pair))))

(defn unique-pairs [n]
  (flatmap (fn [i]
	     (map (fn [j]
		    (list i j))
		  (enumerate-interval 1 (dec i))))
	   (enumerate-interval 1 n)))

(unique-pairs 5) ; ((2 1) (3 1) (3 2) (4 1) (4 2) (4 3) (5 1) (5 2) (5 3) (5 4))

;; clojureのforだとこんな感じでも書ける
;; (defn my-unique-pairs [n]
;;   (for [i (range 1 (inc n))
;; 	j (range 1 (inc i))
;; 	:when (> i j)]
;;     (list i j)))
;; (my-unique-pairs 5) ; ((2 1) (3 1) (3 2) (4 1) (4 2) (4 3) (5 1) (5 2) (5 3) (5 4))

(defn prime-sum-pair [n]
  (map make-sum-pair
       (filter prime-sum? (unique-pairs n))))

(prime-sum-pair 6) ; ((2 1 3) (3 2 5) (4 1 5) (4 3 7) (5 2 7) (6 1 7) (6 5 11))
