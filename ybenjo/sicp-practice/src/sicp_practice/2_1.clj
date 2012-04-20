(defn make-rat [x y]
  (if (> (* x y) 0) (list (Math/abs x) (Math/abs y))
      (list (* -1 (Math/abs x)) (Math/abs y))))