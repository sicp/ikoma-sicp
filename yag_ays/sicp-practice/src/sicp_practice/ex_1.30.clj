(defn sum [term a nxt b]
  (defn iter [c result]
    (if (> c b)
      result
      (iter (nxt c) (+ (term c) result))))
  (iter a 0))

(sum identity 1 inc 10)

;; sum
;; (defn sum [term a nxt b]
;;   (if (> a b)
;;     0
;;     (+ (term a) (sum term (nxt a) nxt b))))
