(create-ns 'kumagi')

(defn cons-alt [x y]
  (fn [m] (m x y)))
(defn car [z]
  (z (fn [p q] p)))

(car (cons-alt 1 2)) ; => 1

(defn cdr [z]
  (z (fn [p q] q)))
(cdr (cons-alt 1 2)) ; => 2

(comment
  (cons-alt a b)は「関数を1つ取ってそれにa bを食わせる関数」を返す
  (car c)は「与えられたcに「1引数目を返す2引数関数」を食わせた結果を返す)
(comment
    よって(car (cons-alt 1 2))は「2引数関数を1つとってそれに1 2を食わせる関数に、与えられた引数のうち一つ目を返す2引数関数を食わせている」よって1が返る)
