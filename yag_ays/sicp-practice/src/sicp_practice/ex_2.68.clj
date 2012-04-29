(defn encode [message tree]
  (if (empty? message)
    '()
    (concat (encode-symbol (first message) tree)
            (encode (rest message) tree))))

(defn exist? [s set]
  (if (empty? set)
    false
    (if (= s (first set))
      true
      (exist? s (rest set)))))

(exist? 'A '(A B C)) ;; true
(exist? 'D '(A B C)) ;; false


(defn encode-symbol [s tree]
  (cond (leaf? tree) '()
        (exist? s (symbols (left-branch tree))) (cons 0 (encode-symbol s (left-branch tree)))
        (exist? s (symbols (right-branch tree))) (cons 1 (encode-symbol s (right-branch tree)))
        :else (println "ERROR : unknown symbol")))

(encode-symbol 'A sample-tree) ;; (0
(encode-symbol 'D sample-tree) ;; (1 1 0)
(encode-symbol 'E sample-tree) ;; ERROR : unknown symbol


(encode '(A D A B B C A) sample-tree)
;; (0 1 1 0 0 1 0 1 0 1 1 1 0)

(decode (encode '(A D A B B C A) sample-tree) sample-tree)
;; (A D A B B C A)




;; memo
(symbols sample-tree) ;; (A B D C)
(left-branch sample-tree) ;; (leaf A 4)
(right-branch sample-tree) ;; ((leaf B 2) ((leaf D 1) (leaf C 1) (D C) 2) (B D C) 4)
(symbols (right-branch sample-tree)) ;; (B D C)

(weight sample-tree) ;; 8
(weight (right-branch sample-tree)) ;; 4
