(ns sicp-practice.ex-2-47)

;; さぼって最初のリストのほうのやつしか実装していません...

(defn make-frame [origin edge1 edge2]
  (list origin edge1 edge2))

(defn origin-frame [frame]
  (first frame))

(defn edge1-frame [frame]
  (second frame))

(defn edge2-frame [frame]
  (last frame))
