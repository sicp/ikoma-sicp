(def squares (list 1 4 9 16 25))
(def odds (list 1 3 5 7))

;; nthの再実装
;; (nth squares 3)
(defn list-ref [items n]
  (if (= n 0)
    (first  items)
    (list-ref (rest items) (- n 1))))

(list-ref squares 3)


;; countの再実装
;; (count odds)
(defn length [items]
  (if (empty? items)
    0
    (+ 1 (length (rest items)))))

(defn length [items]
  (defn length-iter [a c]
    (if (empty? a)
      c
      (length-iter (rest a) (+ 1 c))))
  (length-iter items 0))

(length odds)


;; concatの再実装
;; (concat squares odds)
(defn append [list1 list2]
  (if (empty? list1)
    list2
    (cons (first list1) (append (rest list1) list2))))

(append squares odds)
(append odds squares)


;; lastの再実装
;; (last '(23 72 149 34))
(defn last-pair [items]
  (if (empty? (rest items))
    (first items)
    (last-pair (rest items))))

(last-pair '(23 72 149 34))
