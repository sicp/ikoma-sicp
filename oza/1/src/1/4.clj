; (defn a-plus-abs-b [a b] ((cond (> b 0) +) :else -) a b) NG
(defn a-plus-abs-b [a b] ((if (< b 0) - +) a b))
; user=> (a-plus-abs-b 1 1)
; 2
; user=> (a-plus-abs-b 1 -1)
; 2
