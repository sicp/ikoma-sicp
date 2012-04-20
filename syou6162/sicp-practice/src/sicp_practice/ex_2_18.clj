(ns sicp-practice.ex-2-18)

(reverse '(1 2 3 4 5)) ; (5 4 3 2 1)
;; ちなみに再帰的にはやってくれない
(reverse '(1 2 (3 4 5))) ; ((3 4 5) 2 1)

;; 何も考えずに書いた版。reduce的な考え方で書いた
;; 空リストの頭にどんどんconsしていく
(defn my-reverse [xs]
  (letfn [(my-reverse'
	   [xs acc]
	   (if (empty? xs)
	     acc
	     (my-reverse' (rest xs) (cons (first xs) acc))))]
    (my-reverse' xs '())))

(my-reverse (range 5)) ; (4 3 2 1 0)
(reduce conj '() (range 5)) ; (4 3 2 1 0)
; (conj (conj '() 1) 2) => (2 1)