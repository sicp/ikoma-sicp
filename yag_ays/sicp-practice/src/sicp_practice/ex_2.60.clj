;; 何も変更しなくても，重複有り集合セットでも対応できそう

(intersection-set '(1 1 2 2 3) '(1 3 3 5))
(union-set '(1 1 2 2 3) '(1 3 3 5))

;; ただ，adjoin-setとunion-setはもっと簡単にできる

(defn adjoin-set [x set]
  (cons x set))

(defn union-set [set1 set2]
  (concat set1 set2))

(adjoin-set 1 '(1 2 3)) ;; (1 1 2 3)
(union-set '(1 2 3) '(1 2 3)) ;; (1 2 3 1 2 3)

;; 重複有り集合を認めてしまうと，element-of-set?の探索空間が広がるので
;; intersection-setの効率は悪くなる(遅くなる)．逆に，adjoin-setとunion-setは高速になる．
;; いずれにせよ，集合の加算や積算を繰り返す場合にはメモリが十分にあることが前提条件となる．
