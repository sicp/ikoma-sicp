(defn square [x] (* x x))

(defn compose [f g] #(f (g %)))

; ((compose square inc) 6)
; 49

; 最初 (defn compose [f g x] (f (g x))) って書いて
; (compose square inc 6) を実行していた