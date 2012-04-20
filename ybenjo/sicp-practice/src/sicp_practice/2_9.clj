(load-file "2_7.clj")

(defn interval-width [x]
  (Math/abs (/ (- (upper-bound x) (lower-bound x)) 2.0)))

