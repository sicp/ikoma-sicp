(defn for-each [proc items]
  (if (empty? items)
    nil
    (do (proc (first items))
        (for-each proc (rest items)))))

(for-each #(println %) (list 57 321 88))
