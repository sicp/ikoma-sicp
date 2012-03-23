;; normal-order evaluation: fully expand and then reduce
;; applicative-order evaluation: evaluate the arguments and then apply
;;
(def p p)

(defn tst [x y]
  (if (= x 0) 0 y))

(tst 0 p) ;; 0

(p 4) ;; [4]
(p [4]) ;; [[4]]
;; clojure uses applicative-order
