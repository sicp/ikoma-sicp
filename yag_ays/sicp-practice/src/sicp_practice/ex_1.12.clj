(defn pascal-triangle [r c]
  (if (or (= c 1) (= r c))
    1
    (+ (pascal-triangle (- r 1) (- c 1))
       (pascal-triangle (- r 1) c))))

(pascal-triangle 3 2) ;; 2
(pascal-triangle 4 1) ;; 1
(pascal-triangle 4 3) ;; 3
