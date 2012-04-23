(defn memq [item x]
  (cond (empty? x) false
        (= item (first x)) x
        :else (memq item (rest x))))


;; ex_2.53

(list 'a 'b 'c)
;; (a b c)

(list (list 'george))
;; ((george))

(rest '((x1 x2) (y1 y2)))
;; ((y1 y2))

(second '((x1 x2) (y1 y2)))
;; (y1 y2)

;; "cadr"は，Clojureではsecondまたはfnextを使う
;; (fnext '((x1 x2) (y1 y2)))
;; (y1 y2)

(seq? (first '(a short list)))
;; false

(menq 'red '((red shoe) (blue socks)))
;; false

(memq 'red '(red shoe blue socks))
;; (red shoe blue socks)
