(load-file "2_7.clj")

(defn sub-interval [x y]
  (make-interval (- (lower-bound x) (upper-bound y))
                 (- (upper-bound x) (lower-bound y))))

; case1: (1 <-> 2) - (3 <-> 4)
; #=> (-3, -1)
; case2: (1 <-> 3) - (2 <-> 4)
; #=> (-3 1)
