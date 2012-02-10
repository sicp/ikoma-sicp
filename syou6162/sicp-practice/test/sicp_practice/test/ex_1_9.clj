(ns sicp-practice.test.ex-1-9
  (:use [sicp-practice.ex-1-9])
  (:use [clojure.test]))

(deftest test-my-plus
  (is (= (my-plus1 10 5) 15))
  (is (= (my-plus2 10 5) 15))
  (is (= (my-plus3 10 5) 15)))
