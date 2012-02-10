(ns sicp-practice.test.ex-1-4
  (:use [sicp-practice.ex-1-4])
  (:use [clojure.test]))

(deftest test-a-plus-abs-b
  (is (= (a-plus-abs-b 1 3) 4))
  (is (= (a-plus-abs-b 1 (- 3)) 4))
  (is (= (a-plus-abs-b 1 (- 10)) 11)))
