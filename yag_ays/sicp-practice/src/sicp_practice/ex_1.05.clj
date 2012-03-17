;; Ans. 正規順序の場合では(p) -> (p)を繰り返すのでtestが評価されない

;; 正規順序の場合
(test 0 (p))
(test 0 (p)) ; (p)を展開して(p)になる
;; 以下無限ループ


;; 作用的順序の場合
(test 0 (p))
(if (= 0 0) 0 (p))
0