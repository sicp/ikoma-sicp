(defn accumulate [op initial seq]
  (if (empty? seq)
    initial
    (op (first seq)
        (accumulate op initial (rest seq)))))

(defn my-map [p seq]
  (accumulate (fn [x y] (cons (p x) y)) nil seq))
(= (my-map (fn [x] (* x x)) '(3 9))
   (map (fn [x] (* x x)) '(3 9))); => true

(defn my-append [seq1 seq2]
  (accumulate cons seq2 seq1))
(= (my-append '(3 42 1) '(8 7))
   (concat '(3 42 1) '(8 7))); => true

(defn my-length [sequence]
  (accumulate (fn [a b] (+ b 1)) 0 sequence))
(= (my-length '(32 3 12 4 65 2 4))
   (count '(32 3 12 4 65 2 4))); => true

;(32 3 12 4 65 2 4 )   => 0 + 1 + 1 + 1 + 1 + 1 + 1 + 1  => 7
;(f  rest          )   => 0 + 1 + 1 + 1 + 1 + 1 + 1 + 1
;   (f rest        )   => 0 + 1 + 1 + 1 + 1 + 1 + 1
;     (f  rest     )   => 0 + 1 + 1 + 1 + 1 + 1
;        (f rest   )   => 0 + 1 + 1 + 1 + 1
;          (f  rest)   => 0 + 1 + 1 + 1
;             (f rest) => 0 + 1 + 1
;                (f 0) => 0 + 1

