(ns kumagi)
(defn func-double [func]
  (fn [x] (func (func x))))
((func-double inc) 3) ; => 5

((func-double inc) 5) ; => 7 # 2足してる
(((func-double func-double) inc) 5) ; => 9 # 4足してる
((func-double ((func-double func-double)inc)) 5) ; => 13 # 8足してる

(((func-double (func-double func-double))inc) 5) ; => 21 # 16足してる

; (func-double func-double) => 渡された関数を2回行う関数を2回行う
; (func-double (渡された関数を2回行う関数を2回行う)) => 渡された関数を2回行う関数を2回
; ((…あれ？
