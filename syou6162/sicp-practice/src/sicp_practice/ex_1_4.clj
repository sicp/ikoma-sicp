(ns sicp-practice.ex-1-4)

;; 問題1.4
(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

(a-plus-abs-b 1 3) ; 4
(a-plus-abs-b 1 (- 3)) ; 4
(a-plus-abs-b 1 (- 10)) ; 11