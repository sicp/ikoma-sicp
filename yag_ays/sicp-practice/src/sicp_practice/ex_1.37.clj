;; Exercise a.
(defn cont-frac [n d k]
  (defn frac [i]
    (if (> i k)
      0
      (/ (n i) (+ (d i) (frac (inc i))))))
  (frac 1))


(cont-frac (fn [_] 1.0) (fn [_] 1.0) 1)
(cont-frac (fn [_] 1.0) (fn [_] 1.0) 10) ;; 0.6179775280898876
(cont-frac (fn [_] 1.0) (fn [_] 1.0) 11) ;; 0.6180555555555556


;; Exercise b.

(defn cont-frac-iter [n d k]
  (defn frac-iter [i result]
    (if (= i 0)
      result
      (frac-iter (dec i) (/ (n i) (+ (d i) result)))))
  (frac-iter k 0))


(cont-frac-iter (fn [_] 1.0) (fn [_] 1.0) 1)
(cont-frac-iter (fn [_] 1.0) (fn [_] 1.0) 10) ;; 0.6179775280898876
(cont-frac-iter (fn [_] 1.0) (fn [_] 1.0) 11) ;; 0.6180555555555556

;; 反復プロセスのコード書くの30分くらいかかったんだけど，ねぇどんな気持ち？ねぇどんな気持ち？