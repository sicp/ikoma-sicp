(defn equal? [x y]
  (cond (and (seq? x) (seq? x)) (cond (and (empty? x) (empty? y)) true
                                      (not= (first x) (first y)) false
                                      :else (equal? (rest x) (rest y)))
        (or (seq? x) (seq? y)) false
        :else (= x y)))


(equal? 'a 'a)  ;; true
(equal? 'a 'b)  ;; false

(equal? 'a '(a))    ;;false
(equal? '(a) '(a))  ;;true

(equal? '(this is a list) '(this is a list))    ;; true
(equal? '(this is a list) '(this (is a) list))  ;; false
