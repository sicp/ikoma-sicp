;; 1.3.3節のfixed-pointおよびaverage-damp
(def tolerance 0.00001)
(defn fixed-point [f first-guess]
  (defn close-enough? [v1 v2]
    (< (Math/abs (- v1 v2)) tolerance))
  (defn my-try [guess]
    (let [nxt (f guess)]
      (if (close-enough? guess nxt)
        nxt
        (my-try nxt))))
    (my-try first-guess))

(defn average [x y]
  (/ (+ x y) 2))
(defn average-damp [f]
  (fn [x] (average x (f x))))

;; 使い方
(defn sqrt [x]
  (fixed-point (average-damp (fn [y] (/ x y))) 1.0))
(sqrt 2)


;; 1.43のrepeated
(defn repeated [f t]
  (if (zero? t)
    identity
    (comp f (repeated f (dec t)))))



;; ==================================================
;; 本題 (ex_1.45)

;; fixed-pointとaverage-dampおよびlambdaの処理を纏めておく
(defn calc-root [f a l]
  (f (a l) 1.0))



;; 単一の平均緩和で立方根は計算出来る
(defn cube-root [x]
  (calc-root fixed-point
            average-damp
            (fn [y] (/ x (* y y)))))
(cube-root 2)
;; 1.259923236422975



;; 単一の平均緩和では四乗根は計算出来無い
(defn forth-root [x]
  (calc-root fixed-point
            average-damp
            (fn [y] (/ x (* y y y)))))
(forth-root 2)
;; No message.
;;   [Thrown class java.lang.StackOverflowError]



;; 二回平均緩和を使うと不動点探索は収束する
(defn forth-root [x]
  (calc-root fixed-point
            (repeated average-damp 2)
            (fn [y] (/ x (* y y y)))))
(forth-root 2)
;; 1.189207115002721


(defn fifth-root [x]
  (calc-root fixed-point
            (repeated average-damp 2)
            (fn [y] (/ x (* y y y y)))))
(fifth-root 2)
;; 1.1486967244204176

(defn sixth-root [x]
  (calc-root fixed-point
            (repeated average-damp 2)
            (fn [y] (/ x (* y y y y y)))))
(sixth-root 2)
;; 1.1224648393618204

(defn sevecalc-root [x]
  (calc-root fixed-point
            (repeated average-damp 2)
            (fn [y] (/ x (* y y y y y y)))))
(sevecalc-root 2)
;; 1.1040857488809648



;; 二階平均緩和では八乗根は計算出来無い
(defn eighth-root [x]
  (calc-root fixed-point
            (repeated average-damp 2)
            (fn [y] (/ x (* y y y y y y y)))))
(eighth-root 2)
;; No message.
;;   [Thrown class java.lang.StackOverflowError]

;; 三回平均緩和を使うと計算出来る
(defn eighth-root [x]
  (calc-root fixed-point
            (repeated average-damp 3)
            (fn [y] (/ x (* y y y y y y y)))))
(eighth-root 2)
;; 1.090507732665258



;; average-dampが3回必要になるところは...?
(defn fifteenth-root [x]
  (calc-root fixed-point
            (repeated average-damp 3)
            (fn [y] (/ x (apply * (repeat (dec 15) y)))))) ;; applyとrepeatを使って，yを14回掛け合わせている
(fifteenth-root 2)
;; 1.0472983541977883

(defn sixteenth-root [x]
  (calc-root fixed-point
            (repeated average-damp 3)
            (fn [y] (/ x (apply * (renpeat (dec 16) y))))))
(sixteenth-root 2)
;; No message.
;;   [Thrown class java.lang.StackOverflowError]




;; ==================================================
;; まとめ
;; average-damp 1回 -> 3rdまで  (4th未満)
;; average-damp 2回 -> 7thまで  (8th未満)
;; average-damp 3回 -> 15thまで (16th未満)


(defn nth-root [x n]
  (defn damp-count [m]
    (if (< m 2)
      0
      (inc (damp-count (/ m 2)))))
  (calc-root fixed-point
             (repeated average-damp (damp-count n))
             (fn [y] (/ x (apply * (repeat (dec n) y))))))

(nth-root 2 16)
;; 1.0442737824274144

(nth-root 2 100)
;; 1.006958277553065
