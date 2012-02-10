(ns sicp-practice.test.ex-1-6
  (:use [sicp-practice.ex-1-6])
  (:use [clojure.test]))

(deftest test-new-if
  (is (= (new-if (= 2 3) 0 5) 5))
  (is (= (new-if (= 1 1) 0 5) 0)))

(deftest test-problem-1-6-sqrt-iter
  (is (thrown? StackOverflowError
	       (problem-1-6-sqrt-iter 1.0 9))))