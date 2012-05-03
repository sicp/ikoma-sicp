(ns sicp-practice.ex-2-53)

(defn memq [item x]
  (cond (empty? x) false
        (= item (first x)) x
        :else (memq item (rest x))))

(list 'a 'b 'c) ; (a b c)
(list (list 'george)) ; ((george))
(rest '((x1 x2) (y1 y2))) ; ((y1 y2))
;; cadrは(defn cadr [x] (first (rest x)))でsecondのこと
(second '((x1 x2) (y1 y2))) ; (y1 y2)

(list? (first '(a short list))) ; false

(memq 'red '((red shoe) (blue socks))) ; false
(memq 'red '(red shoe blue socks)) ; (red shoe blue socks)