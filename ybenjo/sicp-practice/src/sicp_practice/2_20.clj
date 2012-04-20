(defn same-parity [& args]
  (let [parity (if (even? (first args)) even?
                   odd?)]
    (filter #(parity %) args)))