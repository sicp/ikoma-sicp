(defn square [x] (* x x))

;; この反復プロセスの実装の場合...
(defn square-list [items]
  (defn iter [things answer]
    (if (empty? things)
      answer
      (iter (rest things)
            (cons (square (first things))
                  answer))))
  (iter items nil))

(square-list '(1 2 3 4))
;; (16 9 4 1)

;; (cons 1 nil)
;; (cons 4 (cons 1 nil))
;; (cons 9 (cons 4 (cons 1 nil)))
;; (cons 16 (cons 9 (cons 4 (cons 1 nil))))
;; となってしまい，順序が逆になってしまう


;; consの引数を交換してみる
(defn square-list [items]
  (defn iter [things answer]
    (if (empty? things)
      answer
      (iter (rest things)
            (cons answer
                  (square (first things))))))
  (iter items nil))
(square-list '(1 2 3 4))
;; Don't know how to create ISeq from: java.lang.Integer
;;   [Thrown class java.lang.IllegalArgumentException]
;; (cons nil 1)を評価できない


;; iterに渡す引数answerをlistにしてみる
(defn square-list [items]
  (defn iter [things answer]
    (if (empty? things)
      answer
      (iter (rest things)
            (cons answer
                  (square (first things))))))
  (iter items '()))
(square-list '(1 2 3 4))
;; Don't know how to create ISeq from: java.lang.Integer
;;   [Thrown class java.lang.IllegalArgumentException]
;; 同様に(cons '() 1)となり，評価できない


;; consの第二引数をlistにしてみる
(defn square-list [items]
  (defn iter [things answer]
    (if (empty? things)
      answer
      (iter (rest things)
            (cons answer
                  (list (square (first things)))))))
  (iter items nil))
(square-list '(1 2 3 4))
;; ((((nil 1) 4) 9) 16)
;; listがネストしてしまう
;; 注：(これが本来schemeで実装した場合におけるex_2.22後半部の解答かもしれない)


;; consをconcat(append)すると...
(defn square-list [items]
  (defn iter [things answer]
    (if (empty? things)
      answer
      (iter (rest things)
            (concat answer
                    (list (square (first things)))))))
  (iter items nil))
(square-list '(1 2 3 4))
;; (1 4 9 16)
;; これで成功する
