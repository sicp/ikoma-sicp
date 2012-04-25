(defn make-leaf [symbol weight] (list 'leaf symbol weight))
(defn leaf? [object] (= (first object) 'leaf))
(defn symbol-leaf [x] (first (next x)))
(defn weight-leaf [x] (first (next (next x))))

(defn left-branch [tree] (first tree))
(defn right-branch [tree] (first (next tree)))
(defn symbols [tree] (if (leaf? tree)
                       (list (symbol-leaf tree))
                       (first (next (next tree)))))
(defn weight [tree] (if (leaf? tree)
                      (weight-leaf tree)
                      (first (next (next (next tree))))))

(defn make-code-tree [left right]
  (list left
        right
        (concat (symbols left) (symbols right))
        (+ (weight left) (weight right))))
(defn choose-branch [bit branch]
  (cond (= bit 0) (left-branch branch)
        (= bit 1) (right-branch branch)
        :else (println "bad bit -- CHOOSE=BRANCH")))


(defn decode [bits tree]
  (defn decode-1 [bits current-branch]
    (if (empty? bits)
      '()
      (let [next-branch (choose-branch (first bits) current-branch)]
        (if (leaf? next-branch)
          (cons (symbol-leaf next-branch)
                (decode-1 (rest bits) tree))
          (decode-1 (rest bits) next-branch)))))
  (decode-1 bits tree))

(defn adjoin-set [x set]
  (cond (empty? set) (list x)
        (< (weight x) (weight (first set))) (cons x set)
        :else (cons (first set) (adjoin-set x (rest set)))))

(defn make-leaf-set [pairs]
  (if (empty? pairs)
    '()
    (let [pair (first pairs)]
      (adjoin-set (make-leaf (first pair)
                             (first (next pair)))
                  (make-leaf-set (rest pairs))))))

(make-leaf-set '((A 4) (B 2) (C 1) (D 1)))
;; ((leaf D 1) (leaf C 1) (leaf B 2) (leaf A 4))



;; ex_2.67
(def sample-tree (make-code-tree (make-leaf 'A 4)
                                 (make-code-tree (make-leaf 'B 2)
                                                 (make-code-tree (make-leaf 'D 1)
                                                                 (make-leaf 'C 1)))))
sample-tree
;; ((leaf A 4) ((leaf B 2) ((leaf D 1) (leaf C 1) (D C) 2) (B D C) 4) (A B D C) 8)

(def sample-message '(0 1 1 0 0 1 0 1 0 1 1 1 0))

(decode sample-message sample-tree)
;; (A D A B B C A)


;; 対応表
;; A : 0
;; B : 10
;; C : 111
;; D : 110
