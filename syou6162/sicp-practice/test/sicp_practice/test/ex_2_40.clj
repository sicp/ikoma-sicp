(ns sicp-practice.test.ex-2-40
  (:use [sicp-practice.ex-2-40])
  (:use [clojure.test]))

(deftest test-enumerate-interval
  (is (= (enumerate-interval 1 5)
	 '(1 2 3 4 5))))

(defn inc-list [xs]
  (map inc xs))

(deftest test-flatmap
  (is (= (flatmap inc-list '((1 2 3) (4 5 6) (7 8 9)))
	 (list 2 3 4 5 6 7 8 9 10))))

(deftest test-unique-pairs
  (is (= (unique-pairs 5)
	 '((2 1) (3 1) (3 2) (4 1) (4 2)
	   (4 3) (5 1) (5 2) (5 3) (5 4)))))

(deftest test-prime-sum-pair
  (is (= (prime-sum-pair 6)
	 '((2 1 3) (3 2 5) (4 1 5) (4 3 7)
	   (5 2 7) (6 1 7) (6 5 11)))))
