(defn square [x] (* x x))

(defn compose [f g]
  (fn [x] (f (g x))))

((compose square inc) 6)


;; comp関数でも同様に関数合成が出来る
((comp square inc) 6)

;; sourceが面白い
(use 'clojure.contrib.repl-utils)
(source comp)
