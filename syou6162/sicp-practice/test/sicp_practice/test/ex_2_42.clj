(ns sicp-practice.test.ex-2-42
  (:use [sicp-practice.ex-2-42])
  (:use [clojure.test]))

(deftest test-adjoin-position
  (is (= (adjoin-position
	  3
	  4
	  (adjoin-position 1 2 '()))
	 '((3 4) (1 2)))))

(deftest test-conflicts?
  ;; conflictsしないケース
  ;; *--
  ;; ---
  ;; -*-
  (is (= false (conflicts? '(1 1) '(3 2))))
  ;; conflictsするケース
  ;; *--
  ;; -*-
  (is (= true (conflicts? '(1 1) '(2 2)))))

(deftest test-queens
  (is (= 92 (count (queens 8))))
  (is (= (pmap #(count (queens %)) (range 1 9)) ;; pmap for speed
	 '(1 0 0 2 10 4 40 92))))
