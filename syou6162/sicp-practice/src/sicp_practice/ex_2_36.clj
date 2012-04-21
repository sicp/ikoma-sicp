(ns sicp-practice.ex-2-36)

(defn accumulate-n [op init seqs]
  (if (empty? (first seqs))
    nil
    (cons (reduce op init (map first seqs))
	  (accumulate-n op init (map rest seqs)))))

(accumulate-n + 0 '((1 2 3) (4 5 6) (7 8 9) (10 11 12))) ; (22 26 30)