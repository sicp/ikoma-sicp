(defn memq [item x]
  (cond
   (empty? x) false
   (= item (first x)) x
   :else (memq item (rest x))))

(list 'a 'b 'c)
; (a b c)

(list (list 'george))
; ((george))

(rest '((x1 x2) (y1 y2)))
; ((y1 y2))

(second '((x1 x2) (y1 y2)))
; (y1 y2)

(seq? (first '(a short list)))
; false

(memq 'red '((red shoes) (blue socks)))
; false

(memq 'red '(red shoes blue socks))
; (red shoes blue socks)
