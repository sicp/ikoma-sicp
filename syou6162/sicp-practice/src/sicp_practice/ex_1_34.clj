(ns sicp-practice.ex-1-34)

(defn f [g] (g 2))

(defn square [x] (* x x))

(f square) ; 4

(f (fn [z] (* z (+ z 1)))) ; 6

;; 意地悪くfを引数に取らせてみる
; (f f) ; java.lang.Long cannot be cast to clojure.lang.IFn

;; 展開してみる
; (f f)
; (f 2)
; (2 2)
; 死ぬ
