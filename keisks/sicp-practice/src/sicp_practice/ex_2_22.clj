; 1つめのコード: consの項が逆であるため
;
; 2つめのコード: listと次の項をconsしているため

; consではなくappendしていけば良い。

(defn square [x]
  (* x x))

(defn square-list [items]
  (defn iter [things answer]
    (if (empty? things)
      answer
      (iter (rest things)
            (concat answer
                    (list (square (first things)))))))
  (iter items nil))

(square-list '(1 2 3 4))
;(1 4 9 16)
