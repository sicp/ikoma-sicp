; (subsets (1 2 3))
; (() (1) (2) (3) (1 2) (2 3) (1 3) (1 2 3))

(defn append [x y]
  (if (empty? x) y
      (cons (first x) (append (rest x) y))))

(defn subsets [s]
  (if (empty? s) (list nil)
      (let [rest_ (subsets (rest s))]
        ; (append rest_ (map #(cons (first s) %) rest_))))) とか書いてずっとはまってた
        ; for debug
        (println "rest_ : " rest_)
        (println "map : " (map #(cons (first s) %) rest_))
        (println "concat : " (concat rest_ (map #(cons (first s) %) rest_)))
        (println "---------------------------------")
        (concat rest_ (map #(cons (first s) %) rest_)))))


; 
; 
; 
; 
; 