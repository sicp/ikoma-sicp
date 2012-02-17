(ns sicp-practice.test.ex-1-12
  (:use [sicp-practice.ex-1-12])
  (:use [clojure.test]))

(deftest test-pascal
  (is (= (pascal 1 1) 1))
  (is (= (pascal 3 2) 2))
  (is (= (pascal 5 3) 6)))
