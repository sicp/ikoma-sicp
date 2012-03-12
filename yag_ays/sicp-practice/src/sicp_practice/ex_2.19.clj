(def us-coins (list 50 25 10 5 1))
(def uk-coins (list 100 50 20 10 5 2 1 0.5))

(defn cc [amount coin-values]
  (cond (= amount 0) 1
        (or (< amount 0) (no-more? coin-values)) 0
        :else (+ (cc amount
                     (except-first-denomination coin-values))
                 (cc (- amount
                        (first-denomination coin-values))
                     coin-values))))


(defn no-more? [c] (empty? c))
(defn first-denomination [c] (first c))
(defn except-first-denomination [c] (rest c))

(cc 100 us-coins) ;; 292


(def us-coins-rev (list 1 5 10 25 50))
(cc 100 us-coins-rev)
