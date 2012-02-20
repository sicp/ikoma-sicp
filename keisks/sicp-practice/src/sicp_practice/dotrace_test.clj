(use 'clojure.tools.trace)

(defn ^:dynamic fact [n]
  (if (= n 1)
    1
    (* n (#'fact (- n 1)))))

(dotrace [fact] (fact 5))
