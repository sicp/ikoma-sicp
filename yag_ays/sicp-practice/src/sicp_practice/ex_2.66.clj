(defn lookup [given-key set-of-records]
  (cond (empty? set-of-records) false
        (equal? given-key (key (first set-of-records))) (first set-of-records)
        :else (lookup given-key (rest set-of-records))))

(defn entry [tree] (first tree))
(defn left-branch [tree] (first (next tree)))
(defn right-branch [tree] (first (next (next tree))))


;; ex_2.66

(defn lookup [given-key tree-of-records]
  (cond (empty? tree-of-records) false
        (= given-key (key (entry tree-of-records))) (entry tree-of-records)
        (> given-key (key (entry tree-of-records))) (lookup given-key
                                                            (left-branch tree-of-records))
        (< given-key (key (entry tree-of-records))) (lookup given-key
                                                            (right-branch tree-of-records))))

