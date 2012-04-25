(defn generate-huffman-tree [pairs]
  (successive-merge (make-leaf-set pairs)))

(defn successive-merge [set]
  (if (empty? (rest set))
    (first set)
    (successive-merge (adjoin-set (make-code-tree (first set)
                                                  (first (next set)))
                                  (rest (next set))))))


(generate-huffman-tree '((A 4) (B 2) (C 1) (D 1)))
;; ((leaf A 4) ((leaf B 2) ((leaf D 1) (leaf C 1) (D C) 2) (B D C) 4) (A B D C) 8)



;; 解説
;; make-leaf-setによって重みが小さい順にleafが並べられるので，
;; 集合の最小重みの要素のペアを取るには，先頭から順に選んでいけばよい

(make-leaf-set '((A 4) (B 2) (C 1) (D 1)))
;; ((leaf D 1) (leaf C 1) (leaf B 2) (leaf A 4))

(make-code-tree '(leaf A 4) '(leaf B 2))
;; ((leaf A 4) (leaf B 2) (A B) 6)

(adjoin-set (make-code-tree '(leaf D 1) '(leaf C 1)) '((leaf B 2) (leaf A 4)))
;; ((leaf B 2) ((leaf D 1) (leaf C 1) (D C) 2) (leaf A 4))

(adjoin-set )


;; '((A 4) (B 2) (C 1) (D 1))
;;            |
;;       make-leaf-set
;;            |
;;            V
;; ((leaf D 1) (leaf C 1) (leaf B 2) (leaf A 4))
;;            |
;;     iteration {adjoin-set & make-code-tree}
;;            |
;;            V
;; ((leaf A 4) ((leaf B 2) ((leaf D 1) (leaf C 1) (D C) 2) (B D C) 4) (A B D C) 8)
