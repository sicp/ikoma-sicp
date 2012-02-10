(ns sicp-practice.test.1-1
  (:use [sicp-practice.1-1])
  (:use [clojure.test]))

(deftest test-sqrt
  (is (< (Math/abs (- 3.0 (sqrt 9))) 0.001))
  (is (< (Math/abs (- 11.704699917758145 (sqrt (+ 100 37)))) 0.001)))

(deftest test-sqrt1-1-8
  (is (< (Math/abs (- 3.0 (sqrt 9))) 0.001))
  (is (< (Math/abs (- 11.704699917758145 (sqrt (+ 100 37)))) 0.001)))
