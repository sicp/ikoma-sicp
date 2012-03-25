(defn accumulate [op initial s]
  (if (empty? s)
    initial
    (op (first s)
        (accumulate op initial (rest s)))))

;; map (cf. ex_2.21.clj)
(defn my-map [p s]
  (accumulate (fn [x y] (cons (p x) y)) nil s))

(my-map (fn [x] (* x x)) '(1 2 3))
;; (map (fn [x] (* x x)) '(1 2 3))


;; append (cf. ex_2.17.clj)
(defn my-append [seq1 seq2]
  (accumulate cons seq2 seq1))

(my-append '(1 2 3) '(4 5 6))
;; (concat '(1 2 3) '(4 5 6))


;; length (cf. ex_2.17.clj)
(defn length [s]
  (accumulate (fn [x y] (+ 1 y)) 0 s))

(length '(1 2 3))
;; (count '(1 2 3))
