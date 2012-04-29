(defn accumulate [op initial s]
  (if (empty? s)
    initial
    (op (first s)
        (accumulate op initial (rest s)))))

(defn accumulate-n [op init seqs]
  (if (empty? (first seqs))
    nil
    (cons (accumulate op init (map first seqs))
          (accumulate-n op init (map rest seqs)))))




;; \sum_i v_i w_i
(defn dot-product [v w]
  (accumulate + 0 (map * v w)))
(dot-product '(1 2) '(3 4))
;; 11


;; t_i = \sum_j m_{ij} v_j
(defn matrix-*-vector [m v]
  (map #(dot-product % v) m))
(matrix-*-vector '((1 2) (3 4)) '(1 2))
;; (5 11)


;; n_{ij} = m_{ji}
(defn transpose [m]
  (accumulate-n cons nil m))
(transpose '((1 2 3) (4 5 6) (7 8 9)))
;; ((1 4 7) (2 5 8) (3 6 9))


;; p_{ij} = \sum_k m_{ik} n_{kj}
(defn matrix-*-matrix [m n]
  (let [cols (transpose n)]
    (map #(matrix-*-vector cols %) m)))
(matrix-*-matrix '((1 2) (3 4)) '((5 6) (7 8)))
;; ((19 22) (43 50))

;; > matrix(c(1,2,3,4),nrow=2,byrow=T) %*% matrix(c(5,6,7,8),nrow=2,byrow=T)
;; [,1] [,2]
;; [1,]   19   22
;; [2,]   43   50
