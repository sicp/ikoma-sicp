(defn fold-right [op initial seq]
  (if (empty? seq)
    initial
    (op (first seq)
        (fold-right op initial (rest seq)))))

(defn fold-left [op initial sequence]
  (defn iter [result restt]
    (if (empty? restt)
      result
      (iter (op result (first restt))
            (rest restt))))
  (iter initial sequence))

; ここから解答

(fold-right list nil (list 1 2 3)) ; => (1 (2 (3 nil)))

(defn my-reverse [sequence]
  (fold-right (fn [x y] (concat y (list x))) nil sequence))
(let [x (list 1 2 3 4 5 6 7 8)]
  (= (my-reverse x)
     (reverse x))) ; => true

(fold-left list nil (list 1 2 3)) ; (((nil 1) 2) 3)
(defn my-reverse2 [sequence]
  (fold-left (fn [x y] (cons y x)) nil sequence))
(let [x (list 1 2 3 4 5 6 7 8)]
  (= (my-reverse2 (list 1 2 3 4 5 6 7 8))
     (reverse x))) ; => true
