; http://mitpress.mit.edu/sicp/full-text/book/book-Z-H-10.html#%_sec_1.1.5

(defn average[x y]
  (/ (+ x y) 2)
  )

(defn square[x]
  (* x x)
  )

(defn improve[guess x]
  (average guess (/ x guess))
  )

(defn good-enough?[guess x]
  (<
   (Math/abs
    (- (square guess) x)
    )
   0.001
   )
  )

(defn sqrt-iter[guess x]
  (if (good-enough? guess x)
      guess
      (sqrt-iter
       (improve guess x)
       x)
      )
  )

(defn sqrt[x]
  (sqrt-iter 1.0 x)
  )

; ex 1-6
; 作用順序で評価しようとして else-clause を先に評価しようとして無限ループ
; なので　1-5 の p を使って　(new-if (= 0 0) 0 (p)) とかやっても死ぬ
(defn new-if[predicate then-clause else-clause]
  (cond
   predicate then-clause
   :else else-clause
   )
  )

(defn sqrt-iter[guess x]
  (new-if (good-enough? guess x)
      guess
      (sqrt-iter
       (improve guess x)
       x)
      )
  )
