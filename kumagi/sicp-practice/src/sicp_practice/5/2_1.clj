(cons 1 (cons 2 ()))      ; => (3 1) 普通にcons使うとめんどくさい
(rest (cons 3 (cons 1 ())))

(list 1 2) ; SICPはドット対を要求してる気がするけどlistで代用

(defn gcd [a b]
  (if (= b 0) a
      (gcd b (rem a b))))
(gcd 10 8)

(defn make-rat [n d]
  (let [common (gcd n d)]
    (let [devided-n (/ n common)
          devided-d (/ d common)]
      (if (< devided-d 0) (list (* devided-n -1) (* devided-d -1))
          (list devided-n devided-d)))))

(make-rat 6 9) ; (2 3)
(make-rat 6 -9) ; (-2 3)
(make-rat -6 9) ; (-2 3)
(make-rat -6 -9) ; (2 3)

(println (* -6 -6))
