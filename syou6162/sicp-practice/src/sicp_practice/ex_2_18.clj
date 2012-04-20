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

;;;; ここから自主課題 ;;;;;
;; (ありがちだけど)ネストしててもreverseしてくれるような関数を書く

(defn my-reverse-recursive [tree]
  (letfn [(my-reverse-recursive'
	   [tree acc]
	   (if (empty? tree)
	     acc
	     (my-reverse-recursive'
	      (rest tree)
	      (cons (let [fst (first tree)] ;; ここだけ変更
		      (if (list? fst)
			(my-reverse-recursive' fst '())
			fst))
		    acc))))]
    (my-reverse-recursive' tree '())))

(my-reverse '(1 2 (3 4 (5 6) 7 8))) ; ((3 4 (5 6) 7 8) 2 1)
(my-reverse-recursive '(1 2
			  (3 4
			     (5 6 7)
			     8)
			  9 10)) ; (10 9 (8 (7 6 5) 4 3) 2 1)
;; もちろんflatなリストに対しても動く
(my-reverse-recursive (range 5)) ; (4 3 2 1 0)