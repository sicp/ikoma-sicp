(load-file "2_7.clj")
(load-file "2_12.clj")

(defn part1 [r1 r2]
  (div-interval (mul-interval r1 r2)
                (add-interval r1 r2)))

(defn part2 [r1 r2]
  (let [one (make-interval 1 1)]
       (div-interval one
                     (add-interval (div-interval one r1)
                                   (div-interval one r2)))))

; user=> (part1 (make-interval 1 2) (make-interval 3 4))
; (0.5 2.0)
; user=> (part2 (make-interval 1 2) (make-interval 3 4))
; (0.75 1.3333333333333333)

; (part1 (make-center-percent 1 0.0001) (make-center-percent 3 0.0001))
; (part2 (make-center-percent 1 0.0001) (make-center-percent 3 0.0001))

(def interval_a (make-interval 1 3))
(def interval_b (make-interval 5 9))
(def interval_c (make-center-percent 1 0.000001))

(def div1 (div-interval interval_a interval_a))
; (0.3333333333333333 3.0)
; 可愛い 1 だと思った? 残念！全然違う値ちゃんでした！
(def div2 (div-interval interval_a interval_b))
; (0.1111111111111111 0.6000000000000001)
(def div3 (div-interval interval_c interval_c))
; (0.9999999800000002 1.00000002)
; 幅が小さい時は非常に近い値になりそう

; 解釈: 幅が大きい区間 interval_x では interval_x / interval_x = 1 とは非常になりにくい
; part1 は式変形の過程において 1 / interval_x * (interval_x * interval_y) = interval_y としているため，おかしくなる

