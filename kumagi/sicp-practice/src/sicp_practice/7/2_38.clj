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

(fold-right / 1 (list 1 2 3)); 3/2
(fold-left / 1 (list 1 2 3)); 1/6
(fold-right list nil (list 1 2 3)) ; (1 (2 (3 nil)))
(fold-left list nil (list 1 2 3)) ; (((nil 1) 2) 3)

; opは交換法則を満たせばいいんじゃないでしょうかねぃ＞fold-leftとfold-rightが同じ結果
(let [x (list 1 2 4 1 23 22 43)]
  (= (fold-left + 0 x)
     (fold-right + 0 x))) ; => true
(let [x (list 1 2 4 1 23 22 43)]
  (= (fold-left * 1 x)
     (fold-right * 1 x))) ; => true
(let [x (list 1 2 4 1 23 22 43)]
  (= (fold-left / 1 x)
     (fold-right / 1 x))) ; => false
(let [x (list 1 2 4 1 23 22 43)]
  (= (fold-left - 0 x)
     (fold-right - 0 x))) ; => false
