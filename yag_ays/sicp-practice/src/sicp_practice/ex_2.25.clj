(def x '(1 3 (5 7) 9))
(def y '((7)))
(def z '(1 (2 (3 (4 (5 (6 7)))))))

(first (rest (first (rest (rest x)))))
(first (first y))
(first (rest (first (rest (first (rest (first (rest (first (rest (first (rest z))))))))))))
