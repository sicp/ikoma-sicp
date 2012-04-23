;; 2.2.2のcount-leaves実装
(defn count-leaves [t]
  (cond (not (seq? t)) 1
        (empty? t) 0
        :else (+ (count-leaves (first t))
                 (count-leaves (rest t)))))
;; Clojureでは(empty? <int>)はエラーになるので注意．
;; ここではテキストの実装とは違ってnot seq?を1つ目に出して誤魔化しているが，
;; 実際はempty?の箇所を訂正して空リストに対応したほうが良いかもしれない


;; ex_2.35
(defn accumulate [op initial s]
  (if (empty? s)
    initial
    (op (first s)
        (accumulate op initial (rest s)))))


(defn count-leaves [t]
  (accumulate +
              0
              (map (fn [x] (if (list? x) (count-leaves x) 1)) t)))


(count-leaves '(1 2 3 4))
(count-leaves '((1 2) 3 4))
