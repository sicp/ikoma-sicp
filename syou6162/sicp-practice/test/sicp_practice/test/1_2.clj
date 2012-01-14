(ns sicp-practice.test.1-2
  (:use [sicp-practice.1-2])
  (:use [clojure.test]))

(deftest test-my-fact
  (is (= (my-fact 5) 120)))

(deftest test-fib-recur
  (is (= (fib-recur 0) 0))
  (is (= (fib-recur 1) 1))
  (is (= (fib-recur 2) 1))
  (is (= (fib-recur 3) 2))
  (is (= (fib-recur 4) 3))
  (is (= (fib-recur 5) 5)))

(deftest test-fib
  (is (= (fib 0) 0))
  (is (= (fib 1) 1))
  (is (= (fib 2) 1))
  (is (= (fib 3) 2))
  (is (= (fib 4) 3))
  (is (= (fib 5) 5)))
