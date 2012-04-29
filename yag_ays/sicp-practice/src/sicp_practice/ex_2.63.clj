(defn entry [tree] (first tree))                       ;; first
(defn left-branch [tree] (first (next tree)))          ;; second
(defn right-branch [tree] (first (next (next tree))))  ;; third

(defn make-tree [entry left right] (list entry left right))


(defn element-of-set? [x set]
  (cond (empty? set) false
        (= x (entry set)) true
        (< x (entry set)) (element-of-set? x (left-branch set))
        (> x (entry set)) (element-of-set? x (right-branch set))))

(defn adjoin-set [x set]
  (cond (empty? set) (make-tree x '() '())
        (= x (entry set)) set
        (< x (entry set)) (make-tree (entry set)
                                     (adjoin-set x (left-branch set))
                                     (right-branch set))
        (> x (entry set)) (make-tree (entry set)
                                     (left-branch set)
                                     (adjoin-set x (right-branch set)))))


;;==============================
;; 二進木のデータ
;; P.91 fig. 2.16 および P.92 fig. 2.17
;;

(def tree1
  (make-tree 7 (make-tree 3 (make-tree 1 '() '())
                            (make-tree 5 '() '()))
               (make-tree 9 '()
                            (make-tree 11 '() '()))))
;; tree1
;; (7 (3 (1 () ()) (5 () ())) (9 () (11 () ())))

(def tree2
  (make-tree 3 (make-tree 1 '() '())
               (make-tree 7 (make-tree 5 '() '())
                            (make-tree 9 '()
                                         (make-tree 11 '() '())))))
;; tree2
;; (3 (1 () ()) (7 (5 () ()) (9 () (11 () ()))))

(def tree3
  (make-tree 5 (make-tree 3 (make-tree 1 '() '())
                            '())
               (make-tree 9 (make-tree 7 '() '())
                            (make-tree 11 '() '()))))
;; tree3
;; (5 (3 (1 () ()) ()) (9 (7 () ()) (11 () ())))


(def tree4
  (make-tree 1 '()
               (make-tree 2 '()
                            (make-tree 3 '()
                                         (make-tree 4 '()
                                                      (make-tree 5 '()
                                                                   (make-tree 6 '()
                                                                                (make-tree 7 '() '()
                                                                                           ))))))))
;; tree4
;; (1 () (2 () (3 () (4 () (5 () (6 () (7 () ())))))))



;;==============================
;; ex_2.63

(defn tree->list-1 [tree]
  (if (empty? tree)
    '()
    (concat (tree->list-1 (left-branch tree))
            (cons (entry tree)
                  (tree->list-1 (right-branch tree))))))

(defn tree->list-2 [tree]
  (defn copy-to-list [tree result-list]
    (if (empty? tree)
      result-list
      (copy-to-list (left-branch tree)
                    (cons (entry tree)
                          (copy-to-list (right-branch tree)
                                        result-list)))))
  (copy-to-list tree '() ))


(tree->list-1 tree1) ;; (1 3 5 7 9 11)
(tree->list-1 tree2) ;; (1 3 5 7 9 11)
(tree->list-1 tree3) ;; (1 3 5 7 9 11)
(tree->list-1 tree4) ;; (1 2 3 4 5 6 7)

(tree->list-2 tree1) ;; (1 3 5 7 9 11)
(tree->list-2 tree2) ;; (1 3 5 7 9 11)
(tree->list-2 tree3) ;; (1 3 5 7 9 11)
(tree->list-2 tree4) ;; (1 2 3 4 5 6 7)

;; どちらの手続きも同じ結果を生じる
