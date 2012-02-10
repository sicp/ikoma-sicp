(ns sicp-practice.test.ex-1-10
  (:use [sicp-practice.ex-1-10])
  (:use [clojure.test]))

(deftest test-Ackermann
  (is (= (A 1 10) 1024))
  (is (= (A 2 4) 65536))
  (is (= (A 3 3) 65536))

  (is (= (map f (range 10))
	 '(0 2 4 6 8 10 12 14 16 18)))
  (is (= (map g (range 10))
	 '(0 2 4 8 16 32 64 128 256 512)))
  (is (= (map h (range 5))
	 '(0 2 4 16 65536))))
