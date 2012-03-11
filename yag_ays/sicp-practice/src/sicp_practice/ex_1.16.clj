(defn fast-expt-seq [b n]
  (fast-expt-seq-iter b n 1))

(defn fast-expt-seq-iter [b counter product]
  (cond (= counter 0) product
        (even? counter) (fast-expt-seq-iter (* b b)
                                            (/ counter 2)
                                            product)
        :else (fast-expt-seq-iter b
                          (- counter 1)
                          (* product b))))

(fast-expt-seq 2 1)
(fast-expt-seq 2 2)
(fast-expt-seq 2 3)
(fast-expt-seq 2 4)
(fast-expt-seq 2 5)

;; 解説
;; e.g. 2^{10} = 4^5 = 4 ¥times 4^4 = 4 ¥times 16^2 = 4 ¥times 256^1
;; ../../img/supplementary_1.16.png
