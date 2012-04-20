(defn same-parity [& args]
  (let [parity (if (even? (first args)) even?
                   odd?)]
    (filter #(parity %) args)))

; 前を読んで無かったので問題の意図を全く理解していなかった
(defn correct-same-parity [num & args]
  (defn same-parity-iter [parity arys ans]
    (if (empty? arys) ans
        (if (parity (first arys)) (same-parity-iter parity (rest arys) (concat ans (list (first arys))))
            (same-parity-iter parity (rest arys) ans))
        )
    )
  (let [parity (if (even? num) even?
                   odd?)]
    (same-parity-iter parity (cons num args) (list ))))