10

; 足すだけ
(+ 5 3 4)

(- 9 1)

(/ 6 2)

(+ (* 2 4) (- 4 6))

; clojureはdefineじゃなくてdef
(def a 3)

(def b (+ a 1)) ;(def b 4)

(+ a b (* a b)) ;19 <= 3 + 4 + 3*4

(= a b) ;false

(if (and (> b a) (< b (* a b)))
  b
  a);4 <= (4 > 3) && (4 < 12)

; condは文法が違うので要警戒
(cond (= a 4) 6
      (= b 4) (+ 6 7 a)
      :else 25) ; b == 4 => (6 + 7 + 3) => 16

(+ 2 (if (> b a) b a)); 2 + (4 > 3 => 4) => 2 + 4 => 6

(* (cond (> a b) a
         (< a b) b
         :else -1)
   (+ a 1)); (3 < 4 => b) * (a+1) => 4 * 4 => 16

