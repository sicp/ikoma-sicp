(load-file "2_7.clj")

(defn center [i]
  (/ (+ (lower-bound i) (upper-bound i)) 2.0))

(defn percent [i]
  (let [c (center i)]
    (* (/ (- (upper-bound i) c) c) 100)))

(defn make-center-percent [c p]
  (make-interval (* c (- 1 (/ p 100.0))) (* c (+ 1 (/ p 100.0)))))