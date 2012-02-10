(ns sicp-practice.ex-1-9)
;; 問題1.9

(use 'clojure.tools.trace)

(defn ^:dynamic my-plus1 [a b]
  (if (= a 0)
    b
    (inc (#'my-plus1 (dec a) b))))

(my-plus1 10 5) ; 15
;; 再帰的な様子
(dotrace [my-plus1] (my-plus1 10 5))

(defn ^:dynamic my-plus2 [a b]
  (if (= a 0)
    b
    (#'my-plus2 (dec a) (inc b))))

;; 反復的な様子...のはずが再帰的になってしまう
(dotrace [my-plus2] (my-plus2 10 5))
;; 証拠
;; (my-plus2 10000 5000)
;; StackOverflowError

(defn ^:dynamic my-plus3 [a b]
  (if (= a 0)
    b
    (recur (dec a) (inc b))))
(my-plus3 10000 5000)
(dotrace [my-plus3] (my-plus3 10 5)) ;; traceはしてくれない
