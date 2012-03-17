;; yag-san
;; (defn tan-cf [x k]
;;   (defn frac-iter [i result]
;;     (if (= i 0)
;;       result
;;       (frac-iter (dec i) (/ (if (= i 1) x (* x x)) (- (- (* i 2) 1) result)))))
;;   (frac-iter k 0))

(tan-cf 0.0 1000)
(tan-cf (/ 3.14 4) 1000)
