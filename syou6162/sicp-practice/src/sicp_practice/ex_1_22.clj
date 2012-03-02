(ns sicp-practice.ex-1-22
  (:use sicp-practice.ex-1-21))

;; (partial + 1)は引数を取って+2だけする関数
;; iterateは最初の入力をxとするとx、f(x)、f(f(x))、f(f(f(x)))というsequenceを返す便利関数です
;; 特にこの例のように終わりがいつか分からないようなsequenceの場合に特に便利

(time (take 3 (filter prime? (iterate (partial + 2) 1001))))
; "Elapsed time: 0.077 msecs" (1009 1013 1019)

(time (take 3 (filter prime? (iterate (partial + 2) 10001))))
; "Elapsed time: 0.071 msecs" (10007 10009 10037)

(time (take 3 (filter prime? (iterate (partial + 2) 100001))))
; "Elapsed time: 0.069 msecs" (100003 100019 100043)


(time (take 3 (filter prime? (iterate (partial + 2) 1000001))))
; "Elapsed time: 0.071 msecs" (1000003 1000033 1000037)

;; すぐ終わってしまって比較にならなかったです...
