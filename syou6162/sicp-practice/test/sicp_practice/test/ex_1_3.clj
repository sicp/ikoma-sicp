(ns sicp-practice.test.ex-1-3
  (:use [sicp-practice.ex-1-3])
  (:use [clojure.test]))

(deftest test-problem1-3
  (is (= (problem1-3 1 2 3) 13))) ; 2^2 + 3^2 = 4 + 9 = 13
