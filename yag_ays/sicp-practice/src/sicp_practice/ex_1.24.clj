;; (defn square [x]
;;   (* x x))

;; (defn expmod [base exp m]
;;   (cond (= exp 0)   1
;;         (even? exp) (rem (square (expmod base (/ exp 2) m)) m)
;;         :else       (rem (* base (expmod base (- exp 1) m)) m)))

;; (defn fermat-test [n]
;;   ((fn [a] (= expmod a n n) a) (+ 1 (rand (- n 1)))))

;; (defn fast-prime? [n times]
;;   (cond (= times 0) :ture
;;         (fermat-test n) (fast-prime? n (- times 1))
;;         :else :false))

;; (fast-prime? 12 5)

;; (fermat-test 10)