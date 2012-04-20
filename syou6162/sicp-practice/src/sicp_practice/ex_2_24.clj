(ns sicp-practice.ex-2-24)

(list 1 (list 2 (list 3 4))) ; (1 (2 (3 4)))

;; 木の解釈
;; https://github.com/sicp/ikoma-sicp/blob/master/syou6162/sicp-practice/resources/ex_2_24_tree.pdf?raw=true

;; 箱とポインタ構造。簡単やん、と思ったら(list 1 2 3 4)との違いが分からなくなる。。。
;; https://github.com/sicp/ikoma-sicp/blob/master/syou6162/sicp-practice/resources/ex_2_24_box_wrong.pdf?raw=true

;; (1 (2 (3 4)))は`(cons 1 '(2 (3 4)))`ではなく`(cons 1 '((2 (3 4))))`であるということに気がつく...!
;; 対を作るときに何と何の対を作っているかをきちんと意識する
;; これが理解できれば、こういう図を書くことができる
;; https://github.com/sicp/ikoma-sicp/blob/master/syou6162/sicp-practice/resources/ex_2_24_box.pdf?raw=true