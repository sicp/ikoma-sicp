(ns sicp-practice.test.1-2
  (:use [sicp-practice.1-2])
  (:use [clojure.test]))

(deftest test-my-fact
  (is (= (my-fact 5) 120)))