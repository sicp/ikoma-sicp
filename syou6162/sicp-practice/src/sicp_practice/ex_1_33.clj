(ns sicp-practice.ex-1-33
  (:use sicp-practice.ex-1-21))

;; (a)だけ
;; 素数の二乗和をClojureの組込みで。そういう趣旨の問題じゃないのは分かってます...w
(reduce (fn [cum x]
	  (+ cum (square x)))
	0 (filter prime? (range 11))) ; 88

