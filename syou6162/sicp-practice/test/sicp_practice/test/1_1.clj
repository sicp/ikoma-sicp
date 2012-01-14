(ns sicp-practice.test.1-1
  (:use [sicp-practice.1-1])
  (:use [clojure.test]))

(deftest test-problem1-3
  (is (= (problem1-3 1 2 3) 13))) ; 2^2 + 3^2 = 4 + 9 = 13

