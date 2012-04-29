
(defn fold-left [op initial sequence]
  (defn iter [result rst]
    (if (empty? rst) result
        (iter (op result (first rst))
              (rest rst))))
  (iter initial sequence))

(defn accumulate [op initial sequence]
  (if (empty? sequence) initial
      (op (first sequence) (accumulate op initial (rest sequence)))))

(defn fold-right [op initial sequence]
  (accumulate op initial sequence))

; user=> (fold-right / 1 (list 1 2 3))
; 3/2
; user=> (fold-left / 1 (list 1 2 3))
; 1/6

; user=> (fold-right + 1 (list 1 2 3))
; 7
; user=> (fold-left + 1 (list 1 2 3))
; 7

; user=> (fold-right list nil (list 1 2 3))
; (1 (2 (3 nil)))
; user=> (fold-left list nil (list 1 2 3))
; (((nil 1) 2) 3)

