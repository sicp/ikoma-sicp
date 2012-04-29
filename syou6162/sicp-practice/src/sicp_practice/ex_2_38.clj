(ns sicp-practice.ex-2-38)

(defn fold-left [op initial sequence]
  (letfn [(iter [result arg-rest]
		(if (empty? arg-rest)
		  result
		  (iter (op result (first arg-rest))
			(rest arg-rest))))]
    (iter initial sequence)))

(reduce / 1 '(1 2 3)) ; 1/6
(fold-left / 1 '(1 2 3)) ; 1/6

(reduce list nil '(1 2 3)) ; (((nil 1) 2) 3)
(fold-left list nil '(1 2 3)) ; (((nil 1) 2) 3)
