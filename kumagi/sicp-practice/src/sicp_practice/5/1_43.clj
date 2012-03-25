(ns kumagi)

(defn square [x] (* x x))

(defn repeated [func n]
  (fn [x]
    (cond (= n 1) (func x)
          :else ((repeated func (- n 1)) (func x)))))

((repeated square 2) 5) ; => 625
