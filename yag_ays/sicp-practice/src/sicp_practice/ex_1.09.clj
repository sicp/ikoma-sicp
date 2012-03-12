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
