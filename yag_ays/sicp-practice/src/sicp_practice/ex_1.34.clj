(defn f [g]
  (g 2))

(defn square [x]
  (* x x))

(f square)
;; 4

(f (fn [z] (* z (+ z 1))))
;; 6

(f f)
;; java.lang.Integer cannot be cast to clojure.lang.IFn
;;   [Thrown class java.lang.ClassCastException]

;; (f f)
;; (f 2)
;; (2 2)
