(defn make-tree [entry left right] (list entry left right))
(defn list->tree [element] (first (partial-tree element (count element))))

(defn partial-tree [elts n]
  (if (= n 0)
    (cons '() elts)
    (let [left-size (quot (- n 1) 2)]
      (let [left-result (partial-tree elts left-size)]
        (let [left-tree (first left-result)
              non-left-elts (rest left-result)
              right-size (- n (+ left-size 1))]
          (let [this-entry (first non-left-elts)
                right-result (partial-tree (rest non-left-elts)
                                           right-size)]
            (let [right-tree (first right-result)
                  remaining-elts (rest right-result)]
              (cons (make-tree this-entry left-tree right-tree)
                    remaining-elts))))))))


(list->tree '(1 3 5 7 9 11))
;; (5 (1 () (3 () ())) (9 (7 () ()) (11 () ())))
