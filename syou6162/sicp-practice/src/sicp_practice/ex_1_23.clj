(ns sicp-practice.ex-1-23
  :use sicp-practice.ex-1-21)

(defn nxt [n] (if (= n 2) 3 (+ n 2)))

(with-redefs
  [find-divisor (fn [n test-divisor]
		  (cond (> (* test-divisor test-divisor) n) n
			(divides? test-divisor n) test-divisor
			:else (find-divisor n (nxt test-divisor))))]
  (time (take 3 (filter prime? (iterate (partial + 2) 1001))))
  (time (take 3 (filter prime? (iterate (partial + 2) 10001))))
  (time (take 3 (filter prime? (iterate (partial + 2) 100001)))))

; "Elapsed time: 0.036 msecs"
; "Elapsed time: 0.0040 msecs"
; "Elapsed time: 0.0050 msecs"
; (100003 100019 100043)