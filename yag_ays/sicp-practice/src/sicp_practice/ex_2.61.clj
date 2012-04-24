;; 順序付けられた重複なしリスト
(defn element-of-set? [x set]
  (cond (empty? set) false
        (= x (first set)) true
        (< x (first set)) false
        :else (element-of-set? x (rest set))))

(defn intersection-set [set1 set2]
  (if (or (empty? set1) (empty? set2))
    '()
    (let [x1 (first set1)
          x2 (first set2)]
      (cond (= x1 x2) (cons x1 (intersection-set (rest set1) (rest set2)))
            (< x1 x2) (intersection-set (rest set1) set2)
            (< x2 x1) (intersection-set set1 (rest set2))))))


(element-of-set? 1 '(1 2 3)) ;; true
(element-of-set? 4 '(1 2 3)) ;; false

(intersection-set '(1 2 3) '(1 3 5)) ;; (1 3)
(intersection-set '(1 2 3) '(4 5 6)) ;; ()


;; ex_2.61
(defn adjoin-set [x set]
  (if (empty? set)
    (list x)
    (cond (= x (first set)) set
          (< x (first set)) (cons x set)
          (> x (first set)) (cons (first set) (adjoin-set x (rest set))))))

(adjoin-set 1 '())
(adjoin-set 1 '(1 2 3)) ;; (1 2 3)
(adjoin-set 4 '(1 2 3)) ;; (4 1 2 3)

;; 順序付けられたリストでは，intersection-setの実装と同様に，adjoin-setの実装においても
;; 必要ステップ数の平均は約 n/2 に抑えられる．
