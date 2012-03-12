(defn make-rat [n d] (list n d))
(defn numer [x] (first x))
(defn denom [x] (last x))

(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (rem a b))))

(defn make-rat [n d]
  (let [g (Math/abs (gcd n d))]
    (if (neg? d)
      (list (- (/ n g)) (- (/ d g)))
      (list (/ n g) (/ d g)))))

(make-rat 1 3)   ; (1 3)
(make-rat 1 -3)  ; (-1 3)
(make-rat -1 3)  ; (-1 3)
(make-rat -1 -3) ; (1 3)


;; 補足
;; denomの実装の際には，restではなくlastを使う
(rest '(1 2)) ;; (2)
(last '(1 2)) ;; 2

(class (rest '(1 2))) ;; clojure.lang.PersistentList
(class (last '(1 2))) ;; java.lang.Integer
